package DAO;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import jp.co.example.ConnectionManager;

public class ItemDao {

	public BufferedImage selectImageById(int id) {

		try (Connection conn = ConnectionManager.getConnection()){

			// SQL文を作成する
			StringBuffer sbSQL = new StringBuffer();
			sbSQL.append("   select");
			sbSQL.append("          IMAGE");
			sbSQL.append("     from ITEM");
			sbSQL.append("    where ID = ?");

			// SQL文を実行する
			PreparedStatement ps = conn.prepareStatement(sbSQL.toString());
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			// 結果セットから画像データを取得し、返却する
			if (rs.next()) {
				InputStream is = rs.getBinaryStream("IMAGE");
				BufferedInputStream bis = new BufferedInputStream(is);
				return ImageIO.read(bis);
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}