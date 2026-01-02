//Introdução à classe String
//
//Exemplos de situações "estranhas" 
//para utilizadores de outras linguagens
//de programação
//
class TesteStrings{
	public static void main(String args[]) throws java.io.IOException
	{
		
		//Inicialização de variáveis
		String a="Teste";
		String b="Tes";
		String c="te";
		String d="Tes"+"te";
		String e=a;
		String f=b+c;

		System.out.println("a=\"Teste\"");
		System.out.println("b=\"Tes\"");
		System.out.println("c=\"te\"");
		System.out.println("d=\"Tes\"+\"te\"");
		System.out.println("e=a");
		System.out.println("f=b+c");
		System.out.println("");
		//nota: a sequência \" é convertida para um caracter
		//aspas pelo Java
		
		//a e e referenciam o mesmo objecto
		System.out.print("a==e? ");
		System.out.println(a==e); 
		//nota: o parâmetro de println tem de ser uma String,
		//mas o Java converte automaticamente o boolean resultante
		//da comparação a==e numa String com conteúdo "true" ou
		//"false"

		//a e f referenciam objectos diferentes como tal
		//não são iguais! Embora tenham o mesmo conteúdo
		//em termos de caracteres
		System.out.print("a==f? ");
		System.out.println(a==f); 

		//temos que usar o método .equals para 
		//comparar o conteúdo dos objectos
		System.out.print("a.equals(f)? ");
		System.out.println(a.equals(f)); 

		//No entanto... as constantes tem
		//um comportamento estranho:
		System.out.print("a==\"Teste\"?");
		System.out.println(a=="Teste"); 
		//O que se passa é que o java cria 
		//apenas um objecto com a String "Teste"
		//e depois utiliza-o sempre que é necessária
		//a String
		System.out.print("d==(\"Tes\"+\"te\")?");
		System.out.println(d==("Tes"+"te")); 
		System.out.print("a==d?");
		System.out.println(a==d); 
		
		System.in.read();
	}
}

