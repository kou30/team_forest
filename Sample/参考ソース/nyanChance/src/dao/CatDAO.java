package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Cat;

public class CatDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL=
			"jdbc:mysql://localhost/test_db?characterEncoding=UTF-8";
	private final String DB_USER="test_user";
	private final String DB_PASS="test_pass";
	// ネコの情報のリストを取得して戻す
	public List<Cat>findAll(String parents) {
		List<Cat>catList = new ArrayList<>();

		//データベース接続
		try(Connection conn=DriverManager.getConnection(
				JDBC_URL,DB_USER,DB_PASS)){

			//select文の準備
			String sql=
					"SELECT ID,NAME,BIRTHDAY,timestampdiff(MONTH, BIRTHDAY, CURRENT_DATE) as AGE,SEX,CAT_KIND,IS_FOSTER_PARENTS,COMMENT FROM CAT where IS_FOSTER_PARENTS =(?) ORDER BY ID";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1,parents);

			//SELECTを実行
			ResultSet rs = pStmt.executeQuery();


			//SELECT文の結果をArrayListに格納
			while (rs.next()) {
				int id=rs.getInt("ID");
				String name=rs.getString("NAME");
				Date birthday= rs.getTimestamp("BIRTHDAY");
				String age=rs.getString("AGE");
				String sex=rs.getString("SEX");
				String catKind=rs.getString("CAT_KIND");
				boolean isFosterParents=rs.getBoolean("IS_FOSTER_PARENTS");
				String comment=rs.getString("COMMENT");
				Cat cat=new Cat(id,name,birthday,age,sex,catKind,isFosterParents,comment);
				catList.add(cat);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return catList;
	}


	// ネコの実績（里親が決まったネコ）取得して戻す
	//ネコ一覧（里親がきまっていないネコ）取得して戻す
	public boolean UpDateParent(String fosterParent, String id) {
		//##########################
		//### ここにコードを書く ###
		//##########################
		try (Connection conn = DriverManager.getConnection(

				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "UPDATE CAT SET IS_FOSTER_PARENTS=(?) WHERE ID=(?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);


			pStmt.setString(1,fosterParent);
			pStmt.setString(2,id);


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



	// ネコの実績（里親が決まったネコ）のリストを取得して戻す
	public List<Cat>findFin() {
		List<Cat>catList = new ArrayList<>();
		//##########################
		//### ここにコードを書く ###
		//##########################
		return catList;
	}
	// ネコの情報を追加
	public boolean create(Cat cat) {
		//## 今回不要 ##############
		//##########################
		//### ここにコードを書く ###
		//##########################
		return true;
	}
}
