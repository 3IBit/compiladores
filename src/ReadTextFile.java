import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
 

import javax.swing.JFileChooser;
import javax.swing.JFrame; 
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReadTextFile extends JFrame {

	private final JTextArea outputArea; // displays file contents
	// set up GUI

	public ReadTextFile() throws IOException {
		super("JFileChooser");
		outputArea = new JTextArea();
		add(new JScrollPane(outputArea)); // outputArea is scrollable
		openFile(); // get Path from user and display info
	}

	// display information about file or directory user specifies
	public void openFile() throws IOException {
		// get Path to user-selected file or directory
		Path path = getFileOrDirectoryPath();
		String pathString = path.toString();
		
		Lexica lex = new Lexica(pathString);
 
        
      
        
        
        JTextArea textArea = new JTextArea();//JTextArea(String a ser exibido)
        textArea.setLineWrap(true); //quebra de linha automática
        add(textArea);

	} // end method analyzePath

	// allow user to specify file or directory name
	private Path getFileOrDirectoryPath() {
		// configure dialog allowing selection of a file or directory
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = fileChooser.showOpenDialog(this);
		// if user clicked Cancel button on dialog, return
		if (result == JFileChooser.CANCEL_OPTION)
			System.exit(1);
		// return Path representing the selected file
		return fileChooser.getSelectedFile().toPath();
	}

}
