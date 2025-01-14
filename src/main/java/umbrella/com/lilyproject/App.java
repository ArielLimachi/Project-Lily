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


public class App {
    public static void main(String[] args) {

        //UsbTester usb = new UsbTester();
        //usb.setVisible(true);
/*
        MovementController controller = new ArduinoMovementController();

        Axis x = new Axis("Eje X", 1500, controller);

        x.setCurrentPosition(100);

        x.moveToStartPosition();

        x.moveToPosition(1400);

        x.moveToFinalPosition();
*/

        JFrame frame = new JFrame("Cartesian Plane");
        CncTester panel = new CncTester();
        frame.add(panel);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

            /*
		// Open an image file
        ImagePlus image = IJ.openImage("elipse.jpg");
        
        if (image == null) {
            System.out.println("Could not open the image file.");
            return;
        }

        // Display the original image
        //image.show();

        // Get the image processor
        ImageProcessor processor = image.getProcessor();

        // Apply Gaussian blur with sigma = 2.0
        GaussianBlur blur = new GaussianBlur();
        blur.blurGaussian(processor, 2.0, 2.0, 0.02);

        // Update the image with the processed data
        //image.updateAndDraw();

        // Display the processed image
        //image.show();
        
        ImagePlus imagePlus = IJ.openImage("uno_jpg.jpg");
        ImageProcessingMainFrame ij = new ImageProcessingMainFrame(imagePlus);
        ij.setVisible(true);

             */
    }
}
