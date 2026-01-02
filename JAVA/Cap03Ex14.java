//Math.random

public class Cap03Ex14 {
		public static void main (String args[])	{	
			int total = 0;
			int indice;
			for (indice = 0; indice <= 100; indice++) {
					total = (int) (Math.random()*100);
					System.out.println (total);		
 				}	
		}
}