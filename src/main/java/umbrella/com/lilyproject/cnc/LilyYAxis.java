package umbrella.com.lilyproject.cnc;

public class LilyYAxis extends AbstractAxis {

	public LilyYAxis() {
		name = "Y";
		size = 400;
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
