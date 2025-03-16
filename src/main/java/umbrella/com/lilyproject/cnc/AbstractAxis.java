package umbrella.com.lilyproject.cnc;

public abstract class AbstractAxis {

    protected String name;
    protected int size;
    protected int currentPosition;
    protected int velocity;
    protected int acceleration;
    protected boolean atFinalPosition;
    protected boolean atStartPosition;

    protected MovementController movementController;

    // Constructor
    public AbstractAxis(String name, int size, MovementController movementController) {
        this.name = name;
        this.size = size;
        this.movementController = movementController;
        this.currentPosition = 0;
        this.atFinalPosition = false;
        this.atStartPosition = true;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public boolean isAtFinalPosition() {
        return atFinalPosition;
    }

    public boolean isAtStartPosition() {
        return atStartPosition;
    }

    // Setters with validation
    public void setCurrentPosition(int currentPosition) {
        if (currentPosition >= 0 && currentPosition <= size) {
            this.currentPosition = currentPosition;
            this.atStartPosition = currentPosition == 0;
            this.atFinalPosition = currentPosition == size;
        } else {
            throw new IllegalArgumentException("Position must be within the range of 0 to " + size);
        }
    }

    public void setVelocity(int velocity){
        this.velocity = velocity;
    }

    public void setAcceleration(int acceleration){
        this.acceleration = acceleration;
    }

    // Abstract methods to be implemented by subclasses
    public abstract void moveToStartPosition() throws InterruptedException;

    public abstract void moveToFinalPosition() throws InterruptedException;

    public abstract void moveToPosition(int position) throws InterruptedException;
}

