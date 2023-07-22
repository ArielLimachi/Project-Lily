package umbrella.com.lilyproject.usb;

import umbrella.com.lilyprofect.utils.Constants;

public class UsbCommunicator implements UsbRXTX {

	ArduinoSerialUtility comm;

	public UsbCommunicator() {
		comm = new ArduinoSerialUtility();
	}

	@Override
	public void sendData(String data) {
		comm.sendData(data);
	}	

	@Override
	public void openPort() {
		comm.openPort(Constants.PORT_NAME, Constants.BAUDRATE);
		comm.initializeReader();
	}

	@Override
	public void closePort() {
		comm.closePort();
	}
}
