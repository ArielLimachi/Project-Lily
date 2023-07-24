package umbrella.com.lilyproject.usb;

import java.util.Observable;
import java.util.Observer;

public class CustomUsbDataObservable extends Observable{
	private boolean flag;

	public void setFlag(boolean value) {
		if (flag != value) {
			flag = value;
			if (flag) {
				setChanged();
				notifyObservers();
			}
		}
	}
}
