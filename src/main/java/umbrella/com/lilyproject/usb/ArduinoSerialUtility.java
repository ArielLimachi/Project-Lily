package umbrella.com.lilyproject.usb;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.fazecast.jSerialComm.*;

public class ArduinoSerialUtility extends Observable{

	protected SerialPort arduinoPort;
	protected List<Character> receivedDataBuffer = new ArrayList<>();
	
	String receivedData;

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

	public void initializeReader() {
		arduinoPort.addDataListener(new SerialPortDataListener() {

			@Override
			public void serialEvent(SerialPortEvent event) {
				if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
					byte[] newData = new byte[arduinoPort.bytesAvailable()];
					arduinoPort.readBytes(newData, newData.length);

					for (byte b : newData) {
						char receivedChar = (char) b;
						if (receivedChar == '\n') {
							processReceivedData();
						} else {
							receivedDataBuffer.add(receivedChar);
						}
					}
				}
			}

			@Override
			public int getListeningEvents() {
				return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
			}
		});
	}

	private void processReceivedData() {
		StringBuilder receivedDataBuilder = new StringBuilder();
		for (Character c : receivedDataBuffer) {
			receivedDataBuilder.append(c);
		}
		receivedDataBuffer.clear();

		receivedData = receivedDataBuilder.toString().trim();
		System.out.println("Received from Arduino: " + receivedData);
		
		setChanged();
        notifyObservers();
	}
	
	public String getReceivedData() {
		return receivedData;
	}

	public boolean sendData(String data) {
		if (arduinoPort == null || !arduinoPort.isOpen()) {
			return false;
		}
		return arduinoPort.writeBytes((data + "\n").getBytes(), data.length() + 1) > 0;
	}			
}
