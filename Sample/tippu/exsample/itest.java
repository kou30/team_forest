package image;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class itest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		try{
	        // 画像ファイルを読み込んでバイト配列取得
	        FileInputStream fis = new FileInputStream("test.png");
	        FileChannel channel = fis.getChannel();
	        ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
	        channel.read(buffer);
	        buffer.clear();
	        byte[] bytes = new byte[buffer.capacity()];
	        buffer.get(bytes);
	        channel.close();
	        fis.close();

			  Connection conn = getConnection();
			  String sql = "insert into images( id, img ) values ( ?, ? )";
			  PreparedStatement stmt = conn.prepareStatement( sql );

			  int id = 1;
			  stmt.setInt( 1, id );
		//		  stmt.setBytes( 2, data ); //. data は byte[] 型
			  stmt.setBytes( 2, bytes ); //. data は byte[] 型
			  int r = stmt.executeUpdate();

			  stmt.close();
			  conn.close();
			}catch( Exception e ){
			  e.printStackTrace();
			}

	}

	public static Connection getConnection(){
		String JDBC_URL = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8";
		String DB_USER = "test_user";
		String DB_PASS = "test_pass";

		Connection conn = null;

		try{
	      conn = DriverManager.getConnection(
	              JDBC_URL, DB_USER, DB_PASS);
		  }catch( Exception e ){
			    e.printStackTrace();
			  }
		  return conn;
		}

}
