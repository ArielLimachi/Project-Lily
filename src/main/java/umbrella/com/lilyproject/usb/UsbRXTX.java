package umbrella.com.lilyproject.usb;

public interface UsbRXTX {
	
	void openPort();
	
	void closePort();
	
	void sendData(String data) ;
}
