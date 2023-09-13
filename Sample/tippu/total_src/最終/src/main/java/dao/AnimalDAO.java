package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AnimalInfo;

public class AnimalDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:mysql://localhost/test_db?characterEncoding=UTF-8";
	//家用
//	private final String DB_USER = "root";
//	private final String DB_PASS = "Cocoga_10110325";

	private final String DB_USER = "test_user";
	private final String DB_PASS = "test_pass";

	public List<AnimalInfo>findAll() {
		List<AnimalInfo>animalList = new ArrayList<>();

		//データベース接続
		try(Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)){
			//SELECT文の準備
			String sql =
					"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
					+ "FROM ANIMAL";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECTを実行
			ResultSet rs = pStmt.executeQuery();


			//SELECT文の結果をListに格納
			while(rs.next()) {
				int animalKeyAll = rs.getInt("ANIMAL_KEY");
				String sexAll = rs.getString("SEX");
				String ageAll = rs.getString("AGE");
				String placeAll = rs.getString("PLACE");
				AnimalInfo animalAll = new AnimalInfo(animalKeyAll, sexAll, ageAll, placeAll);//img追加予定
				animalList.add(animalAll);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return animalList;

	}


	public ArrayList<AnimalInfo>search(String sexcase, String agecase, String placecase) {
		ArrayList<AnimalInfo>animalList = new ArrayList<>();
//		int animalKeyAll = ;
//		String sexAll = sexcase;
//		String ageAll = agecase;
//		String placeAll = placecase;
//		AnimalInfo animalAll = new AnimalInfo(animalKeyAll, sexAll, ageAll, placeAll);//img追加予定
//		animalList.add(animalAll);

		//データベース接続

		try(Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)){
			//SELECT文の準備
			if((sexcase != null) && (agecase != null) && (placecase != null)){
				switch(agecase) {
				case("幼年期"):
					String sql =
					"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
					+ "FROM ANIMAL WHERE SEX=? AND AGE<'1' AND PLACE=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, sexcase);
				pStmt.setString(2, placecase);
				//SELECTを実行
				ResultSet rs = pStmt.executeQuery();

				//SELECT文の結果をListに格納
				while(rs.next()) {
					int animalKey = rs.getInt("ANIMAL_KEY");
					String sexSearch = rs.getString("SEX");
					String ageSearch = rs.getString("AGE");
					String placeSearch = rs.getString("PLACE");
					AnimalInfo hit = new AnimalInfo(animalKey, sexSearch, ageSearch, placeSearch);//img追加予定
					animalList.add(hit);
				}
				return animalList;

				case("青年期"):
					String sql1 =
					"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
					+ "FROM ANIMAL WHERE SEX=? AND '1'<=AGE<'3' AND PLACE=?";
				PreparedStatement pStmt1 = conn.prepareStatement(sql1);

				pStmt1.setString(1, sexcase);
				pStmt1.setString(2, placecase);
				//SELECTを実行
				ResultSet rs1 = pStmt1.executeQuery();

				//SELECT文の結果をListに格納
				while(rs1.next()) {
					int animalKey = rs1.getInt("ANIMAL_KEY");
					String sexSearch = rs1.getString("SEX");
					String ageSearch = rs1.getString("AGE");
					String placeSearch = rs1.getString("PLACE");
					AnimalInfo hit = new AnimalInfo(animalKey, sexSearch, ageSearch, placeSearch);//img追加予定
					animalList.add(hit);
				}
				return animalList;

				case("老年期"):
					String sql2 =
					"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
					+ "FROM ANIMAL WHERE SEX=? AND '3'<=AGE AND PLACE=?";
				PreparedStatement pStmt2 = conn.prepareStatement(sql2);

				pStmt2.setString(1, sexcase);
				pStmt2.setString(2, placecase);
				//SELECTを実行
				ResultSet rs2 = pStmt2.executeQuery();

				//SELECT文の結果をListに格納
				while(rs2.next()) {
					int animalKey = rs2.getInt("ANIMAL_KEY");
					String sexSearch = rs2.getString("SEX");
					String ageSearch = rs2.getString("AGE");
					String placeSearch = rs2.getString("PLACE");
					AnimalInfo hit = new AnimalInfo(animalKey, sexSearch, ageSearch, placeSearch);//img追加予定
					animalList.add(hit);
				}
				return animalList;
				}

			}else if(sexcase != null && placecase != null && agecase == null){
				String sql =
						"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
						+ "FROM ANIMAL WHERE SEX=? AND PLACE=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, sexcase);
				pStmt.setString(2, placecase);

				//SELECTを実行
				ResultSet rs = pStmt.executeQuery();


				//SELECT文の結果をListに格納
				while(rs.next()) {
					int animalKey = rs.getInt("ANIMAL_KEY");
					String sexSearch = rs.getString("SEX");
					String ageSearch = rs.getString("AGE");
					String placeSearch = rs.getString("PLACE");
					AnimalInfo hit = new AnimalInfo(animalKey, sexSearch, ageSearch, placeSearch);//img追加予定
					animalList.add(hit);
				}
				return animalList;

			}else if(sexcase != null && agecase != null && placecase == null){
				switch(agecase) {
				case("幼年期"):
					String sql =
					"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
					+ "FROM ANIMAL WHERE SEX=? AND AGE<1 ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, sexcase);


				//SELECTを実行
				ResultSet rs = pStmt.executeQuery();

				//SELECT文の結果をListに格納
				while(rs.next()) {
					int animalKey = rs.getInt("ANIMAL_KEY");
					String sexSearch = rs.getString("SEX");
					String ageSearch = rs.getString("AGE");
					String placeSearch = rs.getString("PLACE");
					AnimalInfo hit = new AnimalInfo(animalKey, sexSearch, ageSearch, placeSearch);//img追加予定
					animalList.add(hit);
				}
				return animalList;

				case("青年期"):
					String sql1 =
					"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
					+ "FROM ANIMAL WHERE SEX=? AND '1'<=AGE<'3' ";
				PreparedStatement pStmt1 = conn.prepareStatement(sql1);

				pStmt1.setString(1, sexcase);


				//SELECTを実行
				ResultSet rs1 = pStmt1.executeQuery();

				//SELECT文の結果をListに格納
				while(rs1.next()) {
					int animalKey = rs1.getInt("ANIMAL_KEY");
					String sexSearch = rs1.getString("SEX");
					String ageSearch = rs1.getString("AGE");
					String placeSearch = rs1.getString("PLACE");
					AnimalInfo hit = new AnimalInfo(animalKey, sexSearch, ageSearch, placeSearch);//img追加予定
					animalList.add(hit);
				}
				return animalList;

				case("老年期"):
					String sql2 =
					"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
					+ "FROM ANIMAL WHERE SEX=? AND '3'<=AGE ";
				PreparedStatement pStmt2 = conn.prepareStatement(sql2);

				pStmt2.setString(1, sexcase);


				//SELECTを実行
				ResultSet rs2 = pStmt2.executeQuery();

				//SELECT文の結果をListに格納
				while(rs2.next()) {
					int animalKey = rs2.getInt("ANIMAL_KEY");
					String sexSearch = rs2.getString("SEX");
					String ageSearch = rs2.getString("AGE");
					String placeSearch = rs2.getString("PLACE");
					AnimalInfo hit = new AnimalInfo(animalKey, sexSearch, ageSearch, placeSearch);//img追加予定
					animalList.add(hit);
				}
				return animalList;
				}

			}else if( agecase != null && placecase != null && sexcase == null){
				switch(agecase) {
				case("幼年期"):
					String sql =
					"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
					+ "FROM ANIMAL WHERE AGE<'1' AND PLACE=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);


				pStmt.setString(1, placecase);
				//SELECTを実行
				ResultSet rs = pStmt.executeQuery();

				//SELECT文の結果をListに格納
				while(rs.next()) {
					int animalKey = rs.getInt("ANIMAL_KEY");
					String sexSearch = rs.getString("SEX");
					String ageSearch = rs.getString("AGE");
					String placeSearch = rs.getString("PLACE");
					AnimalInfo hit = new AnimalInfo(animalKey, sexSearch, ageSearch, placeSearch);//img追加予定
					animalList.add(hit);
				}
				return animalList;

				case("青年期"):
					String sql1 =
					"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
					+ "FROM ANIMAL WHERE '1'<=AGE<'3' AND PLACE=?";
				PreparedStatement pStmt1 = conn.prepareStatement(sql1);


				pStmt1.setString(1, placecase);
				//SELECTを実行
				ResultSet rs1 = pStmt1.executeQuery();

				//SELECT文の結果をListに格納
				while(rs1.next()) {
					int animalKey = rs1.getInt("ANIMAL_KEY");
					String sexSearch = rs1.getString("SEX");
					String ageSearch = rs1.getString("AGE");
					String placeSearch = rs1.getString("PLACE");
					AnimalInfo hit = new AnimalInfo(animalKey, sexSearch, ageSearch, placeSearch);//img追加予定
					animalList.add(hit);
				}
				return animalList;

				case("老年期"):
					String sql2 =
					"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
					+ "FROM ANIMAL WHERE '3'<=AGE AND PLACE=?";
				PreparedStatement pStmt2 = conn.prepareStatement(sql2);

				pStmt2.setString(1, placecase);
				//SELECTを実行
				ResultSet rs2 = pStmt2.executeQuery();

				//SELECT文の結果をListに格納
				while(rs2.next()) {
					int animalKey = rs2.getInt("ANIMAL_KEY");
					String sexSearch = rs2.getString("SEX");
					String ageSearch = rs2.getString("AGE");
					String placeSearch = rs2.getString("PLACE");
					AnimalInfo hit = new AnimalInfo(animalKey, sexSearch, ageSearch, placeSearch);//img追加予定
					animalList.add(hit);
				}
				return animalList;
				}

			}else if( agecase != null && sexcase == null && placecase == null){
				switch(agecase) {
				case("幼年期"):
					String sql =
					"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
					+ "FROM ANIMAL WHERE AGE<'1' ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SELECTを実行
				ResultSet rs = pStmt.executeQuery();

				//SELECT文の結果をListに格納
				while(rs.next()) {
					int animalKey = rs.getInt("ANIMAL_KEY");
					String sexSearch = rs.getString("SEX");
					String ageSearch = rs.getString("AGE");
					String placeSearch = rs.getString("PLACE");
					AnimalInfo hit = new AnimalInfo(animalKey, sexSearch, ageSearch, placeSearch);//img追加予定
					animalList.add(hit);
				}
				return animalList;

				case("青年期"):
					String sql1 =
					"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
					+ "FROM ANIMAL WHERE '1'<=AGE<'3'";
				PreparedStatement pStmt1 = conn.prepareStatement(sql1);

				//SELECTを実行
				ResultSet rs1 = pStmt1.executeQuery();

				//SELECT文の結果をListに格納
				while(rs1.next()) {
					int animalKey = rs1.getInt("ANIMAL_KEY");
					String sexSearch = rs1.getString("SEX");
					String ageSearch = rs1.getString("AGE");
					String placeSearch = rs1.getString("PLACE");
					AnimalInfo hit = new AnimalInfo(animalKey, sexSearch, ageSearch, placeSearch);//img追加予定
					animalList.add(hit);
				}
				return animalList;

				case("老年期"):
					String sql2 =
					"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
					+ "FROM ANIMAL WHERE '3'<=AGE ";
				PreparedStatement pStmt2 = conn.prepareStatement(sql2);

				//SELECTを実行
				ResultSet rs2 = pStmt2.executeQuery();

				//SELECT文の結果をListに格納
				while(rs2.next()) {
					int animalKey = rs2.getInt("ANIMAL_KEY");
					String sexSearch = rs2.getString("SEX");
					String ageSearch = rs2.getString("AGE");
					String placeSearch = rs2.getString("PLACE");
					AnimalInfo hit = new AnimalInfo(animalKey, sexSearch, ageSearch, placeSearch);//img追加予定
					animalList.add(hit);
				}
				return animalList;
				}

			}else if( sexcase != null && agecase == null && placecase == null) {
				String sql =
						"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
						+ "FROM ANIMAL WHERE SEX=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, sexcase);

				//SELECTを実行
				ResultSet rs = pStmt.executeQuery();


				//SELECT文の結果をListに格納
				while(rs.next()) {
					int animalKey = rs.getInt("ANIMAL_KEY");
					String sexSearch = rs.getString("SEX");
					String ageSearch = rs.getString("AGE");
					String placeSearch = rs.getString("PLACE");
					AnimalInfo hit = new AnimalInfo(animalKey, sexSearch, ageSearch, placeSearch);//img追加予定
					animalList.add(hit);
				}
				return animalList;
			}
			String sql =
					"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
					+ "FROM ANIMAL WHERE PLACE=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, placecase);

			//SELECTを実行
			ResultSet rs = pStmt.executeQuery();


			//SELECT文の結果をListに格納
			while(rs.next()) {
				int animalKey = rs.getInt("ANIMAL_KEY");
				String sexSearch = rs.getString("SEX");
				String ageSearch = rs.getString("AGE");
				String placeSearch = rs.getString("PLACE");
				AnimalInfo hit = new AnimalInfo(animalKey, sexSearch, ageSearch, placeSearch);//img追加予定
				animalList.add(hit);
			}
			return animalList;


		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}



