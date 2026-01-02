// DatabaseTeste.java

import java.net.*;
import java.sql.*;
import javax.swing.*;

public class DatabaseTeste
{
    public static void main(String args[])
    {
        java.sql.Connection conn = null;
        String dburl = "jdbc:mysql://localhost/curso?user=root&password=";
        String sql_str = "SELECT * FROM usuarios";
        JTextArea text = new JTextArea();
        try
        {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            conn = DriverManager.getConnection(dburl);
            Statement sq_stmt = conn.createStatement();
            ResultSet rs = sq_stmt.executeQuery(sql_str);
         
            while (rs.next())
            {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");

                text.append("ID:" + id + "\n");
                text.append("Nome: " + nome + "\n");
                text.append("Endereco: " + endereco + "\n");
            }
        }
        catch (Exception e)
        {
            System.out.println("Erro: " + e);
        }
        JOptionPane.showMessageDialog(null, text, "teste", JOptionPane.PLAIN_MESSAGE);

    }
}

