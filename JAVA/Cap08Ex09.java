// INSERT USANDO A GUI

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.net.URL;
import java.sql.*;
import java.io.*;

public class Cap08Ex09 extends Frame implements ActionListener {


	JLabel l1, l2, l3, l4;
	JTextField c1, c2, c3, c4;
	JButton b1;

	public Cap08Ex09() {

	setLayout(new GridLayout(5,2));
	
	l1 = new JLabel("Código do Cliente: ");
	l2 = new JLabel("Nome do Cliente: ");
	l3 = new JLabel("Telefone: ");
	l4 = new JLabel("Data de Nascimento: ");

	c1 = new JTextField(20);
	c2 = new JTextField(20);
	c3 = new JTextField(20);
	c4 = new JTextField(20);
	
	b1 = new JButton("CADASTRAR");
		
	b1.addActionListener(this);
		
		add(l1);
		add(c1);
		add(l2);
		add(c2);
		add(l3);
		add(c3);
		add(l4);
		add(c4);
		add(b1);
	}
	public void actionPerformed(ActionEvent event) {
		janela ap = new janela();
		ap.sair();
	}
	
	public static void main(String args[])
	throws IOException {
		Cap08Ex09 janela = new Cap08Ex09();
		janela.setTitle("INSERT USANDO A GUI");
		janela.pack();
		janela.show();
	}
	
	class janela {
		janela() {
		}
			public void sair() {
		try
		{
			String url = "jdbc:odbc:Empresa";
			String usuario = "";	
			String senha = "";

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			Connection con;
			con = DriverManager.getConnection(url,usuario,senha);
			
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO Clientes (CodCli, Nome, Telefone, DtNascimento) VALUES ('"+ c1.getText() +"','"+ c2.getText() +"','"+ c3.getText() +"','"+ c4.getText() +"')");

			System.out.println("Operação realizada com sucesso.");
			
			/* No lugar de System.out.println poderiamos usar uma caixa de confirmação para avisar que a operação foi realizada com sucesso. */
			
			st.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}
		System.exit(0);
		}
	}
}