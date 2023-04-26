package umbrella.com.lilyproject.ui.graphicElements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public class PolygonGraphicElement extends GraphicElement{
	private List<Integer> xCoordinates;
	private List<Integer> yCoordinates;
	private int numberOfPoints;
	private Polygon polygon;
	
	public PolygonGraphicElement (Polygon polygon) {
		this.polygon = polygon;
	}
	
	public PolygonGraphicElement (List<Point> points) {		
		this.numberOfPoints = points.size();
		xCoordinates = new ArrayList<>();
		yCoordinates = new ArrayList<>();
		
		for (Point point : points) {
			xCoordinates.add(point.x);
			yCoordinates.add(point.y);
		}
				
		this.polygon = new Polygon(convertListToArray(this.xCoordinates),
							  convertListToArray(this.yCoordinates), 
							  this.numberOfPoints);
	}
	
	private int[] convertListToArray(List<Integer> numbers) {
		int[] result = numbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
		return result;
	}
		
	public Polygon getPolygon() {
		return polygon;
	}

	public void setPolygon(Polygon polygon) {
		this.polygon = polygon;
	}

	public List<Integer> getxCoordinates() {
		return xCoordinates;
	}

	public void setxCoordinates(List<Integer> xCoordinates) {
		this.xCoordinates = xCoordinates;
	}

	public List<Integer> getyCoordinates() {
		return yCoordinates;
	}

	public void setyCoordinates(List<Integer> yCoordinates) {
		this.yCoordinates = yCoordinates;
	}

	public int getNumberOfPoints() {
		return numberOfPoints;
	}

	public void setNumberOfPoints(int numberOfPoints) {
		this.numberOfPoints = numberOfPoints;
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.drawPolygon(polygon);			
	}

	@Override
	public void decorate(Graphics2D graphics) {		
	}
}
