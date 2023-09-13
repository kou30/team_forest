// メッセージに関するリクエストを処理するコントローラ

package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountInfo;
import model.MessageInfo;
import model.MessageLogic;

@WebServlet("/Message")
public class Message extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// つぶやきリストを取得して、リクエストスコープに保存
		MessageLogic getMessageLogic = new MessageLogic();
		List<MessageInfo> messageInfoList = getMessageLogic.execute();
		request.setAttribute("messageInfoList", messageInfoList);

		// ログインしているか確認するため
		// セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		AccountInfo accountInfoOnSession = (AccountInfo) session.getAttribute("ACCOUNT_INFO");

		if(accountInfoOnSession == null) { // ログインしていない場合
			// リダイレクト
			response.sendRedirect("/aniMatch/Login");
		} else { // ログイン済みの場合
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/message.jsp");
			dispatcher.forward(request,  response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");


		// つぶやき時間を取得

		// 手順１：現在時刻情報の取得
		LocalDateTime nowDateTime = LocalDateTime.now();
		// 手順２：指定フォーマットでインスタンスを生成
		DateTimeFormatter java8Format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		// 手順３：画面表示用文字列の取得(フォーマット処理)
		String message_time = nowDateTime.format( java8Format );


		// 入力値チェック
		if(text != null && text.length() != 0) {
			// セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();

			AccountInfo accountInfoOnSession = (AccountInfo) session.getAttribute("ACCOUNT_INFO");

			// つぶやきをつぶやきリストに追加
			MessageInfo messageInfo = new MessageInfo(accountInfoOnSession.getUserName(), text, message_time);

			MessageLogic postMessageLogic = new MessageLogic();
			postMessageLogic.execute(messageInfo);
			}

		// (追加)elseブロック
		else {

			// エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "メッセージが入力されていません");
		}

		// つぶやきリストを取得して、リクエストスコープに保存
		MessageLogic getMessageLogic = new MessageLogic();
		List<MessageInfo> messageInfoList = getMessageLogic.execute();
		request.setAttribute("messageInfoList", messageInfoList);

		// メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/message.jsp");
		dispatcher.forward(request, response);

	}
}