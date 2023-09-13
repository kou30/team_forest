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

import model.GetUserListLogic;
import model.GetUserid;
import model.PostUserLogic;
import model.User;
/**
 * Servlet implementation class UserCreate
 */
@WebServlet("/UserList")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String room=request.getParameter("roomid");
		//String room="1";
		//String password=request.getParameter("password");

		// ユーザー情報を取得して、リクエストスコープに保存
		GetUserListLogic getUserListLogic=
				new GetUserListLogic();
		List<User> userList=getUserListLogic.execute(room);
		request.setAttribute("userList",userList);

		//roomidをセッションスコープに保存
		User user=new User();
		user.setRoomid(room);
		HttpSession session=request.getSession();
		session.setAttribute("loginUser",user);


		RequestDispatcher dispatcher=
				request.getRequestDispatcher("WEB-INF/jsp/usercreate.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String  roomid=request.getParameter("roomid");//Integer.parseInt(request.getParameter("roomid"));
		String name=request.getParameter("name");
		String color=request.getParameter("color");

		//ユーザー情報をユーザーリストに追加
			User user=new User(roomid,name,color);
			PostUserLogic postUserLogic=new PostUserLogic();
			postUserLogic.execute(user);


		//ルームIDとユーザーIDを取得
			GetUserid getuserid=new GetUserid();
			String userid =getuserid.execute(roomid);
			user.setUserid(userid);
			System.out.println(userid);

		//ユーザーリストを取得してセッションスコー プに保存

		HttpSession session=request.getSession();
		session.setAttribute("loginUser",user);





		//	↓さわらない
			response.sendRedirect("/KEIKAKU/TaskList");
		//getServletContext().getRequestDispatcher("/TaskList").forward(request, response);

	}

}
