// CONVERSÃO

class Cap03Ex05 {
	public static void main (String args[])
	{
	String valor1 = "10";
	String valor2 = "20";
	
	System.out.print("Sem a conversão, o total é igual a: ");
	System.out.println(valor1 + valor2);

	int novoValor1 = Integer.parseInt(valor1);
	int novoValor2 = Integer.parseInt(valor2);

	System.out.print("Com a conversão, o total é igual a: ");
	System.out.println(novoValor1 + novoValor2);

	}
}
