package umbrella.com.lilyproject.cnc.graphics.cnc;

import umbrella.com.lilyproject.ImageProcessor.CustomStroke;

import java.awt.*;

public class StrokeSerializer {

    public static String serializeStroke(CustomStroke stroke) {
        StringBuilder sb = new StringBuilder();
        sb.append("DRAW_STROKE ");
        sb.append("STROKE_START");

        for (Point point : stroke.getPointsList()) {
            sb.append(",").append(point.x).append(",").append(point.y);
        }

        sb.append(",STROKE_END");
        //return sb.toString();
        return "DRAW_STROKE STROKE_START,100,100,200,200,0,0,STROKE_END";
    }
}
