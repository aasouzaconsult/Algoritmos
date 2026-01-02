//Introdução a Arrays
//
//Exemplo de utilização de array
//
class TesteArrays{

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


	public static void main(String args[]) throws java.io.IOException
	{
		
		//Declaração de variáveis
		int n1[]=new int[5];
		int soma=0;
		int max=0;
		
		//Ler array
		for(int i=0;i<5; i++)
			n1[i]=lerNumero("Indique "+i+" valor:\n");

		//Mostrar array
		for(int i=0;i<5; i++)
			System.out.println("i["+i+"]="+n1[i]);

		//Calcular máximo, total
		for(int i=0;i<5; i++)
		{
			soma+=n1[i];
			if (max<n1[i])
				max=n1[i];
		}

		
		//Mostrar resultados
		System.out.println("Total:"+soma);
		System.out.println("Media:"+(float)soma/n1.length);
		System.out.println("Maximo:"+max);
		//Nota: na media é necessário fazer uma divisao 
		//de floats.

		System.in.read();
	}
}

