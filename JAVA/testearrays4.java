//Arrays de arrays
//
//Exemplo de utilização de array "dinâmico"
//de arrays de arrays
//
class TesteArrays4{

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
		int n0[]={};
		
		int n1[][]={};
		//podia-mos ter feito também:
		//int n1[][]=new int[0][0];
		//
		//Atenção que 
		//int n1[][]={{}};
		//é inválido!!
		//Criava um array
		
		System.out.println("Indique o vencedor de cada prova.");
		System.out.println("Entre 0 para terminar.");
		System.out.println("Entre 0 na primeira prova para modo demonstracao.");
		//Ler array
		{//permite definição local de i e n
			int i=0;
			int n=lerNumero("Indique vencedor da "+(++i)+". prova:\n");
			while (n!=0) {
				//criar array temporário
				int ntemp[]=new int[n0.length+1];
				//copiar valores
				System.arraycopy(n0,0,ntemp,0,n0.length);
				//inserir novo valor
				ntemp[n0.length]=n;
				//colocar na var definitiva
				n0=ntemp;

				//ler próximo valor
				n=lerNumero("Indique vencedor da "+(++i)+". prova:\n");
			}
		}
		
		//Modo demonstração
		if (n0.length==0)
		{
			int ntemp[]={1,1,1,1,2,2,1,3,3,4,500,500,1,1,1};
			n0 = ntemp;
		}

		//Mostrar array
		for(int i=0;i<n0.length; i++)
			System.out.println((i+1)+". prova vencida por:"+n0[i]);

		//criar segundo array
		for(int i=0;i<n0.length; i++)
		{
			//procurar vencedor no segundo array
			int j=0; 
			int curline=-1; 
			
			//debug...
			System.out.print("Procura: "+i+" valor: " +n0[i]+"...");
				
			while(j<n1.length)
			{
				//debug...
				System.out.print(j);
				
				if (n1[j][0]==n0[i])
				{
					curline=j;
					break;
				}
				j++;
			}

			//inserir nova linha
			if (curline==-1)
			{
				//debug...
				System.out.print(" Nova linha:"+n1.length);
				
				int ntemp[][]=new int[n1.length+1][];
				System.arraycopy(n1,0,ntemp,0,n1.length);
				curline=n1.length;
				ntemp[curline]=new int[1];
				ntemp[curline][0]=n0[i];
				n1=ntemp;
			}

			//inserir novo valor na linha
			{ //bloco que permite definição local de ntemp
				
				//debug...
				System.out.print(" Nova prova:"+i);
				
				int ntemp[]=new int[n1[curline].length+1];
				System.arraycopy(n1[curline],0,ntemp,0,n1[curline].length);
				ntemp[n1[curline].length]=i;
				n1[curline]=ntemp;
			}

			System.out.println("");
		}


		//apresentar segundo array
		for(int i=0;i<n1.length; i++)
		{
			if (n1[i].length>2)
				System.out.print("Corredor " + (n1[i][0]) + " Vencedor das provas:");
			else
				System.out.print("Corredor " + (n1[i][0]) + " Vencedor da prova:");
			
			for(int j=1;j<n1[i].length; j++)
				System.out.print(" " + (n1[i][j]+1));
			System.out.println("");
		}

		System.out.println("\nPrima [Enter] para continuar...");
		System.in.read();
	}
}

