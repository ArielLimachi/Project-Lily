package umbrella.com.lilyproject.ImageProcessor;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ij.ImagePlus;

public class CustomButtonGrid<K, V, I> extends JPanel {

	GridLayout gridLayout;

	List<JButton> buttons;
	List<JLabel> titles;
	Dimension dimension;

	Map<K, V> functions;

	public CustomButtonGrid(Map<K, V> functions, I image) {
		
		this.functions = functions;
		
		gridLayout = new GridLayout();

		setLayout(gridLayout);

		buttons = new ArrayList<JButton>();
		
		setButtons(image);
	}

	// Function<ImagePlus , ImagePlus>
	private <T, R> void setButtons(T image) {
		for (Map.Entry<K, V> entry : functions.entrySet()) {
			JButton button = new JButton((String) entry.getKey());
			Function<T, R> function = (Function<T, R>) entry.getValue();
			button.addActionListener(event -> function.apply(image));	
			
			add(button);
		}
	}
}
