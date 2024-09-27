package umbrella.com.lilyprofect.utils.IJUtils;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

public class ConvertToMaskOperation implements ImageJOperation<ImagePlus, ImagePlus> {
	@Override
	public ImagePlus apply(ImagePlus image) {
		ImageProcessor processor = image.getProcessor();
		if (!processor.isBinary()) {
			IJ.run(image, "Convert to Mask", "");
		}
		return image;
	}
}
