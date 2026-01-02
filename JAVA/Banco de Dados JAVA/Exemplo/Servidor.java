import java.net.*;
import java.io.*;

public class Servidor{
	public static  void main(String[] args) throws IOException{

	ServerSocket serverSocket = null;
	try 
	{
	  serverSocket = new ServerSocket(4445);
	}
	catch (IOException e) 
	{
		System.err.println("O servidor nao pode ouvir a porta");
		System.exit(1);
	}
	
	Socket clientSocket = null;
	try 
	{
	  System.out.println("Servidor esperando conexão!");
	  clientSocket = serverSocket.accept();
	}
	catch (IOException e) 
	{
		System.err.println("A conexao falhou!");
		System.exit(1);
	}

	PrintWriter out = new PrintWriter ( clientSocket.getOutputStream(),true);
	BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	String conteudo;
	while ( (conteudo = in.readLine()) != null){
		System.out.println("Chegou no servidor:   " + conteudo );
		out.println(conteudo);
	}
}
}

