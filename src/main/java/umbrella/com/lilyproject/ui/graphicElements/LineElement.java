package umbrella.com.lilyproject.ui.graphicElements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public class LineElement extends PolygonGraphicElement{
	
	public LineElement(Polygon polygon) {
		super(polygon);		
	}	

	public LineElement(List<Point> points) {
		super(points);
	}
	
	@Override
	public void decorate(Graphics2D graphics) {	
		graphics.setColor(Color.RED);
	}
	
	public LineElement getVerticalParallelLine(LineElement baseLine, int distance) {
		List<Point> points = new ArrayList<>();
		points.add(new Point(baseLine.getxCoordinates().get(0) + distance, baseLine.getyCoordinates().get(0)));
		points.add(new Point(baseLine.getxCoordinates().get(1) + distance, baseLine.getyCoordinates().get(1)));
		return new LineElement(points);
	}
	
	public LineElement getHorizontalParallelLine(LineElement baseLine, int distance) {
		List<Point> points = new ArrayList<>();
		points.add(new Point(baseLine.getxCoordinates().get(0), baseLine.getyCoordinates().get(0) + distance));
		points.add(new Point(baseLine.getxCoordinates().get(1), baseLine.getyCoordinates().get(1) + distance));
		return new LineElement(points);
	}
}
