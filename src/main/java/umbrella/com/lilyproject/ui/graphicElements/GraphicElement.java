package umbrella.com.lilyproject.ui.graphicElements;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public class GraphicElement implements Drawable{
	private List<Integer> xCoordinates;
	private List<Integer> yCoordinates;
	private int numberOfPoints;
	private Polygon polygon;
	
	public GraphicElement (Polygon polygon) {
		this.polygon = polygon;
	}
	
	public GraphicElement (List<Point> points) {		
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
	
	@Override
	public void draw(Graphics2D graphics) {
		graphics.drawPolygon(polygon);		
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
}
