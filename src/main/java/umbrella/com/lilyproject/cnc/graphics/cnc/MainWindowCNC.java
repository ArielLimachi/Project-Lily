package umbrella.com.lilyproject.cnc.graphics.cnc;

import umbrella.com.lilyproject.cnc.MovementController;
import umbrella.com.lilyproject.cnc.graphics.DebugPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindowCNC extends JFrame {

    private MovementController controller;

    private DebugPanel debugPanel;

    private Container container;

    public MainWindowCNC() {
        setTitle("Lily-PC CNC Simulator");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        debugPanel = new DebugPanel();
        
        controller = new DirectionalController(new Dimension(440, 170));
        //controller = new LilyCncController(new Dimension(440, 170));
        
        container = getContentPane();

        container.add((Component) controller);
        container.add(debugPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindowCNC();
    }

}


