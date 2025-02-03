package umbrella.com.lilyproject.cnc.graphics;

public class CNCController {

    private PositionTracker positionTracker;
    private ArduinoMovementController arduinoMovementController;

    public CNCController(PositionTracker positionTracker, ArduinoMovementController arduinoMovementController) {
        this.positionTracker = positionTracker;
        this.arduinoMovementController = arduinoMovementController;
    }

    public void move(int deltaX, int deltaY) {
        // Send the movement command to Lily-Arduino
        String command = String.format("Move: deltaX=%d, deltaY=%d", deltaX, deltaY);
        arduinoMovementController.sendCommand(command);

        // Update the position tracker
        positionTracker.updatePosition(deltaX, deltaY);
    }

    public void reset() {
        // Send the reset command to Lily-Arduino
        arduinoMovementController.sendCommand("Reset");

        // Reset the position tracker
        positionTracker.reset();
    }
}
