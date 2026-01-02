import java.awt.*;
import java.util.Enumeration;
import java.awt.event.*;
import jds.Queue;
import jds.collection.LinkedList;
import jds.util.CloseQuit;

class Caterpillar {
	public Caterpillar (Color c, Point sp) {
		color = c;
		for (int i = 0; i < 10; i++) {
			position = new Point(sp.x + i, sp.y);
			body.addLast(position);
		}
	}

	private Color color;
	private Point position;
	private char direction = 'E';
	private Queue body = new LinkedList();
	private Queue commands = new LinkedList();

	public void setDirection (char d) {
		commands.addLast (new Character(d));
	}

	public void move (CaterpillarGame game) {
			// first see if we should change direction
		if (commands.size() > 0) {
			Character c = (Character) commands.getFirst();
			commands.removeFirst();
			direction = c.charValue();
			if (direction == 'Z') return;
		}
			// then find new position
		Point np = newPosition();
		if (game.canMove(np)) {
				// erase one segement, add another
			body.removeFirst();
			body.addLast (np);
			position = np;
		}
	}

	private Point newPosition () {
		int x = position.x;
		int y = position.y;
		if (direction == 'E') x++;
		else if (direction == 'W') x--;
		else if (direction == 'N') y--;
		else if (direction == 'S') y++;
		return new Point(x, y);
		}

	public boolean inPosition (Point np) {
		Enumeration e = body.elements();
		while (e.hasMoreElements()) {
			Point location = (Point) e.nextElement();
			if (np.equals(location)) return true;
		}
		return false;
	}

	public void paint (Graphics g) {
		g.setColor(color);
		Enumeration e = body.elements();
		while (e.hasMoreElements()) {
			Point p = (Point) e.nextElement();
			g.fillOval(5 + CaterpillarGame.SegmentSize * p.x, 
				15 + CaterpillarGame.SegmentSize * p.y, 
				CaterpillarGame.SegmentSize, CaterpillarGame.SegmentSize);
		}
	}
}

public class CaterpillarGame extends Frame {
	public static void main (String [ ] args) 
	{ CaterpillarGame world = new CaterpillarGame(); world.show(); world.run(); }

	public CaterpillarGame () {
		setSize ((BoardWidth+1)*SegmentSize, BoardHeight*SegmentSize + 30); 
		setTitle ("Caterpillar Game");
		addKeyListener (new KeyReader());
		addWindowListener(new CloseQuit());
	}

	private Caterpillar playerOne = new Caterpillar (Color.blue, new Point(20, 10));
	private Caterpillar playerTwo = new Caterpillar (Color.red, new Point(20, 30));
	final static int BoardWidth = 60;
	final static int BoardHeight = 40;
	final static int SegmentSize = 10;

	public void run () {
			// now start the game
		while (true) {
			movePieces();
			repaint();
			try {
				Thread.sleep(100);
			} catch (Exception e) { }
		}
	}

	public void paint (Graphics g) 
		{ playerOne.paint(g); playerTwo.paint(g); }

	public void movePieces () {
		playerOne.move(this);
		playerTwo.move(this);
	}

	public boolean canMove (Point np) {
			// get x, y coordinate
		int x = np.x;
		int y = np.y;
			// test playing board
		if ((x <= 0) || (y <= 0)) return false;
		if ((x >= BoardWidth) || (y >= BoardHeight)) return false;
			// test caterpillars
		if (playerOne.inPosition(np)) return false;
		if (playerTwo.inPosition(np)) return false;
			// ok, safe square
		return true;
	}

	private class KeyReader extends KeyAdapter {
		public void keyPressed (KeyEvent e) {
			char c = e.getKeyChar();
			switch (c) {
				case 'q': playerOne.setDirection('Z'); break;
				case 'p': playerTwo.setDirection('Z'); break;
				case 'a': playerOne.setDirection('W'); break;
				case 'd': playerOne.setDirection('E'); break;
				case 'w': playerOne.setDirection('N'); break;
				case 's': playerOne.setDirection('S'); break;
				case 'j': playerTwo.setDirection('W'); break;
				case 'k': playerTwo.setDirection('S'); break;
				case 'l': playerTwo.setDirection('E'); break;
				case 'i': playerTwo.setDirection('N'); break;
			}
		}
	}
}
