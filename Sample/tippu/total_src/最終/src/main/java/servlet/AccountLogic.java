package servlet;

import java.util.List;

import dao.AccountDAO;
import model.AccountInfo;

public class AccountLogic {

	/**----------------------------------------------------------------------*
	 *■executeSelectUserInfoメソッド
	 *概要　：対象のアンケートデータを登録する
	 *引数１：入力されたユーザーID
	 *引数２：入力されたユーザーのパスワード
	 *戻り値：抽出したユーザーデータ（UserInfoDto型）
	 *----------------------------------------------------------------------**/
	public AccountInfo executeSelectAccountInfo(String userId, String pass) {

		// データベースにアクセスしてユーザー情報を取得
		AccountDAO dao = new AccountDAO();
		AccountInfo accountInfo = dao.doSelect(userId, pass);

		return accountInfo;
	}
	public void execute(AccountInfo accountInfo) {
		AccountDAO dao = new AccountDAO();
		dao.create(accountInfo);
	}
	public List<AccountInfo> execute() {
		AccountDAO dao = new AccountDAO();
		List<AccountInfo> mutterList = dao.findAll();
		return mutterList;
	}
}