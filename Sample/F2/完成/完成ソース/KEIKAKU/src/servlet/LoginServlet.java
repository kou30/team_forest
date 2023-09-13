package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PostRoomListLogic;
import model.RoomPass;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//文字コードをUTF-8で設定
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの取得
		String passnow = request.getParameter("pass");

		//Roomインスタンス（RoomPass）の生成
		RoomPass room = new RoomPass ();
		room.setRoomPass(passnow);

		//RoomIdを入力
		PostRoomListLogic PostRoomListLogic = new PostRoomListLogic();
		String RoomId= PostRoomListLogic.execute(room);

		//部屋ID情報をセッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("RoomID", RoomId);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
		}

	}
