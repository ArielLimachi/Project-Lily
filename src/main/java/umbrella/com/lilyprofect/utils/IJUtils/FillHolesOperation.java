package umbrella.com.lilyprofect.utils.IJUtils;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

public class FillHolesOperation implements ImageJOperation<ImagePlus, ImagePlus> {

    @Override
    public ImagePlus apply(ImagePlus image) {
        ImageProcessor processor = image.getProcessor();
        
        // Ensure the image is binary
        if (!processor.isBinary()) {
            IJ.run(image, "Make Binary", "");
        }
        
        // Apply the "Fill Holes" operation
        IJ.run(image, "Fill Holes", "");
        
        return image;
    }
}
