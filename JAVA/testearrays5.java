//Arrays como referências a um objecto
//
//Exemplos de utilização de arrays como
//referências
//
class TesteArrays5{

	// Ler string do teclado
	// Esta versão funciona em todos os sistemas
	// além de verificar fim de ficheiro (i==-1)
	static String lerString(String prompt)
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
		return s;
	}


	// Ler numero do teclado
	// Esta versão funciona em todos os sistemas
	// além de verificar fim de ficheiro (i==-1)
	static int lerNumero(String prompt)
		//Como utilizamos System.in.read() temos
		//de ter em conta a excepção IOException
		throws java.io.IOException
	{
		//Converter string para número
		return Integer.valueOf(lerString(prompt)).intValue();
	}

	public static void main(String args[]) throws java.io.IOException
	{
	
		//Primeiro exemplo: troca entre arrays
		//e duas variáveis apontando para o mesmo
		//array
		{

			System.out.print("// PRIMEIRO EXEMPLO:\n");

			int n1[]={1, 2, 3, 4};
			int n2[]={2, 3, 4};
			int n3[];

			System.out.print("\n// n1={");
			for (int i=0;i<n1.length;i++) System.out.print((i>0?",":"")+n1[i]);
			System.out.print("};");
			
			System.out.print("\n// n2={");
			for (int i=0;i<n2.length;i++) System.out.print((i>0?",":"")+n2[i]);
			System.out.print("};");
			
			n3=n1;
			n1=n2;
			n2=n3;

			System.out.print("\nn3=n1;\nn1=n2;\nn2=n3;");

			System.out.print("\n// n1={");
			for (int i=0;i<n1.length;i++) System.out.print((i>0?",":"")+n1[i]);
			System.out.print("};");
			
			System.out.print("\n// n2={");
			for (int i=0;i<n2.length;i++) System.out.print((i>0?",":"")+n2[i]);
			System.out.print("};");
			
			System.out.print("\n// n3={");
			for (int i=0;i<n3.length;i++) System.out.print((i>0?",":"")+n3[i]);
			System.out.print("};");
		
			n3[1]=55;
			System.out.print("\nn3[1]=55;");

			System.out.print("\n// n2={");
			for (int i=0;i<n2.length;i++) System.out.print((i>0?",":"")+n2[i]);
			System.out.print("};");

			System.out.print("\n// n3={");
			for (int i=0;i<n3.length;i++) System.out.print((i>0?",":"")+n3[i]);
			System.out.print("};");

		}


		//Segundo exemplo: colocar valores
		//num array
		{

			System.out.print("\n\n// SEGUNDO EXEMPLO:\n");

			int n1[]={11,12,13,14,15};

			System.out.print("\n// n1={");
			for (int i=0;i<n1.length;i++) System.out.print((i>0?",":"")+n1[i]);
			System.out.print("};");
	
			//Esta instrução podia ser dentro de um if por exemplo
			int n2[]={21,21,23};
			n1 = n2;

			System.out.print("\nint n2[]={21,21,23};\nn1=n2;");

			System.out.print("\n//n1={");
			for (int i=0;i<n1.length;i++) System.out.print((i>0?",":"")+n1[i]);
			System.out.print("};");
		}

		lerString("\n\nPrima [Enter] para o exemplo seguinte...");

		//Terceiro exemplo: array de arrays
		{

			System.out.print("\n\n// TERCEIRO EXEMPLO:\n");

			int n1[][]={{11,12},{21,22}};

			System.out.print("\n// n1={");
			for (int i=0;i<n1.length;i++)for (int j=0;j<n1[i].length;j++) System.out.print((j>0?",":(i>0?"},{":"{"))+n1[i][j]);
			System.out.print("}};");
	
			int n2[][]=new int[n1.length][];
			System.arraycopy(n1,0,n2,0,n1.length);
			System.out.print("\nSystem.arraycopy(n1,0,n2,0,n1.length);");
			
			System.out.print("\n// n1={");
			for (int i=0;i<n1.length;i++)for (int j=0;j<n1[i].length;j++) System.out.print((j>0?",":(i>0?"},{":"{"))+n1[i][j]);
			System.out.print("}};");
			System.out.print("\n// n2={");
			for (int i=0;i<n2.length;i++)for (int j=0;j<n2[i].length;j++) System.out.print((j>0?",":(i>0?"},{":"{"))+n2[i][j]);
			System.out.print("}};");

			n2[1][1]=55;
			System.out.print("\nn2[1][1]=55;");
			
			System.out.print("\n// n1={");
			for (int i=0;i<n1.length;i++)for (int j=0;j<n1[i].length;j++) System.out.print((j>0?",":(i>0?"},{":"{"))+n1[i][j]);
			System.out.print("}};");
			System.out.print("\n// n2={");
			for (int i=0;i<n2.length;i++)for (int j=0;j<n2[i].length;j++) System.out.print((j>0?",":(i>0?"},{":"{"))+n2[i][j]);
			System.out.print("}};");

			
			n2=new int[n1.length][];
			for (int i=0;i<n1.length;i++) {
				n2[i] = new int[n1[i].length];
				System.arraycopy(n1[i],0,n2[i],0,n1.length);
			}

			System.out.print("\nn2=new int[n1.length][];");
			System.out.print("\nfor (int i=0;i<n1.length;i++) {");
			System.out.print("\n   n2[i] = new int[n1[i].length];");
			System.out.print("\n   System.arraycopy(n1[i],0,n2[i],0,n1.length);\n}");
			
			System.out.print("\n// n1={");
			for (int i=0;i<n1.length;i++)for (int j=0;j<n1[i].length;j++) System.out.print((j>0?",":(i>0?"},{":"{"))+n1[i][j]);
			System.out.print("}};");
			System.out.print("\n// n2={");
			for (int i=0;i<n2.length;i++)for (int j=0;j<n2[i].length;j++) System.out.print((j>0?",":(i>0?"},{":"{"))+n2[i][j]);
			System.out.print("}};");

			n2[1][1]=88;
			System.out.print("\nn2[1][1]=88;");
			
			System.out.print("\n// n1={");
			for (int i=0;i<n1.length;i++)for (int j=0;j<n1[i].length;j++) System.out.print((j>0?",":(i>0?"},{":"{"))+n1[i][j]);
			System.out.print("}};");
			System.out.print("\n// n2={");
			for (int i=0;i<n2.length;i++)for (int j=0;j<n2[i].length;j++) System.out.print((j>0?",":(i>0?"},{":"{"))+n2[i][j]);
			System.out.print("}};");
			
		}

		lerString("\n\nPrima [Enter] para terminar...");

	}
}

