package umbrella.com.lilyproject.utils;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class SwingComponentUtils {
	
	public JButton buildButton(String text, Rectangle bounds) {
		JButton button = new JButton(text);
		button.setBounds(bounds);
		return button;
	}
	
	public JLabel buildLabel(String text, Rectangle bounds) {
		JLabel label = new JLabel(text);
		label.setBounds(bounds);
		return label;
	}
	
	public static JComboBox<String> buildComboBox(Rectangle bounds){
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(bounds);
		return comboBox;
	}
}
