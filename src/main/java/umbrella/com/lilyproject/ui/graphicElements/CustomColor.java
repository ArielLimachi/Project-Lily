package umbrella.com.lilyproject.ui.graphicElements;

import java.awt.Color;
import java.awt.Graphics2D;

public class CustomColor extends GraphicElementDecorator{

	public CustomColor(Decoration Decoration) {
		super(Decoration);
	}

	@Override
	public void decorate(Graphics2D graphics) {
		graphics.setColor(Color.BLUE);		
	}
}
