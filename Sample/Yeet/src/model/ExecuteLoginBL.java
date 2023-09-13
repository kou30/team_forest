package model;

import dao.UserInfoDAO;

/**----------------------------------------------------------------------*
 *■■■ExecuteLoginBLクラス■■■
 *概要：ビジネスロジック（ユーザーデータの照合）
 *----------------------------------------------------------------------**/
public class ExecuteLoginBL {

	/**----------------------------------------------------------------------*
	 *■executeSelectUserInfoメソッド
	 *概要　：対象のアンケートデータを登録する
	 *引数１：入力されたユーザーID
	 *引数２：入力されたユーザーのパスワード
	 *戻り値：抽出したユーザーデータ（UserInfoDto型）
	 *----------------------------------------------------------------------**/
	public UserInfoDto executeSelectUserInfo(String userName, String passWord) {

		// データベースにアクセスしてユーザー情報を取得
		UserInfoDAO dao = new UserInfoDAO();
		UserInfoDto dto = dao.doSelect(userName, passWord);

		return dto;
	}

}