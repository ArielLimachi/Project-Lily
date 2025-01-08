package umbrella.com.lilyproject;

import umbrella.com.lilyproject.ImageProcessor.ImageProcessingMainFrame;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.GaussianBlur;
import ij.process.ImageProcessor;
import umbrella.com.lilyproject.testers.UsbTester;
import umbrella.com.lilyproject.usb.UsbCommunicator;


public class App {
	public static void main(String[] args) {

       UsbTester usb = new UsbTester();
       usb.setVisible(true);


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
