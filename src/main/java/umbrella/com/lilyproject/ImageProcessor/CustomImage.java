package umbrella.com.lilyproject.ImageProcessor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import ij.ImagePlus;
import umbrella.com.lilyprofect.utils.Constants;
import umbrella.com.lilyprofect.utils.SwingUtils;

public class CustomImage extends JPanel {

	private ImagePlus imagePlus;
	private BufferedImage image;
	private Dimension dimension;

	public CustomImage(ImagePlus imagePlus) {
		this.imagePlus = imagePlus;
		this.image = getResizedImagePlus();
		this.dimension = new Dimension(image.getWidth(), image.getHeight());
		setSize(dimension);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, null);
		}
	}

	private BufferedImage getResizedImagePlus() {
		ImagePlus resizedImagePlus = SwingUtils.resizeImage(imagePlus, Constants.REESCALE_FACTOR);
		return SwingUtils.getBufferedImage(resizedImagePlus);
	}
	
	public ImagePlus getImagePlus() {
		return imagePlus;
	}
}
