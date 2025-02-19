package umbrella.com.lilyproject.ImageProcessor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;

import javax.swing.*;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.Coordinates;
import ij.plugin.XYCoordinates;
import umbrella.com.lilyprofect.utils.SwingUtils;
import umbrella.com.lilyprofect.utils.IJUtils.IJFunctions;
import umbrella.com.lilyproject.cnc.graphics.DebugPanel;

public class ImageProcessingMainFrame extends JFrame implements ActionListener {

    private JLabel title;
    private List<JButton> processButtons;
    private JButton previous, restore, set;

    private IJFunctions functions;

    private final ImagePlus baseImage;
    private CustomImage finalImage;

    CardHandler<CustomImage> imageSet;

    private DebugPanel debugger;

    public ImageProcessingMainFrame(ImagePlus imagePlus) {
        //setLayout(null);
        setSize(SwingUtils.getScreenDimension().width - 100, SwingUtils.getScreenDimension().height - 100);
        setLocation(10, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        functions = new IJFunctions();
        this.baseImage = imagePlus;

        initializeComponents();

        setVisible(true);
    }

    private void initializeComponents() {
        buildHeader(); // north
        buildImageHandler(); // center
        buildButtonFunctionsGrid(); // west
        buildControlButtons(); // east
        buildDebbuger(); //south
    }

    private void buildDebbuger() {
        debugger = new DebugPanel();
        add(debugger, BorderLayout.SOUTH);
    }

    private void buildControlButtons() {
        previous = SwingUtils.getButton("Previous", this);
        restore = SwingUtils.getButton("Restore", this);
        set = SwingUtils.getButton("Set", this);

        List<JButton> controlButtons = new ArrayList<>();
        controlButtons.add(previous);
        controlButtons.add(restore);
        controlButtons.add(set);

        JPanel buttonsGridPanel = SwingUtils.getButtonInGridPanel(controlButtons);
        add(buttonsGridPanel, BorderLayout.EAST);
    }

    private void buildImageHandler() {
        initializeImageSet();
    }

    private void initializeImageSet() {
        imageSet = new CardHandler<CustomImage>();
        imageSet.addCard(new CustomImage(baseImage), 0);
        add(imageSet, BorderLayout.CENTER);
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
                debugger.log("-> " + button.getText() + " applied.");
            });


            processButtons.add(button);

        }
        JPanel buttonsGridPanel = SwingUtils.getButtonInGridPanel(processButtons);

        add(buttonsGridPanel, BorderLayout.WEST);
    }

    public static void main(String[] args) {
        ImagePlus imagePlus = IJ.openImage("cuatro.png");
        ImageProcessingMainFrame ij = new ImageProcessingMainFrame(imagePlus);
        ij.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (previous.equals(obj)) {
            if (imageSet.getCardSetSize() >= 1) {
                imageSet.remove(imageSet.getCardSetSize() - 1);
                imageSet.previous();
            }
        }

        if (restore.equals(obj)) {
            imageSet.first();
        }

        if (set.equals(obj)) {
            finalImage = imageSet.getCurrentCard();
            BufferedImage bi = finalImage.getImagePlus().getBufferedImage();
            int height = bi.getHeight();
            int width = bi.getWidth();

            List<CustomStroke> strokes = new ArrayList<>();

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (bi.getRGB(x, y) == -1) { // finds the first white value
                        // create a new stroke and add current point where the point is white
                        CustomStroke stroke = new CustomStroke();

                        Point whitePoint = new Point(x, y);
                        stroke = stroke.getStroke(whitePoint, bi);
                        strokes.add(stroke);
                    }
                }
            }
            int a = 0;
        }

        if (set.equals(restore)) {
            finalImage = imageSet.getCurrentCard();
            BufferedImage bi = finalImage.getImagePlus().getBufferedImage();
            int height = bi.getHeight();
            int width = bi.getWidth();

            List<CustomStroke> strokes = new ArrayList<>();
            boolean[][] visited = new boolean[width][height]; // Track visited pixels

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (bi.getRGB(x, y) == -1 && !visited[x][y]) { // Find unvisited white pixel
                        CustomStroke stroke = new CustomStroke();
                        Stack<Point> stack = new Stack<>();
                        stack.push(new Point(x, y));

                        while (!stack.isEmpty()) {
                            Point current = stack.pop();
                            int cx = (int) current.getX();
                            int cy = (int) current.getY();

                            if (cx >= 0 && cx < width && cy >= 0 && cy < height &&
                                    bi.getRGB(cx, cy) == -1 && !visited[cx][cy]) {
                                stroke.addPoint(current);
                                visited[cx][cy] = true;
                                bi.setRGB(cx, cy, -16777216); // Mark as processed

                                // Add neighbors to the stack
                                stack.push(new Point(cx + 1, cy));
                                stack.push(new Point(cx - 1, cy));
                                stack.push(new Point(cx, cy + 1));
                                stack.push(new Point(cx, cy - 1));
                            }
                        }

                        strokes.add(stroke);
                    }
                }
            }
            int a = 0;
        }

    }
}
