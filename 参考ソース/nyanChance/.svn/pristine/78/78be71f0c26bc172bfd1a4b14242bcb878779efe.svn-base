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

/*****
 * Servlet implementation class CatList
 */
@WebServlet("/CatList")
public class CatList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatList() {
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
			forwardPath = "/WEB-INF/jsp/catList.jsp";
		}
		// ネコリストを取得して、リクエストスコープに保存
		CatLogic CatLogic =
				new CatLogic();
		List<Cat>catList = CatLogic.findAll();
		request.setAttribute("catList", catList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		// リクエストパラメータの取得
				request.setCharacterEncoding("UTF-8");
				String id = request.getParameter("id");
				String action1 = request.getParameter("action1");


		// 里親実績へクリック後にリダイレクトにてネコ一覧表示
		// ネコ一覧にクリック後にリダイレクトにて実績表示

				CatLogic CatLogic =new CatLogic();

				if(action1.equals ("1")) {
					CatLogic.UpDateIsParent(id);
					response.sendRedirect("/nyanChance/Achievement?action=done");

				}else {
					CatLogic.UpDateParent(id);
					response.sendRedirect("/nyanChance/CatList?action=done");
				}
	}
}
