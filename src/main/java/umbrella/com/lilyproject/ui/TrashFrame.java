package umbrella.com.lilyproject.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;

import umbrella.com.lilyproject.ui.graphicComponents.GridComponent;
import umbrella.com.lilyproject.ui.graphicElements.CustomWord;
import umbrella.com.lilyproject.ui.graphicElements.WordBox;

public class TrashFrame extends JFrame {

	public TrashFrame() {
		setLayout(null);
		setSize(600, 600);
		setLocation(600, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		GridComponent grid1 = new GridComponent(new Point(0, 0), 5, 100);
		GridComponent grid2 = new GridComponent(new Point(100, 100), 30, 300);
		GridComponent grid3 = new GridComponent(new Point(400, 400), 10, 200);		
		GridComponent grid4 = new GridComponent(new Point(0, 100), 10, 100);

		grid1.setBackground(Color.YELLOW);
		//add(grid1);
		
		grid2.setBackground(Color.red);
		//add(grid2);	
		
		//add(grid3);	
		
		grid4.setBackground(Color.CYAN);
		//add(grid4);

		CustomWord word = new CustomWord();
		word.setSize(100,100);
						
		Dimension wordBoxDimension = new Dimension(200,200);
		WordBox wordBox = new WordBox("Pame", wordBoxDimension, new Font("Serif", Font.BOLD, 24), Color.BLACK);
		wordBox.setSize(wordBoxDimension);
		add(wordBox);
		
		setVisible(true);
	}

}
