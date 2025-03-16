package umbrella.com.lilyproject.cnc.graphics.cnc;

import umbrella.com.lilyprofect.utils.CncUtils;
import umbrella.com.lilyprofect.utils.SwingUtils;
import umbrella.com.lilyproject.cnc.MovementController;
import umbrella.com.lilyproject.usb.UsbCommunicator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class DirectionalController extends JPanel implements MovementController<String>, ActionListener {

    private UsbCommunicator arduino;

    JButton north, south, east, west, northeast, northwest, southeast, southwest;
    JButton xGoToStart, xStop;
    JButton yGoToStart, yStop;
    JButton pencilUp, pencilDown;

    int speed;
    int steps;

    public DirectionalController(Dimension dimension) {
        setSize(dimension);
        setLocation(100, 100);
        setLayout(null);

        speed = 500;
        steps = 20;

        initializeButtons();

        initializeArduino();
    }

    private void initializeButtons() {
        northeast = SwingUtils.getButton("NE", 0, 0, 50, 50, this);
        north = SwingUtils.getButton("↑", 60, 0, 50, 50, this);
        northwest = SwingUtils.getButton("NW", 120, 0, 50, 50, this);
        east = SwingUtils.getButton("←", 0, 60, 50, 50, this);
        west = SwingUtils.getButton("→", 120, 60, 50, 50, this);
        southeast = SwingUtils.getButton("SE", 0, 120, 50, 50, this);
        south = SwingUtils.getButton("↓", 60, 120, 50, 50, this);
        southwest = SwingUtils.getButton("SW", 120, 120, 50, 50, this);

        xGoToStart = SwingUtils.getButton("Go To Start X", 180, 0, 120, 50, this);
        xStop = SwingUtils.getButton("Stop X", 310, 0, 120, 50, this);

        yGoToStart = SwingUtils.getButton("Go To Start Y", 180, 60, 120, 50, this);
        yStop = SwingUtils.getButton("Stop Y", 310, 60, 120, 50, this);

        pencilDown = SwingUtils.getButton("Pencil Down", 180, 120, 120, 50, this);
        pencilUp = SwingUtils.getButton("Pencil Up", 310, 120, 120, 50, this);

        add(xGoToStart);
        add(xStop);
        add(yGoToStart);
        add(yStop);
        add(pencilDown);
        add(pencilUp);

        add(northeast);
        add(north);
        add(northwest);
        add(southeast);
        add(south);
        add(southwest);
        add(east);
        add(west);
    }

    private void initializeArduino() {
        arduino = new UsbCommunicator();
        arduino.initializeArduino();
        Observer observer = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                String data = (arduino.getReceivedData() + "\n");
            }
        };
        arduino.addObserver(observer);
    }

    @Override
    public void move(String data) {
        arduino.sendData(data);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        if (obj.equals(north)) {
            move("GOTOXY 2000 2000");
        }

        if (obj.equals(northeast)) {
            move("GOTOXY 100 100");
        }

        if (obj.equals(northwest)) {

        }

        if (obj.equals(south)) {
            move("GOTOXY 0 0");
        }

        if (obj.equals(southeast)) {

        }

        if (obj.equals(southwest)) {

        }

        if (obj.equals(east)) {
            move("HOME_X");
        }

        if (obj.equals(west)) {
            move("HOME_Y");
        }

        if (obj.equals(pencilUp)) {
            move("PENCIL_UP");
        }

        if (obj.equals(pencilDown)) {
            move("PENCIL_DOWN");
        }
    }

    /*
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        if (obj.equals(north)) {
            //move("x" + "," + "constantMovementForward" + "," + steps + "," + speed);
            move(CncUtils.goNorth());
            System.out.println("north");
        }

        if (obj.equals(northeast)) {
            //move("x" + "," + "constantMovementForward" + "," + steps + "," + speed);
            //move("y" + "," + "constantMovementForward" + "," + steps + "," + speed);
            move(CncUtils.goNorth());
            move(CncUtils.goEast());
            System.out.println("north-east");
        }

        if (obj.equals(northwest)) {
            //move("x" + "," + "constantMovementForward" + "," + steps + "," + speed);
            //move("y" + "," + "constantMovementBackward" + "," + steps + "," + speed);
            move(CncUtils.goNorth());
            move(CncUtils.goWest());
            System.out.println("north-west");
        }

        if (obj.equals(south)) {
            //move("x" + "," + "constantMovementBackward" + "," + steps + "," + speed);
            move(CncUtils.goSouth());
            System.out.println("south");
        }//goToStart

        if (obj.equals(southeast)) {
            //move("x" + "," + "constantMovementBackward" + "," + steps + "," + speed);
            //move("y" + "," + "constantMovementForward" + "," + steps + "," + speed);
            move(CncUtils.goSouth());
            move(CncUtils.goEast());
            System.out.println("north-east");
        }

        if (obj.equals(southwest)) {
            //move("x" + "," + "constantMovementBackward" + "," + steps + "," + speed);
            //move("y" + "," + "constantMovementBackward" + "," + steps + "," + speed);
            move(CncUtils.goSouth());
            move(CncUtils.goWest());
            System.out.println("north-west");
        }

        if (obj.equals(east)) {
            //move("y" + "," + "constantMovementForward" + "," + steps + "," + speed);
            move(CncUtils.goEast());
            System.out.println("east");
        }

        if (obj.equals(west)) {
            //move("y" + "," + "constantMovementBackward" + "," + steps + "," + speed);
            move(CncUtils.goWest());
            System.out.println("west");
        }

        if (obj.equals(pencilUp)) {
            //move("z" + "," + "constantMovementBackward" + "," + steps + "," + speed);
            move(CncUtils.goUp());
            System.out.println("pencil up");
        }

        if (obj.equals(pencilDown)) {
            //move("z" + "," + "constantMovementForward" + "," + steps + "," + speed);
            move(CncUtils.goDown());
            System.out.println("pencil down");
        }
    }
     */
}
