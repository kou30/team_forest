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

import model.GetTaskListLogic;
import model.PostStatusLogic;
import model.PostUserid;
import model.Task;
import model.User;
/**
 * Servlet implementation class UserCreate
 */
@WebServlet("/TaskList")
public class TaskList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
	HttpSession session  = request.getSession();

	//セッションスコープに保存されたユーザー情報を取得
	User loginuser=(User)session.getAttribute("loginUser");
	String room=loginuser.getRoomid();
	String userid=loginuser.getUserid();

	//ユーザーIDをアップデート
	PostUserid postUserid=
			new PostUserid();
	postUserid.execute(room,userid);

		// タスク情報を取得して、セッションスコープに保存
		GetTaskListLogic getTaskListLogic=
				new GetTaskListLogic();
		List<Task> taskList=getTaskListLogic.execute(room);
	session.setAttribute("taskList",taskList);

		RequestDispatcher dispatcher=
				request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);

	}
	//STATUSをUPDATEする文
protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
			//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");

		//セッションスコープに保存されたユーザー情報を取得
		HttpSession session=request.getSession();
		User loginuser=(User)session.getAttribute("loginUser");
		String room=loginuser.getRoomid();
		String userid=loginuser.getUserid();

		//タスク情報をおくる

		//String  roomid=request.getParameter("roomid");//Integer.parseInt(request.getParameter("roomid"));
		String taskname=request.getParameter("taskname");
		String status=request.getParameter("status");
		String color=request.getParameter("color");


		System.out.println(taskname);
		//タスク情報をタスクリストに追加
		Task task=new Task(room,taskname,status,userid,color);
		PostStatusLogic postStatusLogic=new PostStatusLogic();
		postStatusLogic.execute(task);

		//タスクリストに入れなおす
		GetTaskListLogic getTaskListLogic=
				new GetTaskListLogic();
		List<Task> taskList=getTaskListLogic.execute(room);
		session.setAttribute("taskList",taskList);

		//タスクリストを取得してセッションスコープに保存
		//HttpSession session=request.getSession();
		//session.setAttribute("taskList",task);


		//メイン画面にフォワード
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);


}
}