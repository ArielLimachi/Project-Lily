package umbrella.com.lilyprofect.utils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ij.ImagePlus;
import ij.process.ImageProcessor;

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

	// List of Font family names
	public static String[] getFontFamilyNames() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		return ge.getAvailableFontFamilyNames();
	}

	// Function to resize an ImagePlus using the IJ library
	public static ImagePlus resizeImage(ImagePlus imagePlus, double reescaleFactor) {
		ImagePlus resizedImage = null;
		int width = (int) (imagePlus.getWidth() * reescaleFactor);
		int height = (int) (imagePlus.getHeight() * reescaleFactor);
		if (imagePlus != null) {
			ImageProcessor processor = imagePlus.getProcessor();
			ImageProcessor resizedProcessor = processor.resize(width, height);
			resizedImage = new ImagePlus("Resized Image", resizedProcessor);
		}
		return resizedImage;
	}

	// Function to transform an ImagePlus to a BufferedImage
	public static BufferedImage getBufferedImage(ImagePlus imagePlus) {
		BufferedImage image = null;
		if (imagePlus != null) {
			image = imagePlus.getBufferedImage();
		}
		return image;
	}

	// Function to get a Buffered Image rendered in a JPanel
	public static JPanel getImageInPanel(BufferedImage image) {
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (image != null) {
					// Draw the BufferedImage on the JPanel
					// g.drawImage(image, 0, 0, null);
					g.drawImage(image, 0, 0, null);
				}
			}
		};

		return panel;
	}

	public static JPanel getButtonInGridPanel(List<JButton> buttons) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		
		for (Iterator iterator = buttons.iterator(); iterator.hasNext();) {
			JButton jButton = (JButton) iterator.next();
			panel.add(jButton);
		}

		return panel;
	}

	public static Dimension getImageResizeDimension(ImagePlus imagePlus, double percentageFactorReduction) {
		int width = (int) Math.round(imagePlus.getWidth() * percentageFactorReduction);
		int height = (int) Math.round(imagePlus.getHeight() * percentageFactorReduction);

		return new Dimension(width, height);
	}
}
