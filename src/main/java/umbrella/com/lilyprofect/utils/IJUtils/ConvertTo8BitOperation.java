package umbrella.com.lilyprofect.utils.IJUtils;

import ij.ImagePlus;
import ij.process.ImageProcessor;

public class ConvertTo8BitOperation implements ImageJOperation<ImagePlus, ImagePlus> {
	@Override
	public ImagePlus apply(ImagePlus image) {
		ImageProcessor processor = image.getProcessor();
		if (image.getType() != ImagePlus.GRAY8) {
			ImageProcessor convertedProcessor = processor.convertToByte(true);
			image.setProcessor(convertedProcessor);
		}
		return image;
	}
}
