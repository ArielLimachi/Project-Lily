package umbrella.com.lilyprofect.utils.IJUtils;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

public class EdgeDetectionOperation implements ImageJOperation<ImagePlus, ImagePlus> {
	public ImagePlus apply(ImagePlus image) {
        ImageProcessor processor = image.getProcessor();
        IJ.run(image, "Find Edges", "");        
        return image;
    }	
}