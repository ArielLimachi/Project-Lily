package umbrella.com.lilyproject;

import java.util.Observable;
import java.util.Observer;

import umbrella.com.lilyproject.testers.UsbTester;
import umbrella.com.lilyproject.ui.TrashFrame;
import umbrella.com.lilyproject.usb.ArduinoSerialUtility;
import umbrella.com.lilyproject.usb.CustomUsbDataObservable;
import umbrella.com.lilyproject.usb.UsbCommunicator;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// System.out.println("Hello World!");

		// TrashFrame frame = new TrashFrame();

		/*
		ArduinoSerialUtility serialUtility = new ArduinoSerialUtility();

		// Replace "COM3" with the correct port name for your Arduino
		String portName = "COM4";
		int baudRate = 9600;

		// Open the port
		if (serialUtility.openPort(portName, baudRate)) {
			System.out.println("Port opened successfully.");

			// Read and print data from Arduino
			for (int i = 0; i < 5; i++) {
				String receivedData = serialUtility.readData();
				if (receivedData != null) {
					System.out.println("Received data: " + receivedData);
				} else {
					System.err.println("Failed to read data.");
				}

				try {
					Thread.sleep(2000); // Wait for 2 seconds before reading the next data packet
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// Close the port
			if (serialUtility.closePort()) {
				System.out.println("Port closed.");
			} else {
				System.err.println("Failed to close the port.");
			}
		} else {
			System.err.println("Failed to open the port.");
		}
		*/
		
		/*
		UsbCommunicator comm = new UsbCommunicator();
		comm.openPort();
		comm.sendData("hola");
		comm.receiveData();
		comm.closePort();
		*/
		
		UsbTester usbTestFrame = new UsbTester();
		
		/*
		CustomUsbDataObservable usbObservable = new CustomUsbDataObservable();
		
		Observer observer = new Observer() {
			
			@Override
			public void update(Observable o, Object arg) {
				System.out.println("Flag is now true! Eventito!!");
			}
		};
		
		usbObservable.addObserver(observer);
		
		usbObservable.setFlag(true);
		*/
	}
}
