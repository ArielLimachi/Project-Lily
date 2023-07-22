package umbrella.com.lilyproject.testers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import umbrella.com.lilyprofect.utils.SwingUtils;
import umbrella.com.lilyproject.usb.UsbCommunicator;

public class UsbTester extends JFrame implements ActionListener {

	JButton openPort;
	JButton closePort;
	JButton send;
	JLabel sendData;
	JTextField data;	
	JScrollPane scrollPane;
	JTextArea receivedData;
	
	UsbCommunicator comm;

	public UsbTester() {
		setLayout(null);
		setSize(600, 600);
		setLocation(600, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		drawComponents();
		comm = new UsbCommunicator();

		setVisible(true);
	}

	private void drawComponents() {
		openPort = SwingUtils.getButton("Open Port", 50, 50, 100, 30, this);
		add(openPort);
		closePort = SwingUtils.getButton("Close Port", 50, 100, 100, 30, this);
		add(closePort);
		sendData = SwingUtils.getLabel("Enter data to send.", 200, 50, 200, 30);
		add(sendData);
		data = SwingUtils.getTextField("", 200, 100, 100, 30);
		add(data);
		send = SwingUtils.getButton("Send", 200, 150, 100, 30, this);
		add(send);
		receivedData = SwingUtils.JTextArea("", 330, 100, 200, 200);
		add(receivedData);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(openPort)) {
			comm.openPort();
		}

		if (e.getSource().equals(closePort)) {
			comm.closePort();
		}
		
		if (e.getSource().equals(send)) {
			comm.sendData(data.getText());
		}
	}

}
