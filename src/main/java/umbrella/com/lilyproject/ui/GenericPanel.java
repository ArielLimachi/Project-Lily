package umbrella.com.lilyproject.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import umbrella.com.lilyproject.ui.graphicElements.PolygonGraphicElement;
import umbrella.com.lilyproject.ui.graphicElements.LineElement;
import umbrella.com.lilyproject.ui.graphicElements.RectangleElement;
import umbrella.com.lilyproject.ui.graphicElements.TriangleElement;

public class GenericPanel extends JPanel {

	public void paint(Graphics graphics) {
		super.paint(graphics);
		Graphics2D graphics2D = (Graphics2D) graphics;
		
		List<Point> points3 = new ArrayList<>();
		points3.add(new Point(100, 100));
		points3.add(new Point(500, 100));		
		points3.add(new Point(300, 300));
		TriangleElement triangle = new TriangleElement(points3);
		triangle.draw(graphics2D);
				
		List<Point> points2 = new ArrayList<>();
		points2.add(new Point(200, 200));
		points2.add(new Point(400, 400));
		LineElement myLine = new LineElement(points2);
		myLine.draw(graphics2D);
		
		List<Point> points1 = new ArrayList<>();
		points1.add(new Point(300, 250));
		points1.add(new Point(600, 250));
		points1.add(new Point(600, 550));
		points1.add(new Point(300, 550));
		RectangleElement square = new RectangleElement(points1);
		
		square.draw(graphics2D);
		
		
	}
}
