package umbrella.com.lilyproject.cnc.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CncTester extends JPanel implements ActionListener {

    private JButton button1, button2, button3;
    private CartesianPlane cartesianPlane;

    // Constructor
    public CncTester() {
        setLayout(null);  // Use absolute layout for custom positioning

        // Initialize the Cartesian plane panel with transparency level
        cartesianPlane = new CartesianPlane(0.5f, 0.2f,10, 10);
        cartesianPlane.setBounds(50, 150, 600, 600);

        // Create buttons
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button3 = new JButton("Button 3");

        // Set button positions and sizes
        button1.setBounds(10, 10, 100, 30);
        button2.setBounds(10, 50, 100, 30);
        button3.setBounds(10, 90, 100, 30);

        // Add buttons and Cartesian plane panel to the main panel
        add(button1);
        add(button2);
        add(button3);
        add(cartesianPlane);

        // Register buttons with action listener
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions
        if (e.getSource() == button1) {
            System.out.println("Button 1 clicked");
            remove(cartesianPlane);
            cartesianPlane.setPoint(200,200);
            add(cartesianPlane);
            repaint();
        } else if (e.getSource() == button2) {
            System.out.println("Button 2 clicked");
        } else if (e.getSource() == button3) {
            System.out.println("Button 3 clicked");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cartesian Plane");
        CncTester panel = new CncTester();
        frame.add(panel);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
