package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetRoomLogic;
import model.GetTaskLogic;
import model.PostTaskLogic;
import model.RoomPass;
import model.Taskitiran;

/**
 * Servlet implementation class RoomServlet
 */
@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//文字コードをUTF-8で設定
	request.setCharacterEncoding("UTF-8");

	//リクエストパラメータの取得
	String tasks = request.getParameter("task");

	//部屋ID情報をセッションスコープから取得
	HttpSession session = request.getSession();
	String sessionId = (String)session.getAttribute("RoomID");


	//Taskインスタンスの生成
	Taskitiran roomtask = new Taskitiran (sessionId,tasks);

	//Taskを入力
	PostTaskLogic PostTaskLogic = new PostTaskLogic();
	PostTaskLogic.execute(roomtask);


	// タスクリストを取得して、リクエストスコープに保存
	 GetTaskLogic getTaskListLogic = new GetTaskLogic();
	 List<Taskitiran> TaskList = getTaskListLogic.execute(roomtask);
	 request.setAttribute("TaskList", TaskList);


	//フォワード
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
	dispatcher.forward(request, response);

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//部屋ID情報をセッションスコープから取得
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("RoomID");

		//部屋ID情報をセッションスコープから削除
		session.removeAttribute("RoomID");

		//RoomIDを格納したインスタンス作成
		RoomPass room = new RoomPass (sessionId);

		//RoomIDとPASS格納したインスタンス取得
		GetRoomLogic GetRoomLogic = new GetRoomLogic();
		room = GetRoomLogic.execute(room);

		//URL作成
		String roomid = room.getRoomId();
		String password = room.getRoomPass();
		String url = "http://localhost:8080/KEIKAKU/UserList?roomid="+ roomid +"&password="+password;

		//URLをリクエストスコープに保存
		request.setAttribute("URL", url);

	//フォワード
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/room.jsp");
	dispatcher.forward(request, response);

	}

}
