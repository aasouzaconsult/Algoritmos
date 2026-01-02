//Programa Soma
//
//ler números do teclado, operações simples
//


class Soma{

	public static void main(String args[])
		throws java.io.IOException
	{
		//Inicializar e/ou declarar variáveis
		String s=""; //atenção: sem espaço entre as aspas!
		char c;
		int a;

		//Ler 1ª string
		System.out.println("Indique o 1. numero:"); 
		while ((c=(char)System.in.read())!=13)
			s+=c;
		//Converter string para número
		int n1=Integer.valueOf(s).intValue();

		//Notas:
		//A instrução
		//c=(char)System.in.read() lê um
		//caracter e coloca-o na variável c
		//Depois é verificado se se leu o
		//"Enter".
		//Em alguns sistemas o código é ligeiramente
		//diferente (a tecla ENTER gera a sequencia
		//caracter 13 + caracter 10):
		//while ((c=(char)System.in.read())!=13)
		//	s+=c;
		//System.in.read()
		
		//Ler 2ª string
		s="";
		System.out.println("Indique o 2. numero:"); 
		while ((c=(char)System.in.read())!=13)
			s+=c;
		//Converter string para número
		int n2=Integer.valueOf(s).intValue();

		a=n1+n2;
		System.out.println("A soma vale "+a);
		//Nota:O Java converte o int a para 
		//uma String e acrescenta-a à String
		//"A soma vale "

		//Também poderíamos ter feito:
		System.out.println("A soma também vale "+(n1+n2));
		
		//Mas não devemos fazer: !!!
		System.out.println("A soma não vale "+n1+n2);
		
		System.in.read();
	}
}

