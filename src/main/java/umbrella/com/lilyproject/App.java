package umbrella.com.lilyproject;

import umbrella.com.lilyproject.ImageProcessor.ImageProcessingMainFrame;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.GaussianBlur;
import ij.process.ImageProcessor;
import umbrella.com.lilyproject.cnc.ArduinoMovementController;
import umbrella.com.lilyproject.cnc.Axis;
import umbrella.com.lilyproject.cnc.MovementController;
import umbrella.com.lilyproject.cnc.graphics.CncTester;
import umbrella.com.lilyproject.testers.UsbTester;
import umbrella.com.lilyproject.usb.UsbCommunicator;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;


public class App {
    public static void main(String[] args) {
        UsbCommunicator arduino = new UsbCommunicator();
        arduino.initializeArduino();

        Observer observer = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                String data = (arduino.getReceivedData() + "\n");
                System.out.println("wakita -> " + data);
            }
        };
        arduino.addObserver(observer);

        arduino.sendData("GOTOXY 500 500");
    }
}
