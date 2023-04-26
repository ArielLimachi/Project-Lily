package umbrella.com.lilyproject.ui.graphicComponents;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import umbrella.com.lilyproject.ui.graphicElements.GraphicElement;
import umbrella.com.lilyproject.ui.graphicElements.LineElement;

public class GridComponent extends JPanel{
	
	private List<LineElement> verticalLines;
	private List<LineElement> horizontalLines;
			
	private int length;	
	private int size;	
	private int gap;

	private Point position = new Point(0,0);
	
	public GridComponent(Point position, int size, int length) {
		this.size = size;
		this.length = length;
		this.gap = length/size;
		
		setLayout(null);
		setSize(this.length, this.length);
		setLocation(position);
		
		verticalLines = new ArrayList<>();
		horizontalLines = new ArrayList<>();		
	}
	
	private LineElement generateVerticalBaseLine() {
		List<Point> baseLinePoints = new ArrayList<>();
		baseLinePoints.add(position);
		baseLinePoints.add(new Point(position.x, position.y + length));
		
		return new LineElement(baseLinePoints);
	}
		
	private LineElement generateHorizontalBaseLine() {
		List<Point> baseLinePoints = new ArrayList<>();
		baseLinePoints.add(position);
		baseLinePoints.add(new Point(position.x + length, position.y));
		
		return new LineElement(baseLinePoints);
	}
	
	public void paint(Graphics graphics) {
		super.paint(graphics);
		Graphics2D graphics2D = (Graphics2D) graphics;
		
		drawVerticalLines(graphics2D);
		drawHorizontalLines(graphics2D);
	}
	
	private void drawVerticalLines(Graphics2D graphics2D) {
		LineElement line = generateVerticalBaseLine();		
		for (int i = 0; i < size + 1; i++) {
			line = line.getVerticalParallelLine(line, gap);
			line.draw(graphics2D);
		}
	}
	
	private void drawHorizontalLines(Graphics2D graphics2D) {
		LineElement line = generateHorizontalBaseLine();		
		for (int i = 0; i < size + 1; i++) {
			line = line.getHorizontalParallelLine(line, gap);
			line.draw(graphics2D);
		}
	}
}
