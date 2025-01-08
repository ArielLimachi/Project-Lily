package umbrella.com.lilyproject.usb;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.fazecast.jSerialComm.*;

public class ArduinoSerialUtility {

	private SerialPort arduinoPort;
	private final List<Character> receivedDataBuffer = new ArrayList<>();
	private final Lock bufferLock = new ReentrantLock();
	private String receivedData;
	private final PropertyChangeSupport support;

	public ArduinoSerialUtility() {
		arduinoPort = null;
		support = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}

	public boolean openPort(String portName, int baudRate) {
		arduinoPort = SerialPort.getCommPort(portName);
		arduinoPort.setComPortParameters(baudRate, 8, 1, 0);
		return arduinoPort.openPort();
	}

	public void closePort() {
		if (arduinoPort != null && arduinoPort.isOpen()) {
			arduinoPort.closePort();
		}
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
							bufferLock.lock();
							try {
								receivedDataBuffer.add(receivedChar);
							} finally {
								bufferLock.unlock();
							}
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
		bufferLock.lock();
		try {
			for (Character c : receivedDataBuffer) {
				receivedDataBuilder.append(c);
			}
			receivedDataBuffer.clear();
		} finally {
			bufferLock.unlock();
		}

		String oldReceivedData = receivedData;
		receivedData = receivedDataBuilder.toString().trim();

		support.firePropertyChange("receivedData", oldReceivedData, receivedData);
	}

	public String getReceivedData() {
		return receivedData;
	}

	public void sendData(String data) {
		if (arduinoPort == null || !arduinoPort.isOpen()) {
			return;
		}
		arduinoPort.writeBytes((data + "\n").getBytes(), data.length() + 1);
	}
}
