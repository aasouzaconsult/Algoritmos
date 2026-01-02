//Introdução a Arrays
//
//Exemplo de utilização de array "dinâmico"
//
class TesteArrays2{

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
		int n1[]={};
		//podia-mos ter feito também:
		//int n1[]=new int[0];
		int soma=0;
		int max=0;
		int i=1;
		
		//Ler array
		int n=lerNumero("Indique 1. valor:\n");

		while (n!=0) {
			//criar array temporário
			int n2[]=new int[n1.length+1];
			//copiar valores
			for(int j=0;j<n1.length;j++)
				n2[j]=n1[j];
			//inserir novo valor
			n2[n2.length-1]=n;
			//colocar na var definitiva
			n1=n2;

			n=lerNumero("Indique "+(++i)+". valor:\n");
		}
		//Mostrar array
		for(i=0;i<n1.length; i++)
			System.out.println("i["+i+"]="+n1[i]);

		//Calcular máximo, total
		for(i=0;i<n1.length; i++)
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

