//Tipos primitivos Java
//
//Exemplos de situações "estranhas" 
//para utilizadores de outras linguagens
//de programação
//
class TesteVars{
	public static void main(String args[]) throws java.io.IOException
	{
		//Os tipos primitivos do Java
		
		// true ou false (1 bit)
		boolean b1;
		// -127 a 127 (8 bit signed)
		byte b2; 
		// -32768 a 32767 (16 bit signed)
		short s1;
		// -2147483648 to 2147483647 (32 bit signed)
		int i1;
		// -9223372036854775808 a 9223372036854775807 (64 bit signed)
		long l1;
		// 0 a 65535 (16 bit unsigned)
		char c1;
		// 32 bit floating point
		float f1;
		// 64 bit floating point
		double d1;

		//
		//Exemplo de "overflow" em java
		//
		//O valor final de b2 é -56 e não 200
		//(que não "cabe" num byte)
		//

		b2 = 100;
		s1 = b2; // pode-se converter directamente byte para short
		b2 *= 2; // overflow!
		s1 *= 2;
		System.out.println("byte =" + b2 + " short =" + s1);


		s1 = 100;
		s1 *= 2;
		// não é possível converter implícitamente short para byte
		// é necessário utilizar uma conversão explícita.
		// Se bem que com eventual perda de informação
		b2 = (byte) s1; 
		System.out.println("byte=" + b2 + " short=" + s1);

		//
		//Exemplo de utilização de boolean
		//
		//Não é possível converter os outros tipos primitivos
		//de e para boolean
		//

		b1=true;
		//b2 = b1; é inválido
		//Temos que usar um "if" 
		if (b1) b2=-1; else b2=0;
		//Ou a forma compacta do if:
		// [cond] ? [if true] : [if false]
		//Nota: como as constantes são int temos de fazer a
		//conversão explícita (isto não acontece quando estamos
		//a colocar o valor directamente num variável). 
		b2=b1?(byte)-1:(byte)0;
		System.out.println("boolean=" + b1 + " byte=" + b2);


		b2=-1;
		//b1 = b2; é inválido
		//Temos que usar uma condição 
		b1=(b2!=0);
		System.out.println("boolean=" + b1 + " byte=" + b2);

		//
		//Exemplo de perda de precisão num float
		//
		//O Java não verifica perdas de precisão numa
		//conversão

		//Por defeito as constantes numéricas no Java
		//são int é necessário acrescentar um "L" para
		//indicar que é um long
		l1 = 123456789123L; 
		f1 = l1;
		d1 = l1;
		System.out.println("long=" + l1 + " float=" + f1 + " double=" +d1);
		//deviam dar todos 23
		l1 -= 123456789100L;
		f1 -= 123456789100L; //perda de precisão: vai dar 0
		d1 -= 123456789100L;
		System.out.println("long=" + l1 + " float=" + f1 + " double=" +d1);
		
		System.in.read();
	}
}

