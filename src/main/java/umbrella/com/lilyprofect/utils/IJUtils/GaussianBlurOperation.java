package umbrella.com.lilyprofect.utils.IJUtils;

import ij.ImagePlus;
import ij.plugin.filter.GaussianBlur;
import ij.process.ImageProcessor;

public class GaussianBlurOperation implements ImageJOperation<ImagePlus, ImagePlus>{	
    @Override
    public ImagePlus apply(ImagePlus image) {        
        ImageProcessor processor = image.getProcessor();
		GaussianBlur gaussianBlur = new GaussianBlur();
		gaussianBlur.blurGaussian(processor, 2.0, 2.0, 0.02);
		return image;
    }
}
