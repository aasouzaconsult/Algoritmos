//Programa Soma2
//
//ler números do teclado, operações simples
//


class Soma2{

	// Ler numero do teclado
	// Esta versão funciona em todos os sistemas
	// além de verificar fim de ficheiro (i==-1)
	static int lerNumero(String prompt)
		//Como utilizamos System.in.read() temos
		//de ter em conta a excepção IOException
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
		int total = 0;

		System.out.println("Indique os valores a somar terminando com 0");
		
		//Ler Numero
		do {
			//Aqui utilizamos o nosso método
			n=lerNumero("Indique valor:");
			
			//e acumular...
			total += n;
		} while (n!=0);

		System.out.println("O total e: "+total);
		
		System.in.read();
	}
}

