package umbrella.com.lilyprofect.utils.IJUtils;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

public class SkeletonizeOperation implements ImageJOperation<ImagePlus, ImagePlus> {

	@Override
	public ImagePlus apply(ImagePlus image) {
		ImageProcessor processor = image.getProcessor();

		// Ensure the image is binary
		if (!processor.isBinary()) {
			//IJ.run(image, "Make Binary", "");
		}

		// Optional: Invert the image if necessary (depends on the nature of the objects
		// in the image)
		//IJ.run(image, "Invert", "");

		// Apply skeletonization
		IJ.run(image, "Skeletonize", "");

		return image;
	}

}
