//Introdução à classe String
//
//Exemplo de utilização de aulguns métodos
//da classe
//
class TesteStrings2{
	public static void main(String args[]) throws java.io.IOException
	{
		
		//Declaração de variáveis
		String s1="",s2="";
		
		System.out.println("Indique a primeira string:");
	
		int i=System.in.read();
		while ((i!=10) && (i!=13) && (i!=-1))
		{
			s1+=(char)i;
			i=System.in.read();
		}
		if (i==13) System.in.read();

		System.out.println("Indique a segunda string:");

		i=System.in.read();
		while ((i!=10) && (i!=13) && (i!=-1))
		{
			s2+=(char)i;
			i=System.in.read();
		}
		if (i==13) System.in.read();

		//Diversos métodos da classe String...
		System.out.println("Nº de Caracteres: s1="+s1.length()+" s2="+s2.length()); 
		System.out.println("Maiusculas: s1=\""+s1.toUpperCase()+"\" s2=\""+s2.toUpperCase()+"\""); 
		System.out.print("As strings sao ");
		if (s1.equals(s2)) System.out.println("exactamente iguais.");
		else if (s1.equalsIgnoreCase(s2)) System.out.println("iguais ignorando minusculas/maiusculas.");
		else System.out.println("diferentes.");
		if (s1.startsWith("Teste")) System.out.println("A primeira string comeca por \"Teste\".");
		if (s2.startsWith("Teste")) System.out.println("A segunda string comeca por \"Teste\".");
		int a=s1.indexOf(" ");
		int c=0;
		while (a!=-1) {
			c++;
			a=s1.indexOf(" ",a+1);
		}
		System.out.println("A primeira string tem "+c+" espacos.");
		a=s2.indexOf(" ");
		c=0;
		while (a!=-1) {
			c++;
			a=s2.indexOf(" ",a+1);
		}
		System.out.println("A segunda string tem "+c+" espacos.");
		System.in.read();
	}
}

