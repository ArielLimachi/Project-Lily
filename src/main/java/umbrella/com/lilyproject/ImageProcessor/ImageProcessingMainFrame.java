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

public class ImageProcessingMainFrame extends JFrame implements ActionListener{

	private JLabel title;
	private JPanel image;	
	private List<JButton> processButtons;

	private IJFunctions functions;

	private ImagePlus imagePlus;

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
		title = SwingUtils.getLabel("Image Processing", 0, 0, 100, 40);
		image = SwingUtils.getImageInPanel(SwingUtils.getBufferedImage(this.imagePlus));
		
		
		processButtons = new ArrayList<JButton>();
		Map<String, Function> functions = this.functions.getFunctions();
		
		for (Map.Entry<String, Function> entry : functions.entrySet() ) {
			
			JButton button = new JButton((String) entry.getKey());
			
			Function<ImagePlus, ImagePlus> function = (Function<ImagePlus, ImagePlus>) entry.getValue();
			button.addActionListener(this);	
			processButtons.add(button);
			//add(button);
			
		}
		JPanel buttonsGridPanel = SwingUtils.getButtonInGridPanel(processButtons);
		
		add(title, BorderLayout.NORTH);
		add(image, BorderLayout.CENTER);
		add(buttonsGridPanel, BorderLayout.WEST);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object obj = event.getSource();
		
	}

}
