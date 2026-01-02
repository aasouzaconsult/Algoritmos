// SELECT

import java.sql.*;

class Cap07Ex04 {
	
	public static void main (String args[]) {
		try {

		String url = "jdbc:odbc:Empresa";
		String usuario = "";
		String senha = "";
						
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
		Connection con;
		con = DriverManager.getConnection(url,usuario,senha);

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Pedidos");
		
		while (rs.next()){
			System.out.print(rs.getString("CodPedido") + " ");
			System.out.print(rs.getString("CodCli") + " ");
			System.out.print(rs.getString("Descricao") + " ");
			System.out.print(rs.getString("Valor") + " ");
			System.out.println(rs.getString("DataPedido"));
		
		}


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
	