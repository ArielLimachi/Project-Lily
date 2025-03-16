package umbrella.com.lilyproject.cnc;

import umbrella.com.lilyprofect.utils.ArduinoUtils;
import umbrella.com.lilyprofect.utils.Constants;
import umbrella.com.lilyprofect.utils.SwingUtils;
import umbrella.com.lilyproject.usb.UsbCommunicator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ObjectPositionSimulator extends JPanel implements ActionListener {
    private int x = 50; // Initial position of the point
    private int y = 100;
    private final ArrayList<Point> points = new ArrayList<>(); // List to store point positions

    private int lineSize;
    private int step;

    private Axis axis;


    JButton forwardButton;
    JButton backwardButton;
    JButton stopButton;

    JButton goToPosition;
    JTextField position;

    public ObjectPositionSimulator(int size) {

        initializeAxis();

        this.lineSize = size;
        this.step = (int) size / 700;

        points.add(new Point(x, y)); // Add initial point position

        forwardButton = SwingUtils.getButton("->", this);
        backwardButton = SwingUtils.getButton("<-", this);
        stopButton = SwingUtils.getButton("||", this);

        goToPosition = SwingUtils.getButton("Go", this);
        position = SwingUtils.getTextField("1500");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backwardButton);
        buttonPanel.add(forwardButton);
        buttonPanel.add(stopButton);

        buttonPanel.add(goToPosition);
        buttonPanel.add(position);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void initializeAxis() {
        MovementController controller = new ArduinoMovementController();
        axis = new Axis("Eje X", 2000, controller);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the initial trajectory line
        g.drawLine(50, y, 750, y); // Draw a line across the panel for initial trajectory

        // Draw the moving trajectory line
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        // Draw the current point
        g.fillOval(x - 5, y - 5, 10, 10);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Object Position Simulator");
        ObjectPositionSimulator simulator = new ObjectPositionSimulator(2000);

        frame.add(simulator);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == forwardButton) {
            x += step;
            points.add(new Point(x, y));
            //axis.moveToPosition(step);
            repaint();
        }
        if (e.getSource() == backwardButton) {
            x -= step;
            points.add(new Point(x, y));
            //axis.moveToPosition(step);
            repaint();
        }
        if (e.getSource() == stopButton) {
            //axis.moveToStartPosition();
        }
        if (e.getSource() == goToPosition) {
            int position = Integer.parseInt(this.position.getText());
            //axis.moveToPosition(position);
        }
    }
}

