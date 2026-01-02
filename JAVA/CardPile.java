//
//	card pile abstraction
//

import java.awt.*;
import jds.Stack;
import jds.collection.Vector;

class CardPile {

	public CardPile (int ix, int iy, Stack sk) { 
		x = ix; y = iy; cards = sk; }

	public CardPile (int ix, int iy) { 
		x = ix; y = iy; cards = new Vector(); }

	public void addCard (Card aCard) { cards.addLast(aCard); }
	public boolean isEmpty () { return cards.isEmpty(); }
	public boolean canTake (Card aCard) { return false; }

	public Card topCard () { 
		Card result = (Card) cards.getLast();
		cards.removeLast();
		return result;
	}

	public boolean includes (int tx, int ty) {
		return ((tx > x) && (ty > y) && 
			(tx <= x + Card.width) && (ty <= y+Card.height));
	}

	public void draw (Graphics g) {
		g.setColor(Color.blue);
		if (cards.isEmpty())
			g.drawRect(x, y, Card.width, Card.height);
		else {
			Card aCard = (Card) cards.getLast();
			aCard.draw(g, x, y);
		}
	}

	private int x, y;
	protected Stack cards;
}
