package umbrella.com.lilyproject.cnc.graphics;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private WorkspacePanel workspacePanel;
    private DebugPanel debugPanel;
    private JButton leftButton, rightButton, upButton, downButton, stopButton, resetButton;

    private CNCController cncController;
    private PositionTracker positionTracker;

    public MainWindow() {
        setTitle("Lily-PC CNC Simulator");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize components
        positionTracker = new PositionTracker();
        debugPanel = new DebugPanel();
        ArduinoMovementController arduinoMovementController = new ArduinoMovementController(debugPanel);
        cncController = new CNCController(positionTracker, arduinoMovementController);

        workspacePanel = new WorkspacePanel();
        initializeButtons();

        // Add components to the window
        add(workspacePanel, BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
        add(debugPanel, BorderLayout.EAST);

        setVisible(true);
    }

    private void initializeButtons() {
        leftButton = new JButton("Left");
        rightButton = new JButton("Right");
        upButton = new JButton("Up");
        downButton = new JButton("Down");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        // Add action listeners to the buttons
        leftButton.addActionListener(new MovementButtonListener(-10, 0)); // Move left by 10mm
        rightButton.addActionListener(new MovementButtonListener(10, 0)); // Move right by 10mm
        upButton.addActionListener(new MovementButtonListener(0, 10)); // Move up by 10mm
        downButton.addActionListener(new MovementButtonListener(0, -10)); // Move down by 10mm
        resetButton.addActionListener(e -> {
            cncController.reset();
            workspacePanel.reset();
            debugPanel.log("Reset: Load position reset to (0, 0)");
        });
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);
        buttonPanel.add(upButton);
        buttonPanel.add(downButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        return buttonPanel;
    }

    private class MovementButtonListener implements ActionListener {
        private int deltaX;
        private int deltaY;

        public MovementButtonListener(int deltaX, int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button pressed: " + e.getActionCommand()); // Debug log
            cncController.move(deltaX, deltaY);
            String command = String.format("Move: deltaX=%d, deltaY=%d", deltaX, deltaY);
            debugPanel.log("Sent: " + command);
            workspacePanel.updateLoadPosition(
                    positionTracker.getCurrentX(),
                    positionTracker.getCurrentY()
            );
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}