import java.io.*;

public class EntradaConsole{
	public static void main(String args[]){
		InputStreamReader ent = new InputStreamReader(System.in);
		BufferedReader cons = new BufferedReader(ent);
		String nome;
		
		System.out.println("Por favor digite seu nome: ");
		
		try{
		   nome = cons.readLine();
		   System.out.println("Bom dia, " + nome);
	    }
	    catch(IOException ioex){
	       System.out.println("Erro na entrada de dados");
	       System.exit(1);	
	    }
		
		System.exit(0);
	}
}