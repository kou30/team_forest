package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String forwardPath = null;

		forwardPath = "/WEB-INF/jsp/login.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		// Userインスタンス（ユーザー情報）の生成
		User user = new User(name, pass);

		// ログイン処理
		LoginLogic loginLogic = new LoginLogic();
		User loginUser = loginLogic.execute(user);

		// ログイン成功時の処理
		if (loginUser != null) {
			// ユーザー情報をセッションスコープに保存
			user = loginUser;
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
		}
		// 成功時、ホームにフォワード
		if (loginUser != null) {

			RequestDispatcher dispatcher =
					request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} else {
			// エラーポップアップ
			request.setAttribute("errorMsg","ログインを失敗しました。");
			// ログイン画面へ戻る
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
