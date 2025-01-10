package umbrella.com.lilyproject.cnc;

import umbrella.com.lilyprofect.utils.Constants;
import umbrella.com.lilyproject.usb.UsbCommunicator;

import java.util.Observable;
import java.util.Observer;

public class ArduinoMovementController implements MovementController<Integer> {

    private UsbCommunicator arduino;
    private String arduinoData;

    public ArduinoMovementController() {
        initializeArduino();
    }

    private void initializeArduino() {
        arduino = new UsbCommunicator();

        Observer observer = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                arduinoData = arduino.getReceivedData() + "\n";
            }
        };
        arduino.addObserver(observer);
    }

    @Override
    public void move(Integer data) {
        //arduino.sendData(Constants.EMPTY_STRING + data);
    }

}
