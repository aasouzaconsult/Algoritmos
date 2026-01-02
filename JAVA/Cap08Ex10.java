// SELECT USANDO GUI

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;

public class Cap08Ex10 extends JFrame
{
	private Connection con;
	private JTable tabela;
   
   public static void main(String args[])
  {
   JFrame janela = new Cap08Ex10();
   janela.show();
   WindowListener x = new WindowAdapter()
    {
    public void windowClosing(WindowEvent e)
     {
      System.exit(0);
     }
    };
   janela.addWindowListener(x);
  }
  
  public Cap08Ex10() 
   {   
   setTitle( "EMPRESA - TABELA CLIENTES" );
   setSize(400,300);

		String url = "jdbc:odbc:Empresa"; 
		String usuario = "";
		String senha = "";
   try 
	{
    Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
    con = DriverManager.getConnection(url, usuario, senha);
	}
   catch (Exception e) 
	{
     System.out.println("Falha na Conexão");
	}
   buscaTabela();
	}
   private void buscaTabela()
	{
      Statement st;
      ResultSet res;
      try 
       {
	   Vector cabecalho = new Vector();
       Vector linhas = new Vector();
       st = con.createStatement();
       res = st.executeQuery("SELECT * FROM Clientes");
	   res.next();  

       ResultSetMetaData rsmd = res.getMetaData();

       for (int i = 1; i <= rsmd.getColumnCount(); ++i) 
          cabecalho.addElement(rsmd.getColumnName(i));
       do 
        {
        linhas.addElement(proximaLinha(res,rsmd)); 
        } 
       while (res.next());       
 
       tabela = new JTable(linhas,cabecalho);
       JScrollPane scroller = new JScrollPane( tabela );
       getContentPane().add(scroller, BorderLayout.CENTER);
       validate();
       st.close();
       }
   catch (SQLException sqlex) {
   	}
   } 

   private Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd )
   {
    Vector LinhaAtual = new Vector();
    try
    {
    for (int i = 1; i <= rsmd.getColumnCount(); ++i)
     switch(rsmd.getColumnType(i)) 
     {
     case Types.VARCHAR: LinhaAtual.addElement(rs.getString(i));
      break;
     case Types.TIMESTAMP: LinhaAtual.addElement(rs.getDate(i));
      break;
     case Types.NUMERIC: LinhaAtual.addElement(new Long(rs.getLong(i)));
      break;
          }
    }
    catch(SQLException e) {
	}
    return LinhaAtual;
   }
}
