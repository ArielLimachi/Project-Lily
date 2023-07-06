package umbrella.com.lilyproject.cnc;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class LilyCNC extends CncMachine implements IsMovable {
	
	LilyXAxis xAxis = new LilyXAxis();
	LilyYAxis yAxis = new LilyYAxis();

	public LilyCNC () {
		setPosition();
		axes = new ArrayList<AbstractAxis>();
		axes.add(xAxis);
		axes.add(yAxis);
	}

	private void setPosition() {
		position = new Point(xAxis.getCurrentPosition(), yAxis.getCurrentPosition());
	}

	@Override
	public void turnOnMachine() {
		// TODO Auto-generated method stub

	}

	@Override
	public void turnOffMachine() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gotoXY(Point position) {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(int distance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
