package umbrella.com.lilyproject.cnc.graphics;

import umbrella.com.lilyprofect.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartesianPlane extends JPanel implements ActionListener {
    private float gridTransparency;
    private float millimeterTransparency;
    private int numHorizontalLines;
    private int numVerticalLines;

    int planeX;
    int planeY;

    private Graphics2D pencil;

    int dotX;
    int dotY;
    int dotSize;
    Color dotColor;

    JButton forward;

    // Constructor
    public CartesianPlane(float gridTransparency, float millimeterTransparency, int numHorizontalLines, int numVerticalLines) {
        this.gridTransparency = gridTransparency;
        this.millimeterTransparency = millimeterTransparency;
        this.numHorizontalLines = numHorizontalLines;
        this.numVerticalLines = numVerticalLines;

        initializePlaneXY();
        initializePointer();

        forward = SwingUtils.getButton("->", 0, 0, 100, 30, this);
        add(forward);
    }

    private void initializePlaneXY() {
        planeX = 50;
        planeY = 50;
    }

    private void initializePointer() {
        dotX = planeX + 100; // Example X-coordinate
        dotY = planeY + 100; // Example Y-coordinate
        dotSize = 10; // Example size
        dotColor = Color.RED; // Example color
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        pencil = (Graphics2D) g;

        // Get the current size of the panel
        int planeWidth = getWidth() - 100;  // Adjust for margins
        int planeHeight = getHeight() - 100;  // Adjust for margins

        // Draw Cartesian plane with transparency
        AlphaComposite originalComposite = (AlphaComposite) pencil.getComposite();
        pencil.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, gridTransparency));

        // Calculate the distance between lines
        int horizontalSpacing = planeHeight / numHorizontalLines;
        int verticalSpacing = planeWidth / numVerticalLines;

        // Draw centimeter horizontal lines
        for (int i = 0; i <= numHorizontalLines; i++) {
            int y = planeY + i * horizontalSpacing;
            pencil.drawLine(planeX, y, planeX + planeWidth, y);
        }

        // Draw centimeter vertical lines
        for (int i = 0; i <= numVerticalLines; i++) {
            int x = planeX + i * verticalSpacing;
            pencil.drawLine(x, planeY, x, planeY + planeHeight);
        }

        // Draw millimeter lines with higher transparency
        pencil.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, millimeterTransparency));

        // Draw millimeter horizontal lines
        for (int i = 0; i <= numHorizontalLines * 10; i++) {
            int y = planeY + i * (horizontalSpacing / 10);
            //pencil.drawLine(planeX, y, planeX + planeWidth, y);
        }

        // Draw millimeter vertical lines
        for (int i = 0; i <= numVerticalLines * 10; i++) {
            int x = planeX + i * (verticalSpacing / 10);
            //pencil.drawLine(x, planeY, x, planeY + planeHeight);
        }

        // Draw numbers for the first quadrant
        pencil.setComposite(originalComposite);  // Reset transparency for numbers
        pencil.setFont(new Font("Arial", Font.PLAIN, 12));

        // Draw X-axis numbers
        for (int i = 0; i <= numVerticalLines; i++) {
            int x = planeX + i * verticalSpacing;
            pencil.drawString(String.valueOf(i), x - 5, planeY + planeHeight + 15);
        }

        // Draw Y-axis numbers
        for (int i = 0; i <= numHorizontalLines; i++) {
            int y = planeY + planeHeight - i * horizontalSpacing;
            pencil.drawString(String.valueOf(i), planeX - 20, y + 5);
        }

    }

    private void drawDot(int x, int y, int size, Color color) {
        pencil.setColor(color);
        pencil.fillOval(x - size / 2, y - size / 2, size, size);
        repaint();
    }

    public void setPoint(int dotX, int dotY) {
        drawDot(dotX, dotY, dotSize, dotColor);
        //pencil.setComposite(originalComposite);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == forward) {
            System.out.println("forward");
            setPoint(50, 50);
        }
    }
}

