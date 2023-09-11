package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cat;
import model.CatLogic;

/**
 * Servlet implementation class Achievement
 */
@WebServlet("/Achievement")
public class Achievement extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Achievement() {
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
		String action = request.getParameter("action");

		if(action == null) {
			forwardPath = "/index.jsp";		// ここは通らない
		}

		if(action != null && action.equals("done")) {
			forwardPath = "/WEB-INF/jsp/achievement.jsp";
		}
		// ネコの実績リストを取得して、リクエストスコープに保存
		//##########################
		//### ここにコードを書く ###
		//##########################
		CatLogic CatLogic =
				new CatLogic();
		List<Cat>catList = CatLogic.findFin();
		request.setAttribute("catList", catList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
