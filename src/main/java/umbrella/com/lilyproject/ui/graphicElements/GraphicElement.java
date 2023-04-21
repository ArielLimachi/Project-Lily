package umbrella.com.lilyproject.ui.graphicElements;

import java.awt.Graphics2D;
import java.awt.Polygon;

public class GraphicElement implements Drawable{
	private Polygon polygon;
	
	public GraphicElement (Polygon polygon) {
		this.polygon = polygon;
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
}
