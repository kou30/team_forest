package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RoomPass;
import model.Task;
import model.Taskitiran;
public class TaskDAO {
	//接続用の情報をフィールドに定数として定義
	private final String JDBC_URL=
			"jdbc:mysql://localhost/test_db?characterEncoding=UTF-8";
	private final String DB_USER= "test_user";
	private final String DB_PASS= "test_pass";



	 public List<Task> findAll(String room){
		 List<Task> taskList=new ArrayList<>();

		 //データーベース接続
		 try(Connection conn=DriverManager.getConnection(
				 JDBC_URL,DB_USER,DB_PASS)){

		//Select文を用意
			 String sql="SELECT TASK.ROOM_ID,TASK_NAME,STATUS,TASK.USER_ID,COLOR FROM TASK INNER JOIN USER ON TASK.user_id = USER.user_id WHERE TASK.ROOM_ID=?";

			 PreparedStatement pStmt=conn.prepareStatement(sql);

			 //SELECT文中の「？」に使用する値を設定しSQlを完成
			 pStmt.setString(1, room);


		//SELECT文を実行する
			 ResultSet rs=pStmt.executeQuery();

		//SELECT文の結果をArrayListに格納
			 while(rs.next()) {
				 String roomid=rs.getString("TASK.ROOM_ID");
				 String taskname=rs.getString("TASK_NAME");
				 String status=rs.getString("STATUS");
				 String userid=rs.getString("TASK.USER_ID");
				 String color=rs.getString("COLOR");
				 Task task=new Task(roomid,taskname,status,userid,color);
				 taskList.add(task);
			 }
		 }catch (SQLException e) {
			e.printStackTrace();
			return null;
		 }
		 return taskList;
	 }
	 //ユーザーIDをアップデートする
	 public boolean updateuserid(String room,String userid) {
			//データベース接続
				try(Connection conn=DriverManager.getConnection(
						JDBC_URL,DB_USER,DB_PASS)){

				//UPDATE文の準備
						String sql="UPDATE TASK SET USER_ID=? WHERE USER_ID=0 AND ROOM_ID=?";
						PreparedStatement pStmt=conn.prepareStatement(sql);

				//UPDATE文中の?に使用する値を設定しSQLを完成
						pStmt.setString(1,userid);
						pStmt.setString(2,room);

				//UPDATE文を実行(resultには追加された行数が代入される)
					int result=pStmt.executeUpdate();
					if(result !=1) {
						return false;
					}
					}catch(SQLException e) {
						e.printStackTrace();
						return false;
					}
					return true;
					}


	 public boolean update(Task task) {
		//データベース接続
			try(Connection conn=DriverManager.getConnection(
					JDBC_URL,DB_USER,DB_PASS)){

			//UPDATE文の準備
					String sql="UPDATE TASK SET STATUS=1 WHERE ROOM_ID=? AND TASK_NAME=?";
					PreparedStatement pStmt=conn.prepareStatement(sql);

			//UPDATE文中の?に使用する値を設定しSQLを完成
					pStmt.setString(1,task.getRoomid());
					pStmt.setString(2,task.getTaskname());

					System.out.println(task.getTaskname());
					System.out.println(task.getRoomid());
			//UPDATE文を実行(resultには追加された行数が代入される)
				int result=pStmt.executeUpdate();
				if(result !=1) {
					return false;
				}
				}catch(SQLException e) {
					e.printStackTrace();
					return false;
				}
				return true;
				}


//かねはら

public String create(Taskitiran roomtask) {
	  Connection conn = null;
try {
// データベースへ接続
conn = DriverManager.getConnection(
    JDBC_URL,DB_USER, DB_PASS);

// INSERT文の準備(idは自動連番なので指定しなくてよい）
String sql = "INSERT INTO TASK(ROOM_ID,TASK_NAME) VALUES(?,?)";
PreparedStatement pStmt = conn.prepareStatement(sql);
// INSERT文中の「?」に使用する値を設定しSQLを完成
pStmt.setString(1,roomtask.getRoomId());
pStmt.setString(2,roomtask.getTask());
// INSERT文を実行
pStmt.executeUpdate();

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
return null;
}
public List<Taskitiran> find(Taskitiran roomtask) {
    Connection conn = null;
    List<Taskitiran> TaskList = new ArrayList<Taskitiran>();
    try {
   //   Class.forName(DRIVER_NAME);
      conn = DriverManager.getConnection(
          JDBC_URL, DB_USER, DB_PASS);
      // SELECT文の準備
      String sql =
          "SELECT ROOM_ID,TASK_NAME FROM TASK WHERE ROOM_ID = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);

   // SELECT文中の「?」に使用する値を設定しSQLを完成
      pStmt.setString(1,roomtask.getRoomId());
      // SELECTを実行
      ResultSet rs = pStmt.executeQuery();

      // SELECT文の結果をArrayListに格納
      while (rs.next()) {
        String roomId = rs.getString("ROOM_ID");
		        String task = rs.getString("TASK_NAME");
		        Taskitiran oneTask = new Taskitiran(roomId,task);
		        TaskList.add(oneTask);
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return null;
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
		    return TaskList;
		  }



	  public void delete(RoomPass room) {
	    Connection conn = null;
	    try {
	   //   Class.forName(DRIVER_NAME);
	      conn = DriverManager.getConnection(
          JDBC_URL, DB_USER, DB_PASS);

	      // DELETEの準備
	      String sql =
	          "DELETE FROM TASK WHERE ROOM_ID="+(room.getRoomId());
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      // DELETE文中の「?」に使用する値を設定しSQLを完成
	      //pStmt.setInt(1,room.getRoomId());
	      // DELETEを実行
	      pStmt.executeUpdate(sql);

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

}
