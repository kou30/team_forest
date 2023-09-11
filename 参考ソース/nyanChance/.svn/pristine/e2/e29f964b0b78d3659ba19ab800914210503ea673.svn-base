package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reserve;

public class ReserveDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost/test_db?characterEncoding = UTF-8";
	private final String DB_USER = "test_user";
	private final String DB_PASS = "test_pass";

	// 特定ネコの予約リストをデータベースからリストを取得して戻す
	public List<Reserve> findFromCat(int catId) {
		List<Reserve> reserveList = new ArrayList<>();
		//##########################
		//### ここにコードを書く ###
		//##########################
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT ID, USERNAME, CATID, DATE, COMMENT from RESERVE WHERE CATID = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, String.valueOf(catId));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("ID");
				String userName = rs.getString("USERNAME");
				int cat = rs.getInt("CATID");
				Date date = rs.getDate("DATE");
				String comment = rs.getString("COMMENT");

				Reserve reserve = new Reserve(id, userName, cat, date, comment);
				reserveList.add(reserve);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return reserveList;
	}

	// 特定個人の予約リストをデータベースからリストを取得して戻す
	public List<Reserve> findFromUser(String name) {
		List<Reserve> reserveList = new ArrayList<>();
		//##########################
		//### ここにコードを書く ###
		//##########################
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT RESERVE.ID, RESERVE.CATID, CAT.NAME, CAT.BIRTHDAY, RESERVE.DATE, CAT.SEX, CAT.CAT_KIND, RESERVE.COMMENT FROM RESERVE LEFT JOIN CAT ON RESERVE.CATID=CAT.ID WHERE RESERVE.USERNAME= ?  ORDER BY DATE;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				int catId = rs.getInt("CATID");
				String catName = rs.getString("NAME");
				Date birthday = rs.getDate("BIRTHDAY");
				Date date = rs.getDate("DATE");
				String sex = rs.getString("SEX");
				String catKind = rs.getString("CAT_KIND");
				String comment = rs.getString("COMMENT");
				Reserve reserve = new Reserve(id, catId, catName, birthday, date, sex, catKind, comment);
				reserveList.add(reserve);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return reserveList;
	}

	// 新たな予約をする
	public boolean create(Reserve reserve) {
		//##########################
		//### ここにコードを書く ###
		//##########################
		try (Connection conn = DriverManager.getConnection(

				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "INSERT INTO RESERVE(USERNAME, CATID, DATE, COMMENT) VALUES(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, reserve.getUserName());
			ps.setInt(2, reserve.getCatId());
			ps.setDate(3, reserve.getDate());
			ps.setString(4, reserve.getComment());

			int result = ps.executeUpdate();
			if (result != 1) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 既存の予約を削除する			delete from reserve where
	public boolean delete(int reservedId) {
		//##########################
		//### ここにコードを書く ###
		//##########################
		try (Connection conn = DriverManager.getConnection(

				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "DELETE FROM RESERVE WHERE ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, reservedId);

			int result = ps.executeUpdate();
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
