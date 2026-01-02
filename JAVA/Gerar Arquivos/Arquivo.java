import java.io.*;
class FileOutputDemo
{
	public static void main (String args[] )
	{
		FileOutputStream out; 
		PrintStream p;           
		try
		{
			// Cria um novo file output stream 
			// conecta ao arquivo chamado "arq.txt"
						
			out = new FileOutputStream ( "alex.doc");
		
			// conecta o print stream ao output stream
			
			p   = new  PrintStream ( out );
			
			for ( int i = 0;  i <= 20; i++ )
			{
				p.println (" **** Antonio Alex de Souza ******");
				p.println (" ************"+i+"****************");
				p.println ("   Teste de Criação de Arquivos ");
				p.println ("    ");
			}
			p.close();
		}
		catch (Exception e )
		{
			System.err.println(  e );
		}
	}
}