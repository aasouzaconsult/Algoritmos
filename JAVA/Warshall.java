class Warshall {
	static void warshall (int [ ] [ ] a) {
		int n = a.length;
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					a[i][j] |= a[i][k] & a[k][j];
		}
	}

	static public void main (String [ ] args) {
int [ ] [ ] adjacency = { { 1, 0, 0, 1, 0, 0, 0, 1},
				{ 0, 1, 0, 1, 0, 0, 0, 0},
				{ 0, 0, 1, 0, 0, 1, 0, 1},
				{ 0, 0, 1, 1, 0, 1, 0, 1},
				{ 1, 0, 0, 0, 1, 0, 0, 0},
				{ 0, 1, 0, 0, 0, 1, 0, 0},
				{ 0, 0, 0, 0, 0, 1, 1, 0},
				{ 0, 0, 0, 0, 1, 0, 0, 1} };

		warshall (adjacency);
		matrixOutput (adjacency);
	}

	static void matrixOutput (int [ ] [ ] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) 
				System.out.print(" " + a[i][j]);
			System.out.println(" ");
		}
	}
}

