package umbrella.com.lilyproject.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import umbrella.com.lilyproject.ui.graphicComponents.GridComponent;
import umbrella.com.lilyproject.ui.graphicComponents.Letter;
import umbrella.com.lilyproject.utils.SwingComponentUtils;
import umbrella.com.lilyproject.utils.UiUtils;

public class TrashFrame extends JFrame implements ItemListener {

	JComboBox<String> fontListUi;
	boolean letterExists = false;
	Letter letter;

	public TrashFrame() {
		setLayout(null);
		setSize(600, 600);
		setLocation(600, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		GridComponent grid1 = new GridComponent(new Point(100, 100), 5, 100);
		GridComponent grid2 = new GridComponent(new Point(100, 100), 30, 300);
		GridComponent grid3 = new GridComponent(new Point(400, 400), 10, 200);
		GridComponent grid4 = new GridComponent(new Point(0, 100), 10, 100);

		grid1.setBackground(Color.YELLOW);
		add(grid1);

		grid2.setBackground(Color.red);
		add(grid2);

		add(grid3);

		grid4.setBackground(Color.CYAN);
		// add(grid4);

		fontListUi = SwingComponentUtils.buildComboBox(new Rectangle(10, 10, 100, 30));
		fontListUi.addItemListener(this);

		String[] fontList = UiUtils.getFontList();
		for (int i = 0; i < fontList.length; i++) {
			fontListUi.addItem(fontList[i]);
		}

		add(fontListUi);

		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == fontListUi) {

			if (letter != null)
				remove(letter);

			String seleccionado = (String) fontListUi.getSelectedItem();
			letter = new Letter('a', new Font(seleccionado, Font.PLAIN, 96), new Point(100, 100));

			add(letter);

			revalidate();
			repaint();

			// repaint();
		}
	}
}
