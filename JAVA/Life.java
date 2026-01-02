import java.awt.*;
import java.io.*;
import jds.collection.BitMatrix;
import jds.util.CloseQuit;

class Life extends Frame {
	public static void main (String [ ] args) { 
		try {
			FileReader fin = new FileReader(args[0]);
			Life world = new Life(fin); 
			world.show(); 
			while (true) {
				world.nextGeneration();
				world.repaint();
				Thread.sleep(300);
			}
		} catch (Exception e) { 
			System.err.println("unable to initialize"); 
		}
	}

	public Life (Reader fin) throws IOException {
			// window initialization
		setSize(300, 300); setTitle("Game of Life");
		addWindowListener(new CloseQuit());
			// application specific initialization
		StreamTokenizer tok = new StreamTokenizer(fin);
		tok.nextToken(); numRows = (int) tok.nval;
		tok.nextToken(); numColumns = (int) tok.nval;
		cells = new BitMatrix(numRows, numColumns);
		neighborCount = new int [numRows][numColumns];
		while (tok.nextToken() != StreamTokenizer.TT_EOF) {
			int i = (int) tok.nval;
			tok.nextToken(); 
			int j = (int) tok.nval;
			cells.set(i, j);
		}
	}

	private int numRows, numColumns;
	private BitMatrix cells;
	private int [ ] [ ] neighborCount;

	public void paint (Graphics g) {
		int cellHeight = 300 / numRows;
		int cellWidth = 300 / numColumns;
		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numColumns; j++)
				if (cells.get(i, j))
					g.fillOval(i * cellHeight,
						j * cellWidth, cellHeight, cellWidth);
			// now sleep for a while, then draw again
		//try { Thread.sleep(1000); } catch (Exception e) { }
		//nextGeneration();
	}

	private void nextGeneration () {
			// first count neighbors
		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numColumns; j++) 
				neighborCount[i][j] = countNeighbors(i,j);
			// then make new generation of cells
		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numColumns; j++)
				if (cells.get(i,j)) {
					if ((neighborCount[i][j] < 2) ||
						(neighborCount[i][j] > 3))
					cells.clear(i,j);
				} else if (neighborCount[i][j] == 3)
					cells.set(i,j);
		repaint(); // schedule repaint
	}

	private int countNeighbors(int i,int j) {
		return living(i-1, j-1) + living(i-1, j) + 
		living(i-1,j+1) + living(i, j-1) + living(i,j+1) +
		living(i+1, j-1) + living(i+1, j) + living(i+1, j+1);
	}

	private int living(int i, int j) {
		if ((i < 0) || (i >= numRows)) return 0;
		if ((j < 0) || (j >= numColumns)) return 0;
		if (cells.get(i, j)) return 1;
		return 0;
	}
		
}

