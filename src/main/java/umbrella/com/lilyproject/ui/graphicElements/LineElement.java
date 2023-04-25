package umbrella.com.lilyproject.ui.graphicElements;

import java.awt.Point;
import java.awt.Polygon;
import java.util.List;

public class LineElement extends GraphicElement{
	
	public LineElement(Polygon polygon) {
		super(polygon);		
	}	

	public LineElement(List<Point> points) {
		super(points);
	}
}
