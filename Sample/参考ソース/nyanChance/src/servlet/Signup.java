package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserLogic;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 登録ページに飛ぶ。
		String forwardNextPath = null;
		forwardNextPath = "/WEB-INF/jsp/signup.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardNextPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String tell = request.getParameter("tell");

		Date nowDate = new Date();
		String date = new SimpleDateFormat("yyyy-MM-dd").format(nowDate);
		java.sql.Date createDate = java.sql.Date.valueOf(date);

		boolean superUser = false;

		// 入力値チェック
		if (name == "" ) {
			// エラーメッセージをリクエストスコープに保存
						request.setAttribute("errorMsg","名前が書かれていません。");

		} else if (pass == "" ) {
			// エラーメッセージをリクエストスコープに保存
						request.setAttribute("errorMsg","パスワードが入力されていません。");

		} else if (tell == "" ) {
			// エラーメッセージをリクエストスコープに保存
						request.setAttribute("errorMsg","電話番号が記入されていません。");

		} else if (name != null && name.length() <= 20  && pass != null && pass.length() <= 10 && tell != null && tell.length()  <= 12) {
			// Userリストに追加
			User user = new User(name, pass, tell, createDate, superUser);
			UserLogic UserLogic = new UserLogic();
			boolean check = UserLogic.create(user);
			if(check == false) {
				request.setAttribute("errorMsg","重複したIDが含まれています。");
				String forwardNextPath = "/WEB-INF/jsp/signup.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardNextPath);
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("msg","新規登録を行いました。");
			}


			String forwardNextPath = "/WEB-INF/jsp/login.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardNextPath);
			dispatcher.forward(request, response);
		}else {
			// エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg","入力欄に規定の内容になっていません。");

		}
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
		dispatcher.forward(request, response);
	}

}
