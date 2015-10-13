import java.io.IOException;
import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author rodolfopeixoto
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		ReadTextFile application = new ReadTextFile();
		application.setSize(400, 400);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setVisible(true);
	}
}
