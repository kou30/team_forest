import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
@SuppressWarnings("serial")
public class DB2BlogGetSample extends JFrame {
    // 復元した画像表示用
    public JLabel pictLabel;
    public void find() {

    	String JDBC_URL = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8";
		String DB_USER = "test_user";
		String DB_PASS = "test_pass";

        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                Statement stmt = con.createStatement()) {
            // 登録した画像データを検索
            ResultSet rs = stmt.executeQuery("SELECT img FROM images");
            rs.next();
            byte[] bytes = rs.getBytes("img");
            // 復元してラベルに表示
            pictLabel.setIcon(new ImageIcon(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public DB2BlogGetSample() {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pictLabel = new JLabel();
        getContentPane().add(pictLabel, BorderLayout.CENTER);
    }
}