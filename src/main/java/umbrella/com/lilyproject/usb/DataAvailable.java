package umbrella.com.lilyproject.usb;

public class DataAvailable {
	private volatile boolean flag;

	public DataAvailable() {
	        flag = false;
	    }

	public void setFlag(boolean value) {
		flag = value;
		if (flag) {
			// If the flag is true, trigger the event in a new thread
			new Thread(this::onFlagTrue).start();
		}
	}

	public void onFlagTrue() {
		// Perform actions or trigger events when the flag becomes true
		System.out.println("Flag is now true!");
	}	
}
