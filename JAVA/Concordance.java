import java.util.*;
import java.io.*;
import jds.util.StringCompare;

class Concordance {
   private MultiMap dict = new MultiMap(new StringCompare());

   public void readLines (BufferedReader input) throws IOException {
      String delims = " \t\n.,!?;:";
      for (int line = 1; true; line++ ) {
         String text = input.readLine();
	 Integer iline = new Integer(line);
         if (text == null) return;
         text = text.toLowerCase();
         Enumeration e = new StringTokenizer(text, delims);
         while (e.hasMoreElements()) {
	    String word = (String) e.nextElement();
	    if (! dict.contains(word, iline))
		dict.set(word, iline);
         }
      }
   }

   public void generateOutput (PrintStream output) {
      Enumeration e = dict.elements();
      while (e.hasMoreElements() ) {
         String word = (String) e.nextElement();
         Enumeration f = (Enumeration) dict.get(word);
         output.print (word + ": ");
         while (f.hasMoreElements()) 
            output.print (f.nextElement() + " ");
         output.println (" ");
      }
   }

   public static void main (String [ ] args) {
	Concordance cd = new Concordance();
	try {
		cd.readLines(new  BufferedReader(new InputStreamReader(System.in)));
	} catch(IOException e) { System.out.println("received IO error " + e);}
	cd.generateOutput (System.out);
   }
}
