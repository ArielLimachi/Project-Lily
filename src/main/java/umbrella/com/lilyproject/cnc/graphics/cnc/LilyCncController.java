package umbrella.com.lilyproject.cnc.graphics.cnc;

import umbrella.com.lilyprofect.utils.CncUtils;
import umbrella.com.lilyproject.ImageProcessor.CustomStroke;
import umbrella.com.lilyproject.cnc.MovementController;
import umbrella.com.lilyproject.cnc.graphics.DebugPanel;
import umbrella.com.lilyproject.usb.UsbCommunicator;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LilyCncController extends JPanel implements MovementController<List<CustomStroke>> {

    private DebugPanel debugger;

    private UsbCommunicator arduino;

    private List<CustomStroke> strokes;

    public LilyCncController(Dimension dimension) {
        setSize(dimension);
        setLocation(100, 100);
        setLayout(null);

        initializeArduino();
    }

    private void initializeArduino() {
        arduino = new UsbCommunicator();
        arduino.initializeArduino();
        Observer observer = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                String data = (arduino.getReceivedData() + "\n");
                //System.out.println("ankita -> " + data);
            }
        };
        arduino.addObserver(observer);
    }

    @Override
    public void move(List<CustomStroke> strokes) throws InterruptedException {
        for (CustomStroke stroke : strokes) {
            drawStroke(stroke);
        }
    }

    /*
    private void drawStroke(CustomStroke stroke) throws InterruptedException {
        Point origin = new Point(0, 0);

        //maybe put an if when point are the same

        for (Point nextPoint : stroke.getPointsList()) {
            int nextX = (int) nextPoint.getX();
            int nextY = (int) nextPoint.getY();
            int currentX = (int) origin.getX();
            int currentY = (int) origin.getY();

            arduino.resetReceivedData();
            arduino.sendData("IS_AVAILABLE");
            boolean isAvailable = Boolean.parseBoolean(arduino.getReceivedData());

            while (!isAvailable) {
                arduino.sendData("IS_AVAILABLE");
                isAvailable = Boolean.parseBoolean(arduino.getReceivedData());
                arduino.resetReceivedData();
                try {
                    Thread.sleep(22); // wait for 100 milliseconds
                } catch (InterruptedException e) {
                }
            }
            arduino.sendData("GOTOXY " + nextX + " " + nextY);
            //arduino.sendData("PENCIL_DOWN");
            origin = nextPoint;
        }
        //arduino.sendData("PENCIL_UP");
    }

     */

    private void drawStroke(CustomStroke stroke) throws InterruptedException {
        Point origin = new Point(0, 0);

        //maybe put an if when point are the same

        for (Point nextPoint : stroke.getPointsList()) {
            int nextX = (int) nextPoint.getX();
            int nextY = (int) nextPoint.getY();

            arduino.resetReceivedData();
            arduino.sendData("IS_AVAILABLE");
            boolean isAvailable = Boolean.parseBoolean(arduino.getReceivedData());

            while (!isAvailable) {
                arduino.sendData("IS_AVAILABLE");
                isAvailable = Boolean.parseBoolean(arduino.getReceivedData());
                arduino.resetReceivedData();
                try {
                    Thread.sleep(50); // wait for 100 milliseconds
                } catch (InterruptedException e) {
                }
            }
            arduino.sendData("GOTOXY " + nextX + " " + nextY);

            while (!isAvailable) {
                arduino.sendData("IS_AVAILABLE");
                isAvailable = Boolean.parseBoolean(arduino.getReceivedData());
                arduino.resetReceivedData();
                try {
                    Thread.sleep(50); // wait for 100 milliseconds
                } catch (InterruptedException e) {
                }
            }
            arduino.sendData("PENCIL_DOWN");
        }
        arduino.sendData("PENCIL_UP");
    }

}
