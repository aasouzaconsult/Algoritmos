// CREATE TABLE

import java.sql.*;

class Cap07Ex02 {
	
	public static void main (String args[]) {
		try {

		String url = "jdbc:odbc:Empresa";
		String usuario = "";
		String senha = "";
						
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
		Connection con;
		con = DriverManager.getConnection(url,usuario,senha);

		Statement st = con.createStatement();
		st.executeUpdate("CREATE TABLE Pedidos (CodPedido SMALLINT,CodCli SMALLINT,Descricao VARCHAR(50), Valor CURRENCY, DataPedido DATE)");
		
		System.out.println("Tabela criada com sucesso.");

		st.close();
		con.close();
		}

		catch(Exception e)
		{
			System.out.println("Problemas na conexão. Verifique a digitação dos nomes e a existência da fonte de dados. \nRecompile e execute novamente.");
		}
	}
}
	