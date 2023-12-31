package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO {
	// ユーザーのリスト情報を取得して戻す
	// データベース接続に使用する情報
	private final String JDBC_URL=
			"jdbc:mysql://localhost/test_db?characterEncoding=UTF-8";
	private final String DB_USER = "test_user";
	private final String DB_PASS = "test_pass";

	public List<User>findAll() {
		List<User>userList = new ArrayList<>();
		//##########################
		//### ここにコードを書く ###
		//##########################

		return userList;
	}

	public User login(User user) {
		//##########################
		//### ここにコードを書く ###
		//##########################

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)){

			// SELECT文の準備
			String sql = "SELECT NAME, PASS, TELL, CREATEDATE, SUPERUSER FROM USER WHERE NAME = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getPass());

			// SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致したユーザーが存在した場合
			// そのユーザーを表すuserインスタンスを生成
			if(rs.next()) {
				// 結果表からデータを取得
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				String tell = rs.getString("TELL");
				Date createDate = rs.getDate("CREATEDATE");
				boolean superUser = rs.getBoolean("SUPERUSER");


				user = new User(name, pass, tell, createDate, superUser);

			}else {
					return null;
				}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}


		// みつかったユーザーまたはnullを返す

		return user;
	}

	// ユーザー（一人）を新規登録
	public boolean create(User user) {
		//##########################
		//### ここにコードを書く ###
		//##########################

		// データベース接続
		try(Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			// INSERT文の準備
			String sql = "INSERT INTO User(NAME, PASS, TELL, CREATEDATE, SUPERUSER) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// INSERT文の「?」に使用する値を設定しSQLを完成
			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getPass());
			pStmt.setString(3, user.getTell());
			pStmt.setDate(4, user.getCreateDate());
			pStmt.setBoolean(5, user.getSuperUser());

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
	// ユーザーを削除する
	public boolean delete() {
		//##########################
		//### ここにコードを書く ###
		//##########################
		return true;
	}
}
