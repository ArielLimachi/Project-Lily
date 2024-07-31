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

import umbrella.com.lilyprofect.utils.Constants;

public class WordBox extends JPanel{
	
	String word;	
	Dimension dimension;
	Font font;
	Color color;
	
	int wordXOffset;
	int wordYOffset;
	int borderHorizontalOffset;
	int borderVerticalOffset;
	
	public WordBox(String word, Dimension dimension, Font font, Color color) {
		super();
		this.word = word;
		this.dimension = dimension;
		this.font = font;
		this.color = color;
		
		setDefaultValues();
	}		
	
	private void setDefaultValues() {
		wordXOffset = Constants.X_AXIS_WORD_OFFSET;
		wordYOffset = Constants.Y_AXIS_WORD_OFFSET;;
		borderHorizontalOffset = Constants.BORDER_HORIZONTAL_OFFSET;
		borderVerticalOffset = Constants.BORDER_VERTICAL_OFFSET;
	}
	
	private RectangleElement getBorderBox() {
		List<Point> boxPoints = new ArrayList<Point>();
		boxPoints.add(new Point(borderHorizontalOffset, borderVerticalOffset));
		boxPoints.add(new Point(dimension.width-borderHorizontalOffset,borderVerticalOffset));
		boxPoints.add(new Point(dimension.width-borderHorizontalOffset,dimension.height-borderVerticalOffset));
		boxPoints.add(new Point(borderHorizontalOffset,dimension.height-borderVerticalOffset));
				
		return new RectangleElement(boxPoints);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D) g;

        // Set the color
        g.setColor(color);
        
        // Set the font
        g.setFont(font);
        
        // Draw the string
        g.drawString(word,wordXOffset,wordYOffset);
        
        RectangleElement box = getBorderBox();
        box.draw(g2d);
    }
}
