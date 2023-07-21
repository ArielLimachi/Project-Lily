package umbrella.com.lilyproject.usb;

import com.fazecast.jSerialComm.*;

public class ArduinoSerialUtility {

	private SerialPort arduinoPort;

	public ArduinoSerialUtility() {
		arduinoPort = null;
	}

	public boolean openPort(String portName, int baudRate) {
		arduinoPort = SerialPort.getCommPort(portName);
		arduinoPort.setComPortParameters(baudRate, 8, 1, 0);
		return arduinoPort.openPort();
	}

	public boolean closePort() {
		if (arduinoPort != null && arduinoPort.isOpen()) {
			return arduinoPort.closePort();
		}
		return false;
	}

	public String readData() {
		if (arduinoPort == null || !arduinoPort.isOpen()) {
			return null;
		}
		StringBuilder dataBuffer = new StringBuilder();
		byte[] buffer = new byte[1024];
		int numBytes;

		try {
			while ((numBytes = arduinoPort.readBytes(buffer, buffer.length)) > 0) {
				String receivedData = new String(buffer, 0, numBytes);
				dataBuffer.append(receivedData);

				// Check if the received data contains the delimiter '\n'
				int delimiterIndex = dataBuffer.indexOf("\n");
				if (delimiterIndex >= 0) {
					String dataPacket = dataBuffer.substring(0, delimiterIndex);
					dataBuffer.delete(0, delimiterIndex + 1); // Remove the processed data from the buffer
					return dataPacket;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean sendData(String data) {
		if (arduinoPort == null || !arduinoPort.isOpen()) {
			return false;
		}
		return arduinoPort.writeBytes((data + "\n").getBytes(), data.length() + 1) > 0;
	}
}
