import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import jds.Bag;
import jds.collection.LinkedList;
import jds.util.CloseQuit;

class Asteroid {
	public Asteroid (double ix, double iy, double idx, double idy)
		{ x = ix; y = iy; dx = idx; dy = idy; }

	public double x, y;
	public int size = 20;
	private double dx, dy;

	public void move () { x += dx; y += dy; }

	public void paint (Graphics g) {
		g.setColor(Color.black);
		g.drawOval((int) x, (int) y, size, size);
	}

	public void hit () { size = size - 4; }

	public boolean nearTo (double tx, double ty) {
		double distance = Math.sqrt((x-tx)*(x-tx)+(y-ty)*(y-ty));
		return distance < 10;
	}
}

class Rocket {
	public Rocket (double ix, double iy, double idx, double idy)
		{ x = ix; y = iy; dx = idx; dy = idy; }

	public double x, y;
	private double dx, dy;

	public void move (Bag asteroids) {
		x += dx; y += dy;
		Enumeration e = asteroids.elements();
		while (e.hasMoreElements()) {
			Asteroid rock = (Asteroid) e.nextElement();
			if (rock.nearTo(x, y))
				rock.hit();
		}
	}

	public void paint (Graphics g) {
		g.setColor(Color.black);
		g.fillOval((int) x, (int) y, 5, 5);
	}
}

class Station {

	public Station (double ix, double iy) { x = ix; y = iy; }

	private double angle = Math.PI / 2.0;
	private int hits = 0;
	private final double x;
	private final double y;

	public void moveLeft() { angle = angle + 0.1; }
	public void moveRight() { angle = angle - 0.1; }

	public void fire (Bag rockets) {
		double cosAngle = Math.cos(angle);
		double sinAngle = Math.sin(angle);
		Rocket r = new Rocket(x + 15 * cosAngle, y - 15 * sinAngle,
			5 * cosAngle, - 5 * sinAngle);
		rockets.addElement(r);
	}

	public void checkHit (Asteroid rock) {
		if (rock.nearTo((double) x, (double) y))
			hits += rock.size;
	}

	public void paint (Graphics g) {
		g.setColor (Color.black);
		double lv = 20 * Math.sin(angle);
		double lh = 20 * Math.cos(angle);
		g.drawLine((int) x, (int) y, (int) (x + lh), (int) (y - lv));
		g.drawString("hits: " + hits, (int) (x + 10), (int) (y - 5));
	}
}

public class AsteroidGame extends Frame {
	static public void main (String [ ] args)
	{ AsteroidGame world = new AsteroidGame(); world.show(); world.run(); }

	public AsteroidGame () {
		setTitle("Asteroid Game"); setSize(FrameWidth, FrameHeight);
		addKeyListener (new keyDown());
		addWindowListener(new CloseQuit());
	}

	public void run () { // move pieces
		while (true) {
			movePieces();
			repaint();
			try {
				Thread.sleep(100);
			} catch (Exception e) { }
		}
	}

	private int FrameWidth = 500;
	private int FrameHeight = 400;

	private Bag asteroids = new LinkedList();
	private Bag rockets = new LinkedList();
	private Station station = new Station (FrameWidth/2, FrameHeight-20);

	public void paint (Graphics g) {
		station.paint(g);
		Enumeration e = asteroids.elements();
		while (e.hasMoreElements()) {
			Asteroid rock = (Asteroid) e.nextElement();
			rock.paint(g);
		}
		e = rockets.elements();
		while (e.hasMoreElements()) {
			Rocket rock = (Rocket) e.nextElement();
			rock.paint(g);
		}
	}

	private void movePieces () {
			// create a random new asteroid
		if (Math.random() < 0.3) {
			Asteroid newRock = new Asteroid(
				FrameWidth * Math.random(), 20,
				10 * Math.random()-5, 3 + 3 * Math.random());
			asteroids.addElement(newRock);
		}
			// then move everything
		Enumeration e = asteroids.elements();
		while (e.hasMoreElements()) {
			Asteroid rock = (Asteroid) e.nextElement();
			rock.move();
			station.checkHit(rock);
		}
		e = rockets.elements();
		while (e.hasMoreElements()) {
			Rocket rock = (Rocket) e.nextElement();
			rock.move(asteroids);
		}
	}

	private class gameMover extends Thread {
		public void run () {
			while (true) {
				movePieces();
				repaint();
				try {
					sleep(100);
				} catch (Exception e) { }
			}
		}
	}

	private class keyDown extends KeyAdapter {
		public void keyPressed (KeyEvent e) {
			char key = e.getKeyChar();
			switch (key) {
				case 'j': station.moveLeft(); break;
				case 'k': station.moveRight(); break;
				case ' ': station.fire(rockets); break;
				case 'q': System.exit(0);
			}
		}
	}
}

