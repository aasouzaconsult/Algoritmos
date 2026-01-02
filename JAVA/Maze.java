import java.awt.*;
import java.io.*;
import jds.Deque;
import jds.collection.LinkedList;
import jds.util.CloseQuit;

public class Maze extends Frame {
	public static void main (String [ ] args) {
		Maze world = new Maze("mazedata"); world.show(); world.solveMaze();
	}

	public Maze (String file) {
		setSize(200, 230); setTitle("Maze Puzzle");
		addWindowListener(new CloseQuit());
	}

	private int mazeWidth = 5;
	private int mazeHeight = 5;;
	private int [ ] [ ] walls = {
{14, 12, 5, 4, 6},
{10, 9, 4, 3, 10},
{9, 5, 2, 13, 2},
{14, 14, 10, 12, 2},
{9, 1, 1, 3, 11},
	};
	private int [ ] [ ] visited = new int[5][5];

	private void solveMaze () {
		LinkedList que = new LinkedList();
		que.addLast(new Point(mazeWidth-1, mazeHeight-1));
		int visitCount = 0;
		while (! que.isEmpty()) {
			Point p = (Point) que.getLast();
			que.removeLast();
			if (visited[p.x][p.y] == 0) {
				visited[p.x][p.y] = ++visitCount;	
				repaint();
				if ((p.x == 0) && (p.y == 0))
					return; // success, we're done
				putNeighbors(p.x, p.y, que);
				try {Thread.sleep(200);} catch (Exception e) { }
			}
		}
		System.err.println("no solution");
	}

	private void putNeighbors (int x, int y, LinkedList que) {
		if ((walls[x][y] & 1) == 0)
			que.addLast(new Point(x+1, y));
		if ((walls[x][y] & 2) == 0)
			que.addLast(new Point(x, y+1));
		if ((walls[x][y] & 4) == 0)
			que.addLast(new Point(x-1, y));
		if ((walls[x][y] & 8) == 0)
			que.addLast(new Point(x, y-1));
	}

	private void readMaze(String file) throws IOException {
		DataInputStream in = new DataInputStream(
			new FileInputStream(file));
		mazeHeight = in.readInt();
		mazeWidth = in.readInt();
		walls = new int[mazeHeight][mazeWidth];
		for (int i = 0; i < mazeHeight; i++)
			for (int j = 0; j < mazeWidth; j++)
				walls[i][j] = in.readInt();
	}

	public void paint (Graphics g) {
		int y = 50;
		for (int i = 0; i < mazeHeight; i++) {
			int x = 25;
			for (int j = 0; j < mazeWidth; j++) {
				if ((walls[i][j] & 1) != 0)
					g.drawLine(x, y+30, x+30, y+30);
				if ((walls[i][j] & 2) != 0)
					g.drawLine(x+30, y, x+30, y+30);
				if ((walls[i][j] & 4) != 0)
					g.drawLine(x, y, x+30, y);
				if ((walls[i][j] & 8) != 0)
					g.drawLine(x, y, x, y+30);
				if (visited[i][j] != 0)
					g.drawString(String.valueOf(visited[i][j]), x+7, y+20);
				x += 30;
			}
			y += 30;
		}
	}
}

