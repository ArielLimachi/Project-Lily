package umbrella.com.lilyproject.cnc;

public class LilyXAxis extends AbstractAxis {

	public LilyXAxis() {
		name = "X";
		size = 800;
		currentPosition = 50;
	}

	@Override
	public void move(int distance) {
		currentPosition = +distance;
	}

	@Override
	public void stop() {

	}

}
