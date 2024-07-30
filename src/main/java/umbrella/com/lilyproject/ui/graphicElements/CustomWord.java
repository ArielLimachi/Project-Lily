package umbrella.com.lilyproject.ui.graphicElements;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class CustomWord extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the color
        g.setColor(Color.BLACK);
        
        // Set the font
        g.setFont(new Font("Serif", Font.BOLD, 24));
        
        // Draw the string
        g.drawString("Hello, World!", 50, 50);
    }   
}
