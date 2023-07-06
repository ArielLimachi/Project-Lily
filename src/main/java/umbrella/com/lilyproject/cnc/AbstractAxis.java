package umbrella.com.lilyproject.cnc;

public abstract class AbstractAxis implements IsMovable{

	protected String name;
	protected int size;
	protected int currentPosition;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
}
