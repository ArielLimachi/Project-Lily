package umbrella.com.lilyproject.utils;

import java.awt.GraphicsEnvironment;

public class UiUtils {
	public static String[] getFontList() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	}
}
