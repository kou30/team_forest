package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String click =request.getParameter("yesno");

		if (click != null) {
			if (click.equals ("Yes")) {

				//sessionスコープを破棄
			HttpSession session =request.getSession();
			session.invalidate();

			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"WEB-INF/jsp/logout.jsp");
			dispatcher.forward(request,response);

			}
			else {
				RequestDispatcher dispatcher =
						request.getRequestDispatcher(
								"WEB-INF/jsp/message.jsp");
				dispatcher.forward(request,response);
			}
		}

			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"WEB-INF/jsp/logoutConfirm.jsp");
			dispatcher.forward(request,response);


	}

}
