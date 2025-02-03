package umbrella.com.lilyprofect.utils.IJUtils;

import java.awt.*;

public class GraphicConstants {

    // Workspace dimensions
    public static final int WORKSPACE_WIDTH = 1000; // in mm
    public static final int WORKSPACE_HEIGHT = 500; // in mm

    // Grid properties
    public static final int GRID_SPACING = 50; // distance between grid lines in mm
    public static final Color GRID_COLOR = Color.LIGHT_GRAY;
    public static final int GRID_LINE_THICKNESS = 1;

    // Axis properties
    public static final Color AXIS_COLOR = Color.BLACK;
    public static final int AXIS_LINE_THICKNESS = 2;
    public static final int TICK_LENGTH = 5; // length of tick marks in pixels
    public static final Font AXIS_FONT = new Font("Arial", Font.PLAIN, 12);

    // Load representation
    public static final Color LOAD_COLOR = Color.RED;
    public static final int LOAD_SIZE = 10; // diameter of the red dot in pixels

    // Trail properties
    public static final Color TRAIL_COLOR = Color.BLUE;
    public static final int TRAIL_THICKNESS = 2;

    // Debug panel properties
    public static final Font DEBUG_FONT = new Font("Monospaced", Font.PLAIN, 12);
    public static final Color DEBUG_BACKGROUND_COLOR = Color.WHITE;
    public static final Color DEBUG_TEXT_COLOR = Color.BLACK;
}