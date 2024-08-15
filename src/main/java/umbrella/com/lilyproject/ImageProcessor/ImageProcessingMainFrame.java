package umbrella.com.lilyproject.ImageProcessor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ij.IJ;
import ij.ImagePlus;
import umbrella.com.lilyprofect.utils.IJFunctions;
import umbrella.com.lilyprofect.utils.SwingUtils;
import umbrella.com.lilyproject.ui.graphicComponents.GridComponent;

public class ImageProcessingMainFrame extends JFrame {

	private JLabel title;
	private List<JButton> processButtons;

	private IJFunctions functions;

	private ImagePlus imagePlus;
	
	CardHandler<CustomImage> imageSet;

	public ImageProcessingMainFrame(ImagePlus imagePlus) {
		//setLayout(null);
		setSize(1200, 800);
		setLocation(300, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		functions = new IJFunctions();
		this.imagePlus = imagePlus;

		initializeComponents();

		setVisible(true);
	}

	private void initializeComponents() {
		buildHeader();
		buildImageHandler();
		buildButtonFunctionsGrid();
	}
	
	private void buildImageHandler() {
		initializeImageSet();
	}
	
	private void initializeImageSet() {
		imageSet = new CardHandler<CustomImage>();
		imageSet.addCard(new CustomImage(imagePlus), 0);
		add(imageSet);
	}
	
	private void setImage(CustomImage image) {
		imageSet.addCard(image, imageSet.getCardSetSize());
		imageSet.next();
	}
	
	private ImagePlus getCurrentImage() {
		return imageSet.getCurrentCard().getImagePlus();
	}
	
	private void buildHeader() {
		title = SwingUtils.getLabel("Image Processing", 0, 0, 100, 40);
		add(title, BorderLayout.NORTH);
	}
	
	private void buildButtonFunctionsGrid() {
		processButtons = new ArrayList<JButton>();
		Map<String, Function> functions = this.functions.getFunctions();

		for (Map.Entry<String, Function> entry : functions.entrySet()) {

			JButton button = new JButton((String) entry.getKey());

			Function<ImagePlus, ImagePlus> function = (Function<ImagePlus, ImagePlus>) entry.getValue();
			button.addActionListener(e -> {
				ImagePlus newImage = function.apply(getCurrentImage());
				setImage(new CustomImage(newImage));
			});
			processButtons.add(button);

		}
		JPanel buttonsGridPanel = SwingUtils.getButtonInGridPanel(processButtons);
		
		add(buttonsGridPanel, BorderLayout.WEST);
	}
}
