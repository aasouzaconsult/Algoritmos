// UPDATE

import java.sql.*;

class Cap07Ex05 {
	
	public static void main (String args[]) {
		try {

		String url = "jdbc:odbc:Empresa";
		String usuario = "";
		String senha = "";
						
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
		Connection con;
		con = DriverManager.getConnection(url,usuario,senha);

		Statement st = con.createStatement();
		st.executeUpdate("UPDATE Pedidos SET Valor=40.00 WHERE CodPedido=1001");
		
		System.out.println("Operação realizada com sucesso.");

		st.close();
		con.close();
		}

		catch(Exception e)
		{
			System.out.println("Problemas na conexão. Verifique a digitação dos nomes e a existência da fonte de dados. \nRecompile e execute novamente.");
		}
	}
}
	