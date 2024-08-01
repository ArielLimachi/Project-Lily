package umbrella.com.lilyproject.ImageProcessor;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageProcessingMainFrame extends JFrame {
	
	private JLabel title;
	private JPanel image;
	private List<JButton> processButtons;	
	
	public ImageProcessingMainFrame() {
		setLayout(null);
		setSize(600, 600);
		setLocation(600, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
