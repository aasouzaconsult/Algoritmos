import java.awt.*;

class KnightsTour extends Frame {
	public static void main (String [ ] args) {
		KnightsTour world = new KnightsTour();
		world.show();
		world.se.run();
	}

	public KnightsTour () {
			// first do window initialization
		setSize(200, 200);
		setTitle("knights tour puzzle");
			// then application specific initialization
		board = new int [BoardSize][BoardSize];
		se = new SearchEngine (new KnightState(0, 0, 1));
	}

	public void paint (Graphics g) {
		for (int i = 0; i < BoardSize; i++)
			for (int j = 0; j < BoardSize; j++)
				if (board[i][j] != 0)
					g.drawString(String.valueOf(board[i][j]),
						50 + 20 * i, 50 + 20 * j);
	}

	private static final int BoardSize = 5;
	private int [ ] [ ] board;
	public SearchEngine se;

	class KnightState extends SearchState {
		public KnightState (int nx, int ny, int sn) {
			x = nx; y = ny; stepNumber = sn;
			board[x][y] = stepNumber;
			visited = 0;
		}

		int x, y, stepNumber, visited;

		public SearchState advance () 
			throws SearchDone, CannotAdvance {
			if (stepNumber == BoardSize * BoardSize)
				throw new SearchDone();
			try { Thread.sleep(50); } catch(Exception e) { }
			while (++visited < 9) {
				int nx = 0;int ny = 0;
				switch (visited) {
					case 1: nx = x - 1; ny = y -2; break;
					case 2: nx = x + 1; ny = y -2; break;
					case 3: nx = x - 2; ny = y -1; break;
					case 4: nx = x + 2; ny = y -1; break;
					case 5: nx = x - 2; ny = y +1; break;
					case 6: nx = x + 2; ny = y +1; break;
					case 7: nx = x - 1; ny = y +2; break;
					case 8: nx = x + 1; ny = y +2; break;
				}
				if ((nx >= 0) && (ny >= 0) &&
				    (nx < BoardSize) && (ny < BoardSize) &&
				    (board[nx][ny] == 0)) {
					repaint();
					return new 
						KnightState(nx, ny, stepNumber+1);
				}
			}
			board[x][y] = 0;
			throw new CannotAdvance();
		}
	}
}

