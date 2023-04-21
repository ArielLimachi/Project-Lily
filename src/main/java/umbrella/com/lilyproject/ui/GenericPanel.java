package umbrella.com.lilyproject.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GenericPanel extends JPanel{

	public void paint (Graphics graphics) {
		super.paint(graphics);
		Graphics2D graphics2D = (Graphics2D) graphics;
		
		graphics2D.setColor (Color.blue);
		graphics2D.drawLine (0, 70, 100, 70);
		graphics2D.drawRect (150, 70, 50, 70);
		graphics2D.drawRoundRect (250, 70, 50, 70, 6, 6);
		graphics2D.drawOval (350, 70, 50, 70);
        int [] vx1 = {500, 550, 450};
        int [] vy1 = {70, 120, 120};
        graphics2D.drawPolygon (vx1, vy1, 3);

        graphics2D.setColor (Color.red);
        graphics2D.fillRect (150, 270, 50, 70);
        graphics2D.fillRoundRect (250, 270, 50, 70, 6, 6);
        graphics2D.fillOval (350, 270, 50, 70);
        int [] vx2 = {500, 550, 450};
        int [] vy2 = {270, 320, 320};
        graphics2D.fillPolygon (vx2, vy2, 3);
	}

}
