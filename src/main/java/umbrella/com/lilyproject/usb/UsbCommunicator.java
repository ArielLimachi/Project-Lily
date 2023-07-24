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

	/*
	 * @Override public void sendData(String data) { comm.sendData(data); }
	 * 
	 * @Override public void openPort() { comm.openPort(Constants.PORT_NAME,
	 * Constants.BAUDRATE); comm.initializeReader(); }
	 * 
	 * @Override public void closePort() { comm.closePort(); }
	 * 
	 * @Override public String getData() { return comm.getReceivedData(); }
	 */
}
