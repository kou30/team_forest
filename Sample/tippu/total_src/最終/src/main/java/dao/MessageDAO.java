	// MESSAGEテーブルを担当する DAO

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MessageInfo;


public class MessageDAO {

		// データベース接続に使用する情報
		private final String JDBC_URL= "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8";
		private final String DB_USER = "test_user";
		private final String DB_PASS = "test_pass";

		public List<MessageInfo> findAll() {
			List<MessageInfo> messageInfoList = new ArrayList<>();

			// データベース接続
			try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

				// SELECT文の準備
				String sql = "SELECT ID,NAME,TEXT,MESSAGE_TIME, ANIMAL_KEY FROM MESSAGE ORDER BY ID DESC";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SLECTを実行
				ResultSet rs = pStmt.executeQuery();

				// SELECT文の結果をArrayListに格納
				while (rs.next()) {
					int id = rs.getInt("ID");
					String name = rs.getString("NAME");
					String text = rs.getString("TEXT");
					String message_time = rs.getString("MESSAGE_TIME");
					int animal_key = rs.getInt("ANIMAL_KEY");

					MessageInfo messageInfo = new MessageInfo(id, name, text, message_time, animal_key);
					messageInfoList.add(messageInfo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return messageInfoList;
		}

		public boolean create(MessageInfo messageInfo) {
			// データベース接続
			try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

				// INSERT文の準備(idは自動連番なので指定しなくてよい)
				String sql = "INSERT INTO MESSAGE(NAME, TEXT, MESSAGE_TIME) VALUES(?, ?, ?)";
//				String sql = "INSERT INTO MESSAGE(NAME, TEXT) VALUES(?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// INSERT文中の「?」に使用する値を設定しSQLを完成
				pStmt.setString(1, messageInfo.getName());
				pStmt.setString(2, messageInfo.getText());
				pStmt.setString(3, messageInfo.getMessage_time());


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
