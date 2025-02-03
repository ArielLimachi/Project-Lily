package umbrella.com.lilyproject.cnc.graphics;

import umbrella.com.lilyproject.usb.UsbCommunicator;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class ArduinoMovementController {

    private UsbCommunicator usbCommunicator;
    private DebugPanel debugPanel;

    public ArduinoMovementController(DebugPanel debugPanel) {
        this.debugPanel = debugPanel;
        usbCommunicator = new UsbCommunicator();
        if (!usbCommunicator.initializeArduino()) {
            debugPanel.log("Error: Failed to initialize Arduino connection");
        }
        usbCommunicator.setObserver(new ArduinoResponseListener());
    }

    public void sendCommand(String command) {
        if (usbCommunicator == null || !usbCommunicator.portIsOpen()) {
            debugPanel.log("Error: Arduino is not connected");
            return;
        }

        // Validate the command
        if (command == null || command.isEmpty()) {
            debugPanel.log("Error: Invalid command");
            return;
        }

        // Send the command to Lily-Arduino
        boolean success = usbCommunicator.sendData(command);
        if (success) {
            debugPanel.log("Sent: " + command);
        } else {
            debugPanel.log("Error: Failed to send command - " + command);
        }
    }

    public void move(Map<String, Integer> data) {
        // Validate the movement data
        if (data == null || !data.containsKey("position") || !data.containsKey("direction") ||
                !data.containsKey("velocity") || !data.containsKey("acceleration")) {
            debugPanel.log("Error: Invalid movement data");
            return;
        }

        // Format the movement command
        String command = String.format("Move: position=%d, direction=%d, velocity=%d, acceleration=%d",
                data.get("position"), data.get("direction"), data.get("velocity"), data.get("acceleration"));
        sendCommand(command);
    }

    private class ArduinoResponseListener implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            // Process the response from Lily-Arduino
            String response = usbCommunicator.getReceivedData();
            debugPanel.log("Received: " + response);

            // Handle specific responses (e.g., confirmation, errors)
            if (response.contains("OK")) {
                debugPanel.log("Command executed successfully");
            } else if (response.contains("ERROR")) {
                debugPanel.log("Error: " + response);
            }
        }
    }
}
