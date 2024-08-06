package umbrella.com.lilyprofect.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.GaussianBlur;
import ij.process.ImageProcessor;

public class IJFunctions {

	private Map<String, Function> ijFunctions;

	public IJFunctions() {

		ijFunctions = new HashMap<String, Function>();

		Function<ImagePlus, ImagePlus> skeletonize = new Function<ImagePlus, ImagePlus>() {
			@Override
			public ImagePlus apply(ImagePlus image) {
				ImageProcessor processor = image.getProcessor();
				if (processor.isBinary()) {
					IJ.run("Make Binary", "");
				}
				IJ.run(image, "Skeletonize", "");
				return image;
			}
		};

		Function<ImagePlus, ImagePlus> gaussianBlur = new Function<ImagePlus, ImagePlus>() {
			@Override
			public ImagePlus apply(ImagePlus image) {
				ImageProcessor processor = image.getProcessor();
				GaussianBlur gaussianBlur = new GaussianBlur();
				gaussianBlur.blurGaussian(processor, 2.0, 2.0, 0.02);
				return image;
			}
		};

		ijFunctions.put("skeletonize", skeletonize);
		ijFunctions.put("gaussian blur", gaussianBlur);
	}

	public Map getFunctions() {
		return ijFunctions;
	}

	public List<String> getIJFunctionNames() {
		List<String> ijFunctionsNames = new ArrayList<String>();
		for (Map.Entry<String, Function> entry : ijFunctions.entrySet()) {
			ijFunctionsNames.add(entry.getKey());
        }		
		
		return ijFunctionsNames;
	}
	
	public List<Function> getIJFunctions() {
		List<Function> ijFunctions = new ArrayList<Function>();
		for (Map.Entry<String, Function> entry : this.ijFunctions.entrySet()) {
			ijFunctions.add(entry.getValue());
        }		
		
		return ijFunctions;
	}
}
