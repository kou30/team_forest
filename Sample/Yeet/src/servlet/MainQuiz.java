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

import model.GetQuizListLogic;
import model.Quiz;
import model.UserInfoDto;

@WebServlet("/MainQuiz")
public class MainQuiz extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static int sum;

	protected void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {
		//クイズリストを取得して、リクエストスコープに保存
		GetQuizListLogic getQuizListLogic = new GetQuizListLogic();
		List<Quiz> quizList = getQuizListLogic.execute();
		request.setAttribute("quizList", quizList);

		//ログインしているか確認するため
		//セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute("LOGIN_INFO");

		if (userInfoOnSession == null) { //ログインしていない場合
			//リダイレクト
			response.sendRedirect("/Yeet/");
		} else {
			//フォワード
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/mainquiz.jsp");
			dispatcher.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException,IOException {

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String ans1     = request.getParameter("ans1");
		String ans2     = request.getParameter("ans2");
		String ans3     = request.getParameter("ans3");
		String ans4     = request.getParameter("ans4");
		String ans5     = request.getParameter("ans5");
		String check1 = request.getParameter("check1");
		String check2 = request.getParameter("check2");
		String check3 = request.getParameter("check3");
		String check4 = request.getParameter("check4");
		String check5 = request.getParameter("check5");
		String aitem1 = request.getParameter("aitem1");
		String aitem2 = request.getParameter("aitem2");
		String aitem3 = request.getParameter("aitem3");
		String aitem4 = request.getParameter("aitem4");
		String aitem5 = request.getParameter("aitem5");


		//セッションスコープに保存されたユーザー情報を取得
		HttpSession session = request.getSession();
		UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute("LOGIN_INFO");

		//クイズの回答チェック
		int num = 0;

		if (ans1. equals(check1)){
			request.setAttribute("hit_out1", "正解");
			num = num + 20;
		} else {
			request.setAttribute("hit_out1", "不正解");
		}
		request.setAttribute("aitem1", aitem1);

		if (ans2. equals(check2)){
			request.setAttribute("hit_out2", "正解");
			num = num + 20;
		} else {
			request.setAttribute("hit_out2", "不正解");
		}
		request.setAttribute("aitem2", aitem2);


		if (ans3. equals(check3)){
			request.setAttribute("hit_out3", "正解");
			num = num + 20;
		} else {
			request.setAttribute("hit_out3", "不正解");
		}
		request.setAttribute("aitem3", aitem3);


		if (ans4. equals(check4)){
			request.setAttribute("hit_out4", "正解");
			num = num + 20;
		} else {
			request.setAttribute("hit_out4", "不正解");
		}
		request.setAttribute("aitem4", aitem4);


		if (ans5. equals(check5)){
			request.setAttribute("hit_out5", "正解");
			num = num + 20;
		} else {
			request.setAttribute("hit_out5", "不正解");
		}
		request.setAttribute("aitem5", aitem5);

		request.setAttribute("num", num);

		sum = num;

		//メイン画面にフォワード
		RequestDispatcher dispatcher =
			request.getRequestDispatcher("/WEB-INF/jsp/quizResult.jsp");
		dispatcher.forward(request, response);
	}

}
