package umbrella.com.lilyproject.cnc.graphics;

import umbrella.com.lilyprofect.utils.IJUtils.GraphicConstants;

import javax.swing.*;
import java.awt.*;

public class DebugPanel extends JPanel {

    private JTextArea debugTextArea;

    public DebugPanel() {
        setBackground(GraphicConstants.DEBUG_BACKGROUND_COLOR);
        setPreferredSize(new Dimension(400, GraphicConstants.WORKSPACE_HEIGHT));
        setLayout(new BorderLayout());

        debugTextArea = new JTextArea();
        debugTextArea.setFont(GraphicConstants.DEBUG_FONT);
        debugTextArea.setForeground(GraphicConstants.DEBUG_TEXT_COLOR);
        debugTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(debugTextArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void log(String message) {
        debugTextArea.append(message + "\n");
        debugTextArea.setCaretPosition(debugTextArea.getDocument().getLength()); // Auto-scroll to the bottom
    }
}