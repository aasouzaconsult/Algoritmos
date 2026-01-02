//Programa Numeros2
//
//Processamento de números inteiros
//(evolução de Numeros)
//


class Numeros2{

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
		int dig;
		int ndig=0;
		int soma=0;
		int max=0;

		System.out.println("Indique um número inteiro");
		
		//Ler Numero
		n=lerNumero("");
		
		while (n>0)
		{
			dig = n%10;
			n /= 10;

			soma+=dig;
			if (dig>max) max=dig;
			ndig++;
		}
		
		if (ndig==1) System.out.println("Tem 1 algarismo");
		else System.out.println("Tem "+ndig+" algarismos");
		
		System.out.println("A soma dos algarimos e: "+soma);

		System.out.println("O maior algarismo e: "+max);

		System.in.read();
	}
}

