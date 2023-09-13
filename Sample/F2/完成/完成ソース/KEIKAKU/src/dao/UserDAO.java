package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
;

public class UserDAO {
	//接続用の情報をフィールドに定数として定義
	private final String JDBC_URL=
			"jdbc:mysql://localhost/test_db?characterEncoding=UTF-8";
	private final String DB_USER= "test_user";
	private final String DB_PASS= "test_pass";

 public List<User> findAll(String room){
	 List<User> userList=new ArrayList<>();

	 //データーベース接続
	 try(Connection conn=DriverManager.getConnection(
			 JDBC_URL,DB_USER,DB_PASS)){

	//Select文を用意
		 String sql="SELECT ROOM_ID,USER_ID,NAME,COLOR FROM USER WHERE ROOM_ID=?";
		 PreparedStatement pStmt=conn.prepareStatement(sql);

		 //SELECT文中の「？」に使用する値を設定しSQlを完成
		 pStmt.setString(1, room);


	//SELECT文を実行する
		 ResultSet rs=pStmt.executeQuery();

	//SELECT文の結果をArrayListに格納
		 while(rs.next()) {
			 String roomid=rs.getString("ROOM_ID");
			 String userid=rs.getString("USER_ID");
			 String name=rs.getString("NAME");
			 String color=rs.getString("COLOR");
			 User user=new User(roomid,userid,name,color);
			 userList.add(user);
		 }
	 }catch (SQLException e) {
		e.printStackTrace();
		return null;
	 }
	 return userList;
 }
 public boolean create(User user) {
	 //データベース接続
	 try(Connection conn=DriverManager.getConnection(
			 JDBC_URL,DB_USER,DB_PASS)){

		 //INSERt文の準備（idは連番なので指定してない)
		 String sql="INSERT INTO USER(ROOM_ID,NAME,COLOR)VALUES(?,?,?)";
		 PreparedStatement pStmt=conn.prepareStatement(sql);

		 //INSERT文中の「？」に使用する値を設定しSQlを完成
		 pStmt.setString(1,user.getRoomid());
		 pStmt.setString(2, user.getName());
		 pStmt.setString(3, user.getColor());

		 //INSERT文を実行
		 int result=pStmt.executeUpdate();
		 if(result !=1) {
			 return false;
		 }
	 }catch (SQLException e) {
		 e.printStackTrace();
		 return false;
	 }
	 return true;
 }
 public String find(String roomid){
String userid=null;
	 //データベース接続
	 try(Connection conn=DriverManager.getConnection(
			 JDBC_URL,DB_USER,DB_PASS)){

		 //INSERt文の準備（idは連番なので指定してない)
		 String sql="SELECT USER_ID FROM USER WHERE ROOM_ID=?";
		 PreparedStatement pStmt=conn.prepareStatement(sql);
		 pStmt.setString(1, roomid);
		 System.out.println(roomid);
			//SELECT文を実行する
		 ResultSet rs=pStmt.executeQuery();

		//SELECT文の結果をuseridに格納
		 while(rs.next()) {
		userid=rs.getString("USER_ID");
		 }

//		 if(userid !=NULL ) {
//			 return "false";
//		 }
	 }catch (SQLException e) {
		 e.printStackTrace();
		 return null;
	 }
 return userid;
 }

}

