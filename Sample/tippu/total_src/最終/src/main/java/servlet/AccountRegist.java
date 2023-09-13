package servlet;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountInfo;
import model.AccountLogic;



@WebServlet("/AccountRegist")
public class AccountRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AccountRegist() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountRegist.jsp");
		dispatcher.forward(request, response);
	}

	String errorMsgPass;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");     //文字コードをUTF-8で設定
		//リクエスト（受信データ）の文字コードを設定
		request.setCharacterEncoding("UTF-8");                  //文字コードをUTF-8で設定

		//リクエストパラメータからユーザー入力値を取得
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String click =request.getParameter("regist");

		if (click.equals ("登録")){



			//パラメータのバリデーションチェック
			if( !(validatePrmName(request.getParameter("userName"))        &&
					validatePrmUserId(request.getParameter("userId"))&&
					validatePrmPassword(request.getParameter("pass"))     ) ) {

				//バリデーションNGの場合
				// エラーメッセージをリクエストスコープに保存
				if(errorMsgPass != null) {
					request.setAttribute("errorMsgPass", "パスワードは半角英数4文字で入力してください");
				}

				request.setAttribute("errorMsg", "入力されていない項目があります");
			}

			else {
				//バリデーションOKの場合

		        // accountResister.jspから受け取った値をビーンズにセット
		        AccountInfo ab = new AccountInfo();
		        ab.setUserName(userName);
		        ab.setUserId(userId);
		        ab.setPass(pass);

		        // セッションにアカウント情報を保存
		        HttpSession session = request.getSession();
		        session.setAttribute("ACCOUNT_INFO", ab);


				// 登録確認画面にフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountConfirm.jsp");
				dispatcher.forward(request, response);

			}
			// 新規登録画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountRegist.jsp");
			dispatcher.forward(request, response);
		}
		else {
			//セッションからアカウントデータを取得
			HttpSession session           = request.getSession();
			AccountInfo accountInfoOnSession = (AccountInfo)session.getAttribute("ACCOUNT_INFO");

			// ユーザー入力値をアカウントリストに追加
			AccountInfo accountInfo = new AccountInfo(accountInfoOnSession.getUserId(),accountInfoOnSession.getPass(),accountInfoOnSession.getUserName() );

			AccountLogic accountLogic = new AccountLogic();
			accountLogic.execute(accountInfo);

			// ログイン結果画面(登録完了)にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Login");
			dispatcher.forward(request, response);

			}

		}
	/**----------------------------------------------------------------------*
	 *■■■validatePrmUserIdクラス■■■
	 *概要：バリデーションチェック
	 *詳細：入力値（名前）の検証を行う
	 *----------------------------------------------------------------------**/
	private boolean validatePrmName( String pr) {

		boolean validateResult = true ;

		//入力値がnullまたは空白の場合はエラーとする
		if( pr == null || pr.equals("") ) {
			validateResult = false ;
		}

		return validateResult ;
	}

	/**----------------------------------------------------------------------*
	 *■■■validatePrmUserIdクラス■■■
	 *概要：バリデーションチェック
	 *詳細：入力値（ユーザーID）の検証を行う
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
	 *詳細：入力値（パスワード）の検証を行う
	 *----------------------------------------------------------------------**/
	private boolean validatePrmPassword( String pr) {

		boolean validateResult = true ;

		// パターンの生成(半角英数4文字)
		Pattern pattern = Pattern.compile("^[0-9a-zA-Z]{4}$");

		//入力値がnullまたは空白の場合はエラーとする
		if( pr == null || pr.equals("") ) {
			validateResult = false ;
		}

		//パターンと一致するか
		if(pattern.matcher(pr) .matches()) {
			// 一致したときの処理

		} else {
			// 一致しなかったときの処理
			validateResult = false ;
			errorMsgPass = "noMatch";
		}
		return validateResult ;
	}

}
