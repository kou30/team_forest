package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Reserve;
import model.ReserveLogic;
import model.User;

/**
 * Servlet implementation class Reserve
 */
@WebServlet("/Reserve")
public class ReserveList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReserveList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String forwardPath = null;
		String action = request.getParameter("action");

		if (action == null) {
			forwardPath = "/index.jsp"; // ここは通らない
		}

		if (action != null && action.equals("done")) {
			// "予約"画面へ
			forwardPath = "/WEB-INF/jsp/reserve.jsp";
		}
		// 特定ネコの予約リストを取得して、リクエストスコープに保存
		//##########################
		//### ここにコードを書く ###
		//##########################
		String stCatId = request.getParameter("catId");
		int catId = Integer.parseInt(stCatId);
		ReserveLogic reserveLogic = new ReserveLogic();
		List<Reserve> reserveList = reserveLogic.findFromCat(catId);
		request.setAttribute("reserveList", reserveList);
		request.setAttribute("catId", catId);
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String forwardPath = null;
		String action = request.getParameter("action");

		if (action == null) {
			forwardPath = "/index.jsp"; // ここは通らない
		}

		if (action != null && action.equals("done")) {
			// ログインユーザーの予約状況へ
			forwardPath = "/WEB-INF/jsp/reservationStatus";
		}
		// ネコ予約追加
		//##########################
		//### ここにコードを書く ###
		//##########################
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		int catId = Integer.parseInt(request.getParameter("catId"));
		Date date = Date.valueOf((request.getParameter("date").replace("/", "-")));
		//POSTした時の文字コードを考慮
		String comment = new String(request.getParameter("comment").getBytes("ISO-8859-1"));
		Reserve reserve = new Reserve(loginUser.getName(), catId, date, comment);
		ReserveLogic reserveLogic = new ReserveLogic();

		reserveLogic.create(reserve);

		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
		//

	}

}
