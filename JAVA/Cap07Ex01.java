// TESTA CONEXÃO

import java.sql.*;

class Cap07Ex01 {
	
	public static void main (String args[]) {
		try {

		String url = "jdbc:odbc:Empresa";
		String usuario = "";
		String senha = "";
						
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
		Connection con;
		con = DriverManager.getConnection(url,usuario,senha);
			
		System.out.println("Conexão realizada com sucesso.");

		con.close();
		}

		catch(Exception e)
		{
			System.out.println("Problemas na conexão. Verifique a digitação dos nomes e a existência da fonte de dados. \nRecompile e execute novamente.");
		}
	}
}
	