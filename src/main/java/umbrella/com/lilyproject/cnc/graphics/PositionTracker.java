package umbrella.com.lilyproject.cnc.graphics;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PositionTracker {

    private int currentX; // Current X position (in mm)
    private int currentY; // Current Y position (in mm)
    private List<Point> trail; // Movement history

    public PositionTracker() {
        this.currentX = 0;
        this.currentY = 0;
        this.trail = new ArrayList<>();
        trail.add(new Point(currentX, currentY)); // Add the initial position to the trail
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public List<Point> getTrail() {
        return trail;
    }

    public void updatePosition(int deltaX, int deltaY) {
        // Update the current position
        currentX += deltaX;
        currentY += deltaY;

        // Add the new position to the trail
        trail.add(new Point(currentX, currentY));
    }

    public void reset() {
        // Reset the position and clear the trail
        currentX = 0;
        currentY = 0;
        trail.clear();
        trail.add(new Point(currentX, currentY)); // Add the initial position to the trail
    }
}
