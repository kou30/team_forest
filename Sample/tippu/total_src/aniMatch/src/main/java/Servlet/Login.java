// ログインに関するリクエストを処理するコントローラ

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountInfo;
import model.AccountLogic;
import model.MessageInfo;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// セッションスコープから動物の主キー情報を取得
        HttpSession session = request.getSession();

		MessageInfo messageInfoOnSession = (MessageInfo) session.getAttribute("ANIMAL_KEY_INFO");


		if (messageInfoOnSession == null){

			// 変数numberに代入された動物の主キーを取得
			int animal_key = Integer.parseInt(request.getParameter("number"));

			// 動物の主キーJavaBeansにセット
	        MessageInfo mb = new MessageInfo();
	        mb.setAnimal_key(animal_key);

	        session.setAttribute("ANIMAL_KEY_INFO", mb);
		}


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");     //文字コードをUTF-8で設定
		//リクエスト（受信データ）の文字コードを設定
		request.setCharacterEncoding("UTF-8");                  //文字コードをUTF-8で設定

		//セッションからユーザーデータを取得
		HttpSession session           = request.getSession();
		AccountInfo accountInfoOnSession = (AccountInfo)session.getAttribute("ACCOUNT_INFO");

		//ログイン状態によって表示画面を振り分ける
		if (accountInfoOnSession != null) {

			//ログイン済：メッセージ入力画面に転送
			response.sendRedirect("Message");


		} else {

			//未ログイン：ログイン処理を実施


			//パラメータのバリデーションチェック

			if( !(validatePrmUserId(request.getParameter("userId"))        &&
					validatePrmPassword(request.getParameter("pass"))     ) ) {


				//バリデーションNGの場合

			}else {

				//バリデーションOKの場合

				//リクエストパラメータからユーザー入力値を取得
				String userId   = request.getParameter("userId");      //リクエストパラメータ（name）
				String pass= request.getParameter("pass");     //リクエストパラメータ（pass）


				//「ACCOUNT」テーブルからユーザー入力値と合致するユーザーデータ（AccountInfo型）を抽出
				AccountLogic logic = new AccountLogic();
				AccountInfo    accountInfo   = logic.executeSelectAccountInfo(userId, pass);

				if (accountInfo.getUserId() == null) {

					//データの取得に失敗した場合

				}else {
					//データの取得に成功した場合、DBから抽出したユーザデータをセッションにセット
					session.setAttribute("ACCOUNT_INFO", accountInfo);

				}
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
			dispatcher.forward(request, response);
	}

}

	/**----------------------------------------------------------------------*
	 *■■■validatePrmUserIdクラス■■■
	 *概要：バリデーションチェック
	 *詳細：入力値（名前）の検証を行う
	 *----------------------------------------------------------------------**/
	private boolean validatePrmUserId( String pr) {

		boolean validateResult = true ;

		//入力値がnullまたは空白の場合はエラーとする
		if( pr == null || pr.equals("") ) {
			validateResult = false ;
		}

		return validateResult ;
	}

	/**----------------------------------------------------------------------*
	 *■■■validatePrmPasswordクラス■■■
	 *概要：バリデーションチェック
	 *詳細：入力値（年齢）の検証を行う
	 *----------------------------------------------------------------------**/
	private boolean validatePrmPassword( String pr) {

		boolean validateResult = true ;

		//入力値がnullまたは空白の場合はエラーとする
		if( pr == null || pr.equals("") ) {
			validateResult = false ;
		}

		return validateResult ;
	}

}
