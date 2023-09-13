import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class imageRegister {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		try{
	        // 画像ファイルを読み込んでバイト配列取得
	        FileInputStream fis = new FileInputStream("C:\\Users\\user\\Desktop\\ネコ\\");
	        FileChannel channel = fis.getChannel();
	        ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
	        channel.read(buffer);
	        buffer.clear();
	        byte[] bytes = new byte[buffer.capacity()];
	        buffer.get(bytes);
	        channel.close();
	        fis.close();

			  Connection conn = getConnection();
			  String sql = "insert into animal( animal_Key, sex, age, place, image)"
			  		+ " values ( ?, ? , ?, ?, ?)";
			  PreparedStatement stmt = conn.prepareStatement( sql );

			  int animal_Key = 1;
			  stmt.setInt( 1, animal_Key );

			  stmt.setString( 2, "" );

			  stmt.setString( 3, "" );

			  stmt.setString( 4, "" );

			  stmt.setBytes( 5, bytes ); //. data は byte[] 型
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
