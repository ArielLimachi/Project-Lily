package umbrella.com.lilyprofect.utils.IJUtils;

import ij.ImagePlus;
import ij.process.ImageProcessor;

public class ConvertToBinaryOperation implements ImageJOperation<ImagePlus, ImagePlus>{

	@Override
	public ImagePlus apply(ImagePlus image) {
		ImageProcessor processor = image.getProcessor();
        if (!processor.isBinary()) {
            // Convert to binary using a threshold. 
            // You can also use a specific threshold value or method.
            processor.setThreshold(128, 255, ImageProcessor.NO_LUT_UPDATE);
            processor.convertToByte(true);
            processor.autoThreshold();
        }
        return image;
	}

}
