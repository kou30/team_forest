package dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AnimalInfo;
import servlet.SearchServlet;

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


	public List<AnimalInfo>search(String sex, String age, String place) {
		List<AnimalInfo>animalList = new ArrayList<>();

		//データベース接続
		try(Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)){
			//SELECT文の準備
			if(sex.length() != 0 && age.length() != 0 && place.length() != 0){

				String sql =
						"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
						+ "FROM ANIMAL WHERE SEX=? OR AGE=? OR PLACE=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, sex);
				pStmt.setString(2, age);
				pStmt.setString(3, place);
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

			}else if(sex.length() != 0 && age.length() != 0){
				String sql =
					"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
					+ "FROM ANIMAL WHERE SEX=? OR AGE=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, sex);
				pStmt.setString(2, age);

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

				}else {
				String sql =
					"SELECT ANIMAL_KEY, SEX, AGE, PLACE "//IMAGE追加予定
					+ "FROM ANIMAL WHERE SEX=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, sex);

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
		}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return animalList;

	}}

