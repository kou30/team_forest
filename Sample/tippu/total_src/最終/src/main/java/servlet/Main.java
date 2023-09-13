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
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//アニマルリストを取得して、リクエストスコープに保存
		GetAnimalListLogic getAnimalListLogic =
				new GetAnimalListLogic();
		List<AnimalInfo>animalList = getAnimalListLogic.execute();
		request.setAttribute("animalList", animalList);

/*		//ログインしているか確認するため
		//セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		//User loginUser = (User)session.getAttribute("loginUser");
		UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute("LOGIN_INFO");

		if(userInfoOnSession == null) {	//ログインしていない場合
			//リダイレクト
			response.sendRedirect("/docoTsubu/");
		}else {	//ログイン済みの場合		*/

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


/*			//セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			//User loginUser = (User)session.getAttribute("loginUser");
			UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute("LOGIN_INFO");

			//つぶやきをつぶやきリストに追加
			//Mutter mutter = new Mutter(loginUser.getName(), text);
			Mutter mutter = new Mutter(userInfoOnSession.getUserName(), text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter);

*/		}else {

			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg",
					"情報が登録されていません");
		}

/*		//つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic =
				new GetMutterListLogic();
		List<Mutter>mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);*/
	}

}
