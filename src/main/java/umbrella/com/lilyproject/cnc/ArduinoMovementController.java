package umbrella.com.lilyproject.cnc;

import umbrella.com.lilyprofect.utils.Constants;
import umbrella.com.lilyproject.usb.UsbCommunicator;

import java.util.Observable;
import java.util.Observer;

public class ArduinoMovementController implements MovementController<Integer, String> {

    private UsbCommunicator arduino;
    private String arduinoData;

    private int stepperStep;
    private boolean hasAcceleration;
    private String command;

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
    public void move(Integer position) {

        if (position == 0){
            goToStartRoutine();
        }
        if (position > 0){ // move forward
            arduino.sendData("o" + " " + position + " " + 2500);
        }
        if (position < 0){ // move backwards
            arduino.sendData("c" + " " + -position + " " + 2500);
        }
    }

    @Override
    public void setParameter(String parameterName, Integer parameter) {
        switch (parameterName){
            case "acceleration":
                arduino.sendData("a " + parameter);
        }
    }

    private void goToStartRoutine() {
        arduino.sendData("g");
    }




}
