package umbrella.com.lilyproject.usb;

import java.util.Observer;

import umbrella.com.lilyprofect.utils.Constants;

public class UsbCommunicator extends ArduinoSerialUtility {
    public UsbCommunicator() {
    }

    public boolean initializeArduino() {
        boolean portIsOpened = openPort(Constants.PORT_NAME, Constants.BAUDRATE);
        initializeReader();
        return portIsOpened;
    }

    public void closeConnection() {
        closePort();
    }

    public void setObserver(Observer observer) {
        addObserver(observer);
    }
}


