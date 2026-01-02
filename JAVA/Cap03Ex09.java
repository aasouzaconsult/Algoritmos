//DO

public class Cap03Ex09 {
	public static void main (String args[])
	{
		int total = 0;
		int indice = 0;
		
		do  {
			indice++;
			total = total + indice;
		} while (indice < 100 );
		
		System.out.println("A soma dos números de 1 a 100 é igual a: " + total);
	}
}
