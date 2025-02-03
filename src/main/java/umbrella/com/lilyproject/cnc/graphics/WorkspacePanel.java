package umbrella.com.lilyproject.cnc.graphics;

import umbrella.com.lilyprofect.utils.IJUtils.GraphicConstants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WorkspacePanel extends JPanel {

    private int currentX = 0; // Current X position of the load (in mm)
    private int currentY = 0; // Current Y position of the load (in mm)
    private List<Point> trail = new ArrayList<>(); // Stores the movement history

    public WorkspacePanel() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(
                GraphicConstants.WORKSPACE_WIDTH,
                GraphicConstants.WORKSPACE_HEIGHT
        ));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw the grid
        drawGrid(g2d);

        // Draw the axes
        drawAxes(g2d);

        // Draw the trail
        drawTrail(g2d);

        // Draw the load (red dot)
        drawLoad(g2d);
    }

    private void drawGrid(Graphics2D g2d) {
        g2d.setColor(GraphicConstants.GRID_COLOR);
        g2d.setStroke(new BasicStroke(GraphicConstants.GRID_LINE_THICKNESS));

        // Draw vertical grid lines
        for (int x = 0; x <= GraphicConstants.WORKSPACE_WIDTH; x += GraphicConstants.GRID_SPACING) {
            g2d.drawLine(x, 0, x, GraphicConstants.WORKSPACE_HEIGHT);
        }

        // Draw horizontal grid lines
        for (int y = 0; y <= GraphicConstants.WORKSPACE_HEIGHT; y += GraphicConstants.GRID_SPACING) {
            g2d.drawLine(0, y, GraphicConstants.WORKSPACE_WIDTH, y);
        }
    }

    private void drawAxes(Graphics2D g2d) {
        g2d.setColor(GraphicConstants.AXIS_COLOR);
        g2d.setStroke(new BasicStroke(GraphicConstants.AXIS_LINE_THICKNESS));

        // Draw X and Y axes
        g2d.drawLine(0, 0, GraphicConstants.WORKSPACE_WIDTH, 0); // X-axis
        g2d.drawLine(0, 0, 0, GraphicConstants.WORKSPACE_HEIGHT); // Y-axis

        // Draw tick marks and labels
        g2d.setFont(GraphicConstants.AXIS_FONT);
        for (int x = 0; x <= GraphicConstants.WORKSPACE_WIDTH; x += GraphicConstants.GRID_SPACING) {
            g2d.drawLine(x, -GraphicConstants.TICK_LENGTH, x, GraphicConstants.TICK_LENGTH); // X-axis ticks
            g2d.drawString(Integer.toString(x), x - 10, 20); // X-axis labels
        }
        for (int y = 0; y <= GraphicConstants.WORKSPACE_HEIGHT; y += GraphicConstants.GRID_SPACING) {
            g2d.drawLine(-GraphicConstants.TICK_LENGTH, y, GraphicConstants.TICK_LENGTH, y); // Y-axis ticks
            g2d.drawString(Integer.toString(y), 5, y + 5); // Y-axis labels
        }
    }

    private void drawTrail(Graphics2D g2d) {
        g2d.setColor(GraphicConstants.TRAIL_COLOR);
        g2d.setStroke(new BasicStroke(GraphicConstants.TRAIL_THICKNESS));

        // Draw lines between consecutive points in the trail
        for (int i = 1; i < trail.size(); i++) {
            Point p1 = trail.get(i - 1);
            Point p2 = trail.get(i);
            g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    private void drawLoad(Graphics2D g2d) {
        g2d.setColor(GraphicConstants.LOAD_COLOR);
        g2d.fillOval(
                currentX - GraphicConstants.LOAD_SIZE / 2,
                currentY - GraphicConstants.LOAD_SIZE / 2,
                GraphicConstants.LOAD_SIZE,
                GraphicConstants.LOAD_SIZE
        );
    }

    public void updateLoadPosition(int x, int y) {
        // Update the current position
        currentX = x;
        currentY = y;

        // Add the new position to the trail
        trail.add(new Point(x, y));

        // Repaint the panel to reflect the changes
        repaint();
    }

    public void reset() {
        // Reset the load position and clear the trail
        currentX = 0;
        currentY = 0;
        trail.clear();
        repaint();
    }
}