class Floyd {
	public static void floyd (double [ ] [ ] a) {
		int n = a.length;
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++)  {
				for (int j = 0; j < n; j++) {
					//if ((a[i][k] != Integer.MAX_VALUE) &&
						//(a[k][j] != Integer.MAX_VALUE)) {
						double m = a[i][k] + a[k][j];
//System.out.println("i j " + i + " " + j + " " + m + " " + a[i][j] + " " + (m < a[i][j]));
						if (m < a[i][j])
							a[i][j] = m;
					//}
				}
			}
		System.out.println("iteration " + k);
		putmatrix(a);
		}
	}

	public static void putmatrix (double [ ] [ ] a) {
		for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++)
		//if (a[i][j] == Integer.MAX_VALUE) System.out.print(" M");
		//else 
		System.out.print(" " + a[i][j]);
		System.out.println(" ");
		}
	}

	public static void main (String [ ] args) {
		double [ ] [ ] a = new double[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++)
				a[i][j] = Double.POSITIVE_INFINITY;
			a[i][i] = 0.0;
		}
		a[0][3] = 4;
		a[0][7] = 8;
		a[1][3] = 5;
		a[2][5] = 5;
		a[2][7] = 3;
		a[3][2] = 4;
		a[3][5] = 10;
		a[3][7] = 3;
		a[4][0] = 2;
		a[5][1] = 4;
		a[6][5] = 2;
		a[7][4] = 3;
		putmatrix(a);

		floyd(a);
		putmatrix(a);
	}
}

