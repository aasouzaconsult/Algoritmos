//Programa Numeros
//
//Processamento de números inteiros
//


class Numeros{

	static int lerNumero(String prompt)
		throws java.io.IOException
	{
		String s="";
		int i;

		//Apresentar mensagem
		System.out.print(prompt); 

		//Ler string...
		i=System.in.read();
		while ((i!=10) && (i!=13) && (i!=-1))
		{
			s+=(char)i;
			i=System.in.read();
		}

		if (i==13)
			System.in.read();

		//Converter string para número
		return Integer.valueOf(s).intValue();
	}

	public static void main(String args[])
		throws java.io.IOException
	{
		int n;
		int dig1, dig2, dig3, dig4;
		int max;

		System.out.println("Indique um número inteiro com até 4 algarismos");
		
		//Ler Numero
		n=lerNumero("");
		
		if (n>999) System.out.println("Tem 4 ou + algarismos");
		else if (n>99) System.out.println("Tem 3 algarismos");
		else if (n>9) System.out.println("Tem 2 algarismos");
		else System.out.println("Tem 1 algarismo");

		dig1=n%10; //unidades
		n=n/10;
		dig2=n%10; //dezenas
		n=n/10;
		dig3=n%10; //centenas
		n=n/10;
		dig4=n%10; //milhares
		
		System.out.println("A soma e: "+(dig1+dig2+dig3+dig4));

		max = dig1;
		if (dig2>max) max=dig2;
		if (dig3>max) max=dig3;
		if (dig4>max) max=dig4;
		
		System.out.println("O maior algarismo e: "+max);

		System.in.read();
	}
}

