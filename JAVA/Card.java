//
//	simple playing card abstraction
//

import java.awt.*;

public class Card {
	Card (int is, int ir) { s = is; r = ir; }

	private int s;
	private int r;

	public int suit() { return s; }
	public int rank() { return r; }

	public Color color () {
		if ((suit() == diamond) || (suit() == heart))
			return Color.red;
		else
			return Color.black;
	}

	final static public int heart = 1;
	final static public int club = 2;
	final static public int diamond = 3;
	final static public int spade = 4;

	final public static int height = 75;
	final public static int width = 50;

	public void draw (Graphics g, int x, int y) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		String body = "";
		if (suit() == heart) body = "H";
		if (suit() == club) body = "C";
		if (suit() == diamond) body = "D";
		if (suit() == spade) body = "S";
		body = String.valueOf(rank()) + " " + body;
		g.drawString(body, x+3, y+height/2);
	}
}

