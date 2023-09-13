package dao;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;

public class Fileselect {
//	private String url = "jdbc:mysql://localhost:3306/test";
//    private String user = "**";
//    private String passwd = "**";
	private String JDBC_URL = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=JST";
	private String DB_USER = "test_user";
	private String DB_PASS = "test_pass";

    public BufferedImage selectImageById(int ID){

        Connection con = null;

        try {
     //       Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            //SQL文の作成
            String sql = "SELECT image FROM imgtable WHERE ID = ?;";
//            String sql = "SELECT img FROM images WHERE ID = ?;";

            //SELECTを実行
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();

            //データの取り出し
     //       if(rs.next()){
             while(rs.next()){
                InputStream is = rs.getBinaryStream(1);
                BufferedInputStream bis = new BufferedInputStream(is);
                return ImageIO.read(bis);
             }
        //    }
            }catch
                (IOException | SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
}
