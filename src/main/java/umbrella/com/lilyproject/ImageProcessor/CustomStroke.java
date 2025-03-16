package umbrella.com.lilyproject.ImageProcessor;

import ij.plugin.FFT;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class CustomStroke {
    private List<Point> stroke;

    public CustomStroke() {
        stroke = new ArrayList<>();
    }

    public void addPoint(Point newPoint) {
        stroke.add(newPoint);
    }

    public boolean isNeighborPoint(Point origin, Point destination) {
        return (int) origin.distance(destination) == 1;
    }

    public List<Point> getNeighborhoodPoints(Point originPoint) {
        Point point1 = new Point(Math.abs((int) originPoint.getX() - 1), Math.abs((int) originPoint.getY() + 1));
        Point point2 = new Point(Math.abs((int) originPoint.getX()), Math.abs((int) originPoint.getY() + 1));
        Point point3 = new Point(Math.abs((int) originPoint.getX() + 1), Math.abs((int) originPoint.getY() + 1));

        Point point4 = new Point(Math.abs((int) originPoint.getX() - 1), Math.abs((int) originPoint.getY()));
        Point point5 = new Point(Math.abs((int) originPoint.getX() + 1), Math.abs((int) originPoint.getY()));

        Point point6 = new Point(Math.abs((int) originPoint.getX() - 1), Math.abs((int) originPoint.getY() - 1));
        Point point7 = new Point(Math.abs((int) originPoint.getX()), Math.abs((int) originPoint.getY() - 1));
        Point point8 = new Point(Math.abs((int) originPoint.getX() + 1), Math.abs((int) originPoint.getY() - 1));

        List<Point> neighborhood = new ArrayList<>();

        neighborhood.add(point1);
        neighborhood.add(point2);
        neighborhood.add(point3);
        neighborhood.add(point4);
        neighborhood.add(point5);
        neighborhood.add(point6);
        neighborhood.add(point7);
        neighborhood.add(point8);

        return neighborhood;
    }

    public Point getNextStrokeStep(Point origin, List<Point> neighborhood, BufferedImage image) {
        Point nextStrokeStepPoint = null;
        int xOrigin = (int) origin.getX();
        int yOrigin = (int) origin.getY();
        for (Point neighbor : neighborhood) {
            int x = (int) neighbor.getX();
            int y = (int) neighbor.getY();
            if (image.getRGB(xOrigin, yOrigin) == image.getRGB(x, y)) {
                nextStrokeStepPoint = new Point(x, y);
            }
        }
        return nextStrokeStepPoint;
    }

    public CustomStroke getStroke(Point origin, BufferedImage image) {
        CustomStroke stroke = new CustomStroke();
        while (getNextStrokeStep(origin, getNeighborhoodPoints(origin), image) != null) {
            stroke.addPoint(origin);
            //we get the next Point that is black
            Point nextStrokePointPath = getNextStrokeStep(origin, getNeighborhoodPoints(origin), image);
            //we add this point to the stroke
            stroke.addPoint(nextStrokePointPath);
            //we delete the origin Point from the image and update the new origin Point
            image.setRGB((int)origin.getX(),(int)origin.getY(),0);
            origin = nextStrokePointPath;
        }
        return stroke;
    }

    public List<Point> getPointsList(){
        return stroke;
    }
}
