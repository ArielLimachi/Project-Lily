package umbrella.com.lilyproject.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JPanel;

import umbrella.com.lilyproject.ui.graphicElements.GraphicElement;
import umbrella.com.lilyproject.ui.graphicElements.LineElement;

public class GenericPanel extends JPanel {

	public void paint(Graphics graphics) {
		super.paint(graphics);
		Graphics2D graphics2D = (Graphics2D) graphics;

		int x[] = { 10, 30, 40, 50, 110, 140 };		  
        // y coordinates of vertices
        int y[] = { 140, 110, 50, 40, 30, 10 };  
        // number of vertices
        int numberofpoints = 6; 
        
		Polygon polygon = new Polygon(x,y,numberofpoints);
		GraphicElement line = new GraphicElement(polygon);
		line.draw(graphics2D);
		
		LineElement myLine = new LineElement(new Point(20,150), new Point(150,20));
		myLine.draw(graphics2D);
		
		LineElement myLine2 = new LineElement(new Point(50,200), new Point(150,20));
		myLine2.draw(graphics2D);
	}
}
