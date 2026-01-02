import java.io.*;
import jds.SortAlgorithm;
import jds.collection.Vector;
import jds.sort.ShellSort;
import jds.util.StringCompare;

class WordFreq {
	static public void main (String [ ] args) {
		Vector v = new Vector();
		try {
			// step 1. first read the input
			FileReader fin = new FileReader(args[0]);
			BufferedReader in = new BufferedReader(fin);
			String line = in.readLine();
			while (line != null) {
				v.addLast(line);
				line = in.readLine();
			}

			// step 2. then sort the words
			SortAlgorithm alg = new ShellSort(new StringCompare());
			alg.sort(v);

			// step 3. then print out the frequency
			int count = 1;
			for (int i = 2; i < v.size(); i++) {
				if (v.elementAt(i).equals(v.elementAt(i-1)))
					count++;
				else { // new word, print old count
					System.out.println("word " +
						v.elementAt(i-1) +
						":" + count);
					count = 1;
				}	
			}
			System.out.println("word " +
				v.elementAt(v.size()-1) + ":" + count);
		} catch (IOException e) {
			System.out.println("received IO Exception " + e);
		}
	}
}

