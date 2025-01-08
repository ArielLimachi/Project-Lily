package umbrella.com.lilyproject.usb;

import java.beans.PropertyChangeListener;

import umbrella.com.lilyprofect.utils.Constants;

public class UsbCommunicator {

	private final ArduinoSerialUtility arduinoSerialUtility;

	public UsbCommunicator() {
		this.arduinoSerialUtility = new ArduinoSerialUtility();
	}

	public void initializeArduino() {
		boolean opened = arduinoSerialUtility.openPort(Constants.PORT_NAME, Constants.BAUDRATE);
		arduinoSerialUtility.initializeReader();
	}

	public void closeConnection() {
		arduinoSerialUtility.closePort();
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		arduinoSerialUtility.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		arduinoSerialUtility.removePropertyChangeListener(listener);
	}

	public String getReceivedData() {
		return arduinoSerialUtility.getReceivedData();
	}

	public void sendData(String data) {
		arduinoSerialUtility.sendData(data);
	}
}

