package umbrella.com.lilyproject;

import java.util.Observable;
import java.util.Observer;

import umbrella.com.lilyprofect.utils.SwingUtils;
import umbrella.com.lilyproject.testers.UsbTester;
import umbrella.com.lilyproject.ui.GenericPanel;
import umbrella.com.lilyproject.ui.TrashFrame;
import umbrella.com.lilyproject.usb.ArduinoSerialUtility;
import umbrella.com.lilyproject.usb.CustomUsbDataObservable;
import umbrella.com.lilyproject.usb.UsbCommunicator;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.GaussianBlur;
import ij.process.ImageProcessor;

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
		
		//UsbTester usbTestFrame = new UsbTester(); //23 july this was commented
		
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
		
		//TrashFrame tf = new TrashFrame();
		//tf.setVisible(true);		
		
		// Open an image file
        ImagePlus image = IJ.openImage("elipse.jpg");
        
        if (image == null) {
            System.out.println("Could not open the image file.");
            return;
        }

        // Display the original image
        image.show();

        // Get the image processor
        ImageProcessor processor = image.getProcessor();

        // Apply Gaussian blur with sigma = 2.0
        GaussianBlur blur = new GaussianBlur();
        blur.blurGaussian(processor, 2.0, 2.0, 0.02);

        // Update the image with the processed data
        //image.updateAndDraw();

        // Display the processed image
        //image.show();
	}
}
