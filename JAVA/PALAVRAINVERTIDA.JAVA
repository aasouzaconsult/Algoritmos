public class PalavraInvertida{
	private static String palavra;
	
	public static void main(String args[]){
		if(args.length < 1){
			System.out.println("Informe a palavra na linha de comando.");
			System.exit(0);
		}
		else{
			palavra = args[0];
			
			for(int i = palavra.length() - 1; i >= 0; i--)
			   System.out.print(palavra.charAt(i)); 
			
			System.exit(0);
		}
	}
}