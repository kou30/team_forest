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

import model.Reserve;
import model.ReserveLogic;
import model.User;

/**
 * Servlet implementation class ReservationStatus
 */
@WebServlet("/ReservationStatus")
public class ReservationStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservationStatus() {
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
			// ログインユーザーの予約状況へ
			forwardPath = "/WEB-INF/jsp/reservationStatus.jsp";
		}
		// 個人の予約リストを取得して、リクエストスコープに保存
		//##########################
		//### ここにコードを書く ###
		//##########################
		ReserveLogic reserveLogic = new ReserveLogic();
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		List<Reserve> reserveList = reserveLogic.findFromUser(loginUser.getName());
		for(Reserve reserve:reserveList) {

		}
		request.setAttribute("reserveList", reserveList);

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
			forwardPath = "/WEB-INF/jsp/reservationStatus.jsp";
		}
		// 個人の予約リストを取得して、リクエストスコープに保存
		//##########################
		//### ここにコードを書く ###
		//##########################
		request.setCharacterEncoding("UTF-8");
		int reserveId = Integer.parseInt(request.getParameter("reserveId"));
		ReserveLogic reserveLogic = new ReserveLogic();

		reserveLogic.delete(reserveId);

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		List<Reserve> reserveList = reserveLogic.findFromUser(loginUser.getName());
		request.setAttribute("reserveList", reserveList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);

	}

}
