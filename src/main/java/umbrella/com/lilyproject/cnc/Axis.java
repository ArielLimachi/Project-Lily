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
        setCurrentPosition(position);
        movementController.move(position);
    }
}
