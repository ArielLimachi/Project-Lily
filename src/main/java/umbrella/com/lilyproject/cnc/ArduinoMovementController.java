package umbrella.com.lilyproject.cnc;

import umbrella.com.lilyproject.usb.UsbCommunicator;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class ArduinoMovementController implements MovementController<Map<String, Integer>> {

    private UsbCommunicator arduino;
    private String arduinoData;

    public ArduinoMovementController() {
        initializeArduino();
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
    public void move(Map<String, Integer> data) {

        int position = data.get("position");
        int direction = data.get("direction");
        int velocity = data.get("velocity");
        int acceleration = data.get("acceleration");
        int routine = data.get("routine");

        switch (routine) {
            case 1:
                arduino.sendData("g");
        }

        arduino.sendData("a " + acceleration);

        if (direction == 1) { // move forward
            //arduino.sendData("o" + " " + position + " " + velocity);
            //arduino.sendData("v" + " " + convertToSteps(position) + " " + velocity);
            arduino.sendData("v" + " " + position + " " + velocity);
        }
        if (direction == -1) { // move backwards
            //arduino.sendData("c" + " " + position + " " + velocity);
            //arduino.sendData("b" + " " + convertToSteps(position) + " " + velocity);
            arduino.sendData("b" + " " + position + " " + velocity);
        }
    }

    private void goToStartRoutine() {
        arduino.sendData("g");
    }

    private int convertToSteps(int millimeters) {
        int steps = 0;

        if (millimeters == 10) {
            steps = 295;
        } else if (millimeters == 20) {
            steps = 555;
        } else if (millimeters == 30) {
            steps = 800;
        } else if (millimeters == 40) {
            steps = 1050;
        } else if (millimeters == 60) {
            steps = 1550;
        } else if (millimeters > 10 && millimeters < 20) {
            steps = interpolateSteps(10, 295, 20, 555, millimeters);
        } else if (millimeters > 20 && millimeters < 30) {
            steps = interpolateSteps(20, 555, 30, 800, millimeters);
        } else if (millimeters > 30 && millimeters < 40) {
            steps = interpolateSteps(30, 800, 40, 1050, millimeters);
        } else if (millimeters > 40 && millimeters < 60) {
            steps = interpolateSteps(40, 1050, 60, 1550, millimeters);
        } else {
            // Handling other ranges using linear interpolation with the last known interval
            steps = interpolateSteps(40, 1050, 60, 1550, millimeters);
        }

        return steps;
    }

    private int interpolateSteps(int x1, int y1, int x2, int y2, int x) {
        return y1 + (y2 - y1) * (x - x1) / (x2 - x1);
    }
}
