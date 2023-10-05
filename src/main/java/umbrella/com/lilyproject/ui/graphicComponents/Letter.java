package umbrella.com.lilyproject.ui.graphicComponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.AffineTransform;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Letter extends JPanel implements ItemListener {

	JComboBox<String> fontList;
	private char letter;
	private Font font;
	private Point location;

	public Letter(char letter, Font font, Point location) {
		setLayout(null);
		setBackground(Color.MAGENTA);
		setLocation(new Point(0, 0));
		setSize(300, 300);

		this.letter = letter;
		this.font = font;
		this.location = location;
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Font font = new Font("Baskerville Old Face", Font.PLAIN, 96);
		g2d.setFont(this.font);
		g2d.drawString("" + letter, location.x, location.y);			
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == fontList) {
			String seleccionado = (String) fontList.getSelectedItem();
			// fontListUi.setTitle(seleccionado);
		}
	}

	
}
