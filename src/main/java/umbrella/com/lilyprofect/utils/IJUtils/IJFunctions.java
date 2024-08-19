package umbrella.com.lilyprofect.utils.IJUtils;

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

		ijFunctions = new HashMap<>();

		addFunction("skeletonize", new SkeletonizeOperation());
		addFunction("gaussianBlur", new GaussianBlurOperation());
	}

	public void addFunction(String name, Function<ImagePlus, ImagePlus> function) {
		ijFunctions.put(name, function);
	}

	public Function<ImagePlus, ImagePlus> getFunction(String name) {
		return ijFunctions.get(name);
	}

	public List<String> getFunctionNames() {
		return new ArrayList<>(ijFunctions.keySet());
	}

	public Map<String, Function> getFunctions() {
		return ijFunctions;
	}
}
