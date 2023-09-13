package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetTaskDeleteLogic;
import model.RoomPass;

@WebServlet("/TaskDeleteServlet")
public class TaskDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//部屋ID情報をセッションスコープから取得
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("RoomID");

		//RoomIDを格納したインスタンス作成
		RoomPass room = new RoomPass (sessionId);

		//RoomIDとPASS格納したインスタンス取得
		GetTaskDeleteLogic getTaskDeleteLogic = new GetTaskDeleteLogic();
		getTaskDeleteLogic.execute(room);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
	}
}