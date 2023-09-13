package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Quiz;

public class QuizDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8";
	private final String DB_USER  = "test_user";
	private final String DB_PASS  = "test_pass";

	public List<Quiz> findAll() {
		List<Quiz> quizList = new ArrayList<>();

		//データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql = "SELECT PKEY, PROBLEM, ANS_A, ANS_B, ANS_C, ANSWER, AITEM, GENRE FROM QUIZ ORDER BY RAND() limit 5";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECTを実行
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayLisｔに格納
			while (rs.next()) {
				int  pkey           = rs.getInt("PKEY");
				String problem = rs.getString("PROBLEM");
				String ans_a     = rs.getString("ANS_A");
				String ans_b     = rs.getString("ANS_B");
				String ans_c     = rs.getString("ANS_C");
				String answer   = rs.getString("ANSWER");
				String aitem     = rs.getString("AITEM");
				String genre     = rs.getString("GENRE");
				String ans   = null;
				String hit_out   = null;

				Quiz quiz = new Quiz(pkey, problem, ans_a, ans_b, ans_c, answer, aitem, genre, ans, hit_out);
				quizList.add(quiz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return quizList;
	}
}