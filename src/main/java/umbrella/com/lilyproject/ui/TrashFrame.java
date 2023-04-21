package umbrella.com.lilyproject.ui;

import javax.swing.JFrame;

public class TrashFrame extends JFrame{
	
	public TrashFrame() {
		setSize(600, 600);
		setLocation(600, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new GenericPanel());
	}

}
