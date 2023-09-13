package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AccountInfo;

/**----------------------------------------------------------------------*
 *■■■AccountDAOクラス■■■
 *概要：DAO（「ACCOUNT」テーブル）
 *----------------------------------------------------------------------**/
public class AccountDAO {
	//-------------------------------------------
		//データベースへの接続情報
		//-------------------------------------------

		//JDBCドライバの相対パス
		//※バージョンによって変わる可能性があります（MySQL5系の場合は「com.mysql.jdbc.Driver」）
//		String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

		//接続先のデータベース
		//※データベース名が「test_db」でない場合は該当の箇所を変更してください
		String JDBC_URL    = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&useSSL=false";

		//接続するユーザー名
		//※ユーザー名が「test_user」でない場合は該当の箇所を変更してください
		String DB_USER     = "test_user";

		//接続するユーザーのパスワード
		//※パスワードが「test_pass」でない場合は該当の箇所を変更してください
		String DB_PASS   = "test_pass";


		//----------------------------------------------------------------
		//メソッド
		//----------------------------------------------------------------

		/**----------------------------------------------------------------------*
		 *■findAllメソッド		 *----------------------------------------------------------------------**/
		public List<AccountInfo> findAll() {
			List<AccountInfo> accountInfoList = new ArrayList<>();

			// データベース接続
			try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

				// SELECT文の準備
				String sql = "SELECT USER_ID,PASS,USER_NAME FROM ACCOUNT";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SLECTを実行
				ResultSet rs = pStmt.executeQuery();

				// SELECT文の結果をArrayListに格納
				while (rs.next()) {
					String userId = rs.getString("USER_ID");
					String pass = rs.getString("PASS");
					String userName = rs.getString("USER_NAME");
					AccountInfo accountInfo = new AccountInfo(userId, pass, userName);
					accountInfoList.add(accountInfo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return accountInfoList;
		}

		/**----------------------------------------------------------------------*
		 *■doSelectメソッド
		 *概要　：引数のユーザー情報に紐づくユーザーデータを「ACCOUNT」テーブルから抽出する
		 *引数①：ユーザーID（ユーザー入力）
		 *引数②：ユーザーパスワード（ユーザー入力）
		 *戻り値：「ACCOUNT」テーブルから抽出したユーザーデータ（AccountInfo型）
		 *----------------------------------------------------------------------**/
		public AccountInfo doSelect(String inputUserId, String inputPass) {

			//-------------------------------------------
			//SQL発行
			//-------------------------------------------

			//JDBCの接続に使用するオブジェクトを宣言
			//※finallyブロックでも扱うためtryブロック内で宣言してはいけないことに注意
			Connection        con = null ;   // Connection（DB接続情報）格納用変数
			PreparedStatement ps  = null ;   // PreparedStatement（SQL発行用オブジェクト）格納用変数
			ResultSet         rs  = null ;   // ResultSet（SQL抽出結果）格納用変数

			//抽出データ（UserInfoDto型）格納用変数
			//※最終的にreturnするため、tryブロック内で宣言してはいけないことに注意
			AccountInfo accountInfo = new AccountInfo();

			try {

				//-------------------------------------------
				//接続の確立（Connectionオブジェクトの取得）
				//-------------------------------------------
				con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

				//-------------------------------------------
				//SQL文の送信 ＆ 結果の取得
				//-------------------------------------------

				//発行するSQL文の生成（SELECT）
				StringBuffer buf = new StringBuffer();
				buf.append(" SELECT             ");
				buf.append("   USER_ID,         ");
				buf.append("   PASS,            ");
				buf.append("   USER_NAME        ");
				buf.append(" FROM               ");
				buf.append("   ACCOUNT          ");
				buf.append(" WHERE              ");
				buf.append("   USER_ID  = ? AND ");  //第1パラメータ
				buf.append("   PASS = ?         ");  //第2パラメータ

				//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
				ps = con.prepareStatement(buf.toString());

				//パラメータをセット
				ps.setString( 1, inputUserId   );  //第1パラメータ：ユーザーID（ユーザー入力）
				ps.setString( 2, inputPass );  //第2パラメータ：ユーザーパスワード（ユーザー入力）

				//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
				rs = ps.executeQuery();

				//--------------------------------------------------------------------------------
				//ResultSetオブジェクトからユーザーデータを抽出
				//--------------------------------------------------------------------------------
				if (rs.next()) {
					//ResultSetから1行分のレコード情報をAccountInfoへ登録
					accountInfo.setUserId(   rs.getString("USER_ID")   );    //ユーザーID
					accountInfo.setPass( rs.getString("PASS") );    //ユーザー名
				}

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				//-------------------------------------------
				//接続の解除
				//-------------------------------------------

				//ResultSetオブジェクトの接続解除
				if (rs != null) {    //接続が確認できている場合のみ実施
					try {
						rs.close();  //接続の解除
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				//PreparedStatementオブジェクトの接続解除
				if (ps != null) {    //接続が確認できている場合のみ実施
					try {
						ps.close();  //接続の解除
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				//Connectionオブジェクトの接続解除
				if (con != null) {    //接続が確認できている場合のみ実施
					try {
						con.close();  //接続の解除
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			//抽出したユーザーデータを戻す
			return accountInfo;
	}
		public boolean create(AccountInfo accountInfo) {

//			// データベース接続
			try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

				// INSERT文の準備(idは自動連番なので指定しなくてよい)
				String sql = "INSERT INTO ACCOUNT(USER_ID, PASS, USER_NAME) VALUES(?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// INSERT文中の「?」に使用する値を設定しSQLを完成
				pStmt.setString(1, accountInfo.getUserId());
				pStmt.setString(2, accountInfo.getPass());
				pStmt.setString(3, accountInfo.getUserName());

				// INSERT文を実行(resultには追加された行数が代入される)
				int result = pStmt.executeUpdate();
				if (result != 1) {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
}