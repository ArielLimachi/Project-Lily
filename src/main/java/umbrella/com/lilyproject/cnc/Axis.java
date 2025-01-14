package umbrella.com.lilyproject.cnc;

public class Axis extends AbstractAxis {
    public Axis(String name, int size, MovementController movementController) {
        super(name, size, movementController);
    }

    @Override
    public void moveToStartPosition() {
        setCurrentPosition(0);
        movementController.move(0);
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

        if (position > currentPosition) { // move forward
            movementController.move(deltaPosition);
        }
        if (position < currentPosition) { // move backwards
            movementController.move(-deltaPosition);
        }
        setCurrentPosition(position);
    }

    public void setAcceleration(int acceleration) {
        movementController.setParameter("acceleration", acceleration);
        setAcceleration(acceleration);
    }

    public void setVelocity(int velocity){
        movementController.setParameter("velocity", velocity);
        setVelocity(velocity);
    }
}

