//WHILE

public class Cap03Ex08 {
	public static void main (String args[])
	{
		int total = 0;
		int indice = 0;

		while (indice < 100 ) {
			indice++;
			total = total + indice;
		}
		System.out.println("A soma dos números de 1 a 100 é igual a: " + total);
	}
}
