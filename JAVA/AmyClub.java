import java.io.*;

class AmyClub {
	public static void main (String [ ] args) {
		double [ ] funds = new double[6];
		try {
			Reader rin = new FileReader("data");
			StreamTokenizer tok = new StreamTokenizer(rin);
			int c = tok.nextToken();
			while (c != StreamTokenizer.TT_EOF) {
				String name = tok.sval;
				tok.nextToken();
				double amount = tok.nval;
					// now update amount
				funds[nameHash(name)] += amount;
				c = tok.nextToken();
			}
		} catch (IOException e) { System.err.println("IO Err " + e); }
			// now print updated records
		System.out.println("Alfred paid " + funds[nameHash("Alfred")]);
		System.out.println("Alex paid " + funds[nameHash("Alex")]);
		System.out.println("Alice paid " + funds[nameHash("Alice")]);
		System.out.println("Amy paid " + funds[nameHash("Amy")]);
		System.out.println("Andy paid " + funds[nameHash("Andy")]);
		System.out.println("Anne paid " + funds[nameHash("Anne")]);
	}

	public static int nameHash (String name) {
		return (int) (name.charAt(2) - 'a') % 6;
	}
}

