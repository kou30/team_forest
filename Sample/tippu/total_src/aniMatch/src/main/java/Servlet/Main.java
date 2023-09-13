package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AnimalInfo;
import model.GetAnimalListLogic;


/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//アニマルリストを取得して、リクエストスコープに保存
		GetAnimalListLogic getAnimalListLogic =
				new GetAnimalListLogic();
		List<AnimalInfo>animalList = getAnimalListLogic.execute();
		request.setAttribute("animalList", animalList);


		//フォワード
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");

			dispatcher.forward(request, response);

		}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException,IOException{

		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String animalKey = request.getParameter("animalKey");

		//入力値チェック
		if(animalKey != null && animalKey.length() != 0) {

			//アニマルリストを取得して、リクエストスコープに保存
			GetAnimalListLogic getAnimalListLogic =
					new GetAnimalListLogic();
			List<AnimalInfo>animalList = getAnimalListLogic.execute();
			request.setAttribute("animalList", animalList);

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(
					"/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);

		}else {

			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg",
					"情報が登録されていません");
		}

	}

}
