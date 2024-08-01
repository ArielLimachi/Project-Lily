package umbrella.com.lilyproject.ImageProcessor;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomButtonGrid extends JPanel{

	List<JButton> buttons;
	List<JLabel> titles;
	Dimension dimension;
	Function a;
	
	public CustomButtonGrid() {
		Function<Integer, Double> half = a -> a / 2.0;
	}
	
	private void initializeButtons() {
		buttons = new ArrayList<JButton>();
		
	}
}
