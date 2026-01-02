import java.awt.*;
import java.awt.event.*;
import jds.Stack;
import jds.collection.Vector;

class WastePile extends CardPile {
	public WastePile (int ix, int iy) { super(ix, iy); }
	public boolean canTake (Card aCard) { return true; }
}

class FoundationPile extends CardPile {
	public FoundationPile (int ix, int iy) { super(ix, iy); }

	public boolean canTake (Card aCard) { 
		if (isEmpty()) return aCard.rank() == 1;
		Card tp = (Card) cards.getLast();
		if (aCard.rank() == 1 + tp.rank()) return true;
		return false;
	}
}

class Frog extends Frame {
	public static void main (String [ ] args) {
		Frog world = new Frog();
		world.show();
	}

	public Frog () {
			// frame initialization
		setSize(400, 300); setTitle("Frog");
		addMouseListener(new MouseKeeper());
			// application initialization
		deck = new CardPile(20, 150);
			// now add the deck of cards
		Vector v = new Vector();
		for (int i = 1; i <= 13; i++) {
			v.addLast(new Card(1, i));
			v.addLast(new Card(2, i));
			v.addLast(new Card(3, i));
			v.addLast(new Card(4, i));
		}
			// now shuffle the cards
		while (! v.isEmpty()) {
			int i = (int) (v.size() * Math.random());
			Card c = (Card) v.elementAt(i);
			v.removeElementAt(i);
			deck.addCard(c);
		}
			// create the stack pile
		stack = new CardPile(20, 40);
		for (int i = 0; i < 13; i++)
			stack.addCard(deck.topCard());
			// and the other piles
		foundation = new CardPile[4];
		for (int i = 0; i < 4; i++)
			foundation[i] = new FoundationPile(90+60*i, 40);
		waste = new CardPile[4];
		for (int i = 0; i < 4; i++)
			waste[i] = new WastePile(90+60*i, 150);
	}

	CardPile deck;
	CardPile stack;
	CardPile [ ] foundation;
	CardPile [ ] waste;

	public CardPile findDeck (int x, int y) {
		if (deck.includes(x, y)) return deck;
		if (stack.includes(x, y)) return stack;
		for (int i = 0; i < 4; i++) {
			if (foundation[i].includes(x, y)) 
				return foundation[i];
			if (waste[i].includes(x, y)) 
				return waste[i];
		}
		return null;
	}

	public void paint (Graphics g) {
		deck.draw(g);
		stack.draw(g);
		for (int i = 0; i < 4; i++) {
			foundation[i].draw(g);
			waste[i].draw(g);
			}
	}

	private class MouseKeeper extends MouseAdapter {
		CardPile sourceDeck = null;

		public void mousePressed (MouseEvent e) { 
			sourceDeck = findDeck(e.getX(), e.getY());
		}

		public void mouseReleased (MouseEvent e) { 
			if (sourceDeck == null) return;
			if (sourceDeck.isEmpty()) return;
			CardPile toDeck = findDeck(e.getX(), e.getY());
			if (toDeck == null) return;
			Card playCard = sourceDeck.topCard();
			if (playCard == null) return;
			if (toDeck.canTake(playCard))
				toDeck.addCard(playCard);
			else 
				sourceDeck.addCard(playCard);
			repaint();
		}
	}
}
