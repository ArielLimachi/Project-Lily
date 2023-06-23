package umbrella.com.lilyproject.ui.graphicComponents;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import umbrella.com.lilyproject.ui.graphicElements.GraphicElement;
import umbrella.com.lilyproject.ui.graphicElements.LineElement;

public class GridComponent extends JPanel {

	private List<LineElement> verticalLines;
	private List<LineElement> horizontalLines;

	private int length;
	private int size;
	private int gap;

	private Point position = new Point(0, 0);

	private List<Point> shapePoints;

	Graphics2D graphics2D;

	public GridComponent(Point position, int size, int length) {
		this.size = size;
		this.length = length;
		this.gap = length / size;

		shapePoints = new ArrayList<>();

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
		graphics2D = (Graphics2D) graphics;

		drawVerticalLines(graphics2D);
		drawHorizontalLines(graphics2D);
		
		drawLine();
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

	private void drawLine() {
        // Clear the shape points list for each new draw
        shapePoints.clear();

        // Draw the shape (modify this based on the desired shape)
        
        int[] xpoints = {0, 80};
        int[] ypoints = {0, 85};
        
        Polygon linePoints = new Polygon(xpoints, ypoints, 2);
        LineElement line = new LineElement(linePoints); // Replace with the appropriate shape generation method
        line.draw(graphics2D);

        // Add the shape points to the list
        //shapePoints.addAll(line.getPoints()); // Replace with the appropriate shape points retrieval method
    }

}
