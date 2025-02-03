package umbrella.com.lilyproject.cnc;

import java.util.HashMap;
import java.util.Map;

public class Axis extends AbstractAxis {

    Map<String,Integer> axisData;

    public Axis(String name, int size, MovementController movementController) {
        super(name, size, movementController);
        axisData = new HashMap<>();

        axisData.put("position", 0);
        axisData.put("direction", 0); // -1  0  1 convention for movement backwards, stop and forward
        axisData.put("velocity", 2100);
        axisData.put("acceleration", 1500);
        axisData.put("routine", 0);
    }

    @Override
    public void moveToStartPosition() {
        axisData.put("position", 0);
        axisData.put("direction", 0); // -1  0  1 convention for movement backwards, stop and forward
        axisData.put("velocity", 2100);
        axisData.put("acceleration", 1500);
        axisData.put("routine", 1);

        movementController.move(axisData);
        axisData.put("routine", 0);
        setCurrentPosition(0);
    }

    @Override
    public void moveToFinalPosition() {
        setCurrentPosition(this.size);
        movementController.move(this.size);
    }

    @Override
    public void moveToPosition(int position) {
        //Compare Positions
        int currentPosition = getCurrentPosition();
        int deltaPosition = Math.abs(currentPosition - position);

        //axisData.put("position", deltaPosition);
        axisData.put("position", position);
        axisData.put("direction", 0); // -1  0  1 convention for movement backwards, stop and forward
        axisData.put("velocity", 2100);
        axisData.put("acceleration", 1500);

        if (position > currentPosition) { // move forward
            axisData.put("direction", 1);
        }
        if (position < currentPosition) { // move backwards
            axisData.put("direction", -1);
        }

        movementController.move(axisData);
        setCurrentPosition(position);
    }
}

