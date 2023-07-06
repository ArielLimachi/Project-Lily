package umbrella.com.lilyproject.cnc;

import java.awt.Point;
import java.util.List;

public abstract class CncMachine {

	protected Point position;

	protected List<AbstractAxis> axes;

	public abstract void turnOnMachine();

	public abstract void turnOffMachine();

	public abstract void gotoXY(Point position);

	public List<AbstractAxis> getAxes() {
		return axes;
	}

	public void setAxes(List<AbstractAxis> axes) {
		this.axes = axes;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
}
