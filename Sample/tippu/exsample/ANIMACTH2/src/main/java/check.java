import javax.swing.SwingUtilities;

public class check extends DB2BlogGetSample{
	public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DB2BlogGetSample frame = new DB2BlogGetSample();
                frame.setVisible(true);
                frame.find();
            }
        });
	}
}


