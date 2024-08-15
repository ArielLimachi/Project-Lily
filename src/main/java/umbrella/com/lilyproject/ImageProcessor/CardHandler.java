package umbrella.com.lilyproject.ImageProcessor;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

public class CardHandler<Card> extends JPanel {

	private CardLayout layout;

	public CardHandler() {
		layout = new CardLayout();
		setLayout(layout);
	}

	public void addCard(Card card, int index) {
		add((Component) card, index);
	}

	public void showCards() {
		layout.first(this);
	}

	public void updateCards(List<Card> cards) {
		removeAllCards();
		int index = 0;
		for (Card card : cards) {
			addCard(card, index);
			index++;
		}
	}

	public void removeAllCards() {
		removeAll();
	}

	public void next() {
		layout.next(this);
	}

	public void previous() {
		layout.previous(this);
	}
	
	public int getCardSetSize() {
		return this.getComponentCount();
	}
	
	public Card getCurrentCard() {
		for (Component card : getComponents()) {
            if (card.isVisible()) {
                return (Card) card; 
            }
        }
		return null;
	}	
	
}
