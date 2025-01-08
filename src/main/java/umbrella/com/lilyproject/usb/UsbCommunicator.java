package umbrella.com.lilyproject.usb;

import java.util.Observer;

import umbrella.com.lilyprofect.utils.Constants;

public class UsbCommunicator extends ArduinoSerialUtility {
    public UsbCommunicator() {
    }

    public void initializeArduino() {
        openPort(Constants.PORT_NAME, Constants.BAUDRATE);
        initializeReader();
    }

    public void closeConnection() {
        closePort();
    }

    public void setObserver(Observer observer) {
        addObserver(observer);
    }
}


