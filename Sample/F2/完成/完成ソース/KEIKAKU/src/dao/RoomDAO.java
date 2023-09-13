package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.RoomPass;

public class RoomDAO {

	// データベース接続に使用する情報
	private final static String JDBC_URL = "jdbc:mysql://localhost/test_db?characterEncording=UTF-8";
	private final static String DB_USER = "test_user";
	private final static String DB_PASS = "test_pass";

	  public void create(RoomPass room) {
		  Connection conn = null;
    try {
      // データベースへ接続
      conn = DriverManager.getConnection(
          JDBC_URL,DB_USER, DB_PASS);

      // INSERT文の準備
      String sql = "INSERT INTO ROOM(PASSWORD) VALUES(?)";
      PreparedStatement pStmt = conn.prepareStatement(sql);

      // INSERT文中の「?」に使用する値を代入
      pStmt.setString(1,room.getRoomPass());

      // INSERT文を実行
      pStmt.executeUpdate();


    } catch (SQLException e) {
      e.printStackTrace();
    }finally {

        // データベース切断
        if (conn != null) {
          try {
            conn.close();
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }
      }
	  }



	  public String find() {
	    Connection conn = null;
	    String roomid = null;
	    try {
	   //   Class.forName(DRIVER_NAME);
	      conn = DriverManager.getConnection(
	          JDBC_URL, DB_USER, DB_PASS);
	      // SELECT文の準備
	      String sql =
	          "SELECT ROOM_ID FROM ROOM ORDER BY ROOM_ID DESC LIMIT 1";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	     // SELECTを実行
	      ResultSet rs = pStmt.executeQuery();
	     // SELECT文の結果を格納
	      while (rs.next()) {
	    roomid  = rs.getString("ROOM_ID");
	      }
	     return roomid;
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {

	        // データベース切断
	        if (conn != null) {
	          try {
	            conn.close();
	          } catch (SQLException e) {
	            e.printStackTrace();
	          }
	        }
	      }
		return roomid;
	  }

	  public RoomPass select(RoomPass room) {
	    Connection conn = null;
	    try {
	   //   Class.forName(DRIVER_NAME);
	      conn = DriverManager.getConnection(
	          JDBC_URL, DB_USER, DB_PASS);
	      // SELECT文の準備
	      String sql =
	          "SELECT ROOM_ID,PASSWORD FROM ROOM WHERE (ROOM_ID = (?)) LIMIT 1";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      // INSERT文中の「?」に使用する値を代入
	      pStmt.setString(1,room.getRoomId());

	     // SELECTを実行
	      ResultSet rs = pStmt.executeQuery();

	     // SELECT文の結果を格納
	      while (rs.next()) {
	    String roomid  = rs.getString("ROOM_ID");
	    String password  = rs.getString("PASSWORD");
	    room.setRoomId(roomid);
	    room.setRoomPass(password);
	      }
	      return room;
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {

	        // データベース切断
	        if (conn != null) {
	          try {
	            conn.close();
	          } catch (SQLException e) {
	            e.printStackTrace();
	          }
	        }
	      }
		return room;
	  }
}

