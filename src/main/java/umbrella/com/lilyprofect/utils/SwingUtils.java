package umbrella.com.lilyprofect.utils;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingUtils {
	public static JButton getButton(String text, int x, int y, int width, int height, ActionListener actionListener) {
		JButton button = new JButton(text);
		button.setBounds(x, y, width, height);
		button.addActionListener(actionListener);
		return button;
	}

	public static JLabel getLabel(String text, int x, int y, int width, int height) {
		JLabel label = new JLabel(text);
		label.setBounds(x, y, width, height);
		return label;
	}

	public static JTextField getTextField(String text, int x, int y, int width, int height) {
		JTextField textField = new JTextField(text);
		textField.setBounds(x, y, width, height);
		return textField;
	}
	
	public static JTextArea JTextArea(String text, int x, int y, int width, int height) {
		JTextArea textArea = new JTextArea(text);
		textArea.setBounds(x, y, width, height);
		return textArea;
	}
	
	public static JScrollPane getScrollPane(int x, int y, int width, int height) {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(x, y, width, height);
		return scrollPane;
	}
	
	public static JPanel getPanel() {
		JPanel panel = new JPanel(new BorderLayout(5, 5));
		return panel;
	}
	
	//List of Font family names
	public static String[] getFontFamilyNames(){
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        return ge.getAvailableFontFamilyNames();
	}
}
