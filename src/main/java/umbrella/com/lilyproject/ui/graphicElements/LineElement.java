package umbrella.com.lilyproject.ui.graphicElements;

import java.awt.Point;
import java.awt.Polygon;

public class LineElement extends GraphicElement{
	private int x[];
	private int y[];
	int numberofpoints = 2;

	public LineElement(Polygon polygon) {
		super(polygon);
	}

	public LineElement(Point pointA, Point pointB) {
		super(null);
		int x[] = { pointA.x , pointB.x };	
        int y[] = { pointA.y , pointB.y };  
        int numberofpoints = 2; 
		setPolygon(new Polygon(x,y,numberofpoints));
	}

}
