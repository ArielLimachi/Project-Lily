package umbrella.com.lilyproject.ui.graphicElements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class WordBox extends JPanel{
	
	String word;
	Dimension dimension;
	Font font;
	Color color;
	RectangleElement box;
	
	public WordBox(String word, Dimension dimension, Font font, Color color, RectangleElement box) {
		super();
		this.word = word;
		this.dimension = dimension;
		this.font = font;
		this.color = color;
		this.box = box;	
	}
	
	public WordBox() {
		dimension = new Dimension(500,500);
	}
	
	private RectangleElement getBorderBox() {
		List<Point> boxPoints = new ArrayList<Point>();
		boxPoints.add(new Point(2,2));
		boxPoints.add(new Point(dimension.width-2,2));
		boxPoints.add(new Point(dimension.width-2,dimension.height-2));
		boxPoints.add(new Point(2,dimension.height-2));
				
		box = new RectangleElement(boxPoints);
		return box;
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D) g;

        // Set the color
        g.setColor(Color.BLACK);
        
        // Set the font
        g.setFont(new Font("Serif", Font.BOLD, 24));
        
        // Draw the string
        g.drawString("Hello XD, World!", 50, 50);
        
        box = getBorderBox();
        box.draw(g2d);
    }
}
