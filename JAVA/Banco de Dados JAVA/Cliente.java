/*
 * Cliente.java
 * Created on November 7, 2004, 00:56 AM
 * @author  Antonio Alex
 */

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.text.*;
import java.sql.*;

public class Cliente extends JFrame implements ActionListener {
    
    // Criando os Labels
    JLabel lb_nome, lb_end, lb_cep, lb_bairro, lb_cidade, lb_rg, lb_cpf,
    lb_nasc, lb_fone, lb_email;
    
    // Criando os TextField
    JTextField tf_nome, tf_end, tf_bairro, tf_cidade, tf_rg, tf_email;

	// Criando ComboBox
	JComboBox cb_estado;
	String[] estados = { "Ceará","Acre", "Alagoas", "Amapá", "Amazonas", 
	"Bahia", "Distrito Federal","Espirito Santo", "Goias", "Maranhão",
	"Mato Grosso", "Mato G.Sul", "Minas Gerais", "Pará", "Paraiba", 
	"Paraná", "Pernambuco", "Piaui", "Rio de Janeiro", "Rio G.Norte",
	"Rio G. Sul", "Rondonia", "Roraima", "Santa Catarina", 
	"Sao Paulo", "Sergipe", "Tocantins" };
        
    JButton bt_Ok, bt_Cancela, bt_Limpa, bt_Sair, bt_Proximo, bt_Adiciona;
    JButton bt_Remove, bt_Inicio;
    
    JPanel painelPrincipal;
        
    MaskFormatter telefone, cep, rg, cpf, nasc;
    JFormattedTextField m_fone, m_cep, m_rg, m_cpf, m_nasc;
    
    // Criando ImageIcon
    private ImageIcon icone;
    
    // Variavies para o Banco de Dados
    private Connection con;
	private Statement stmt;
    private ResultSet rs;
       
    public Cliente (String titulo)
    {
        super(titulo);
        iniciaComponentes();
        
        //Adiciona o icone a janela
		icone = new ImageIcon("SuperJava.gif");
		icone.setImage(icone.getImage().getScaledInstance(30, 18, 500));
		setIconImage(icone.getImage());
		
		ConeccaoDB();
		DadosDB();
    }
    
    private void iniciaComponentes()
    {
        // Instanciando Label´s e TextField´s
        lb_nome = new JLabel("Nome");
        tf_nome = new JTextField();
        lb_end = new JLabel("Endereco");
        tf_end = new JTextField();
        lb_cep = new JLabel("Cep");
        lb_bairro = new JLabel("Bairro");
        tf_bairro = new JTextField();
        lb_cidade = new JLabel("Cidade");
        tf_cidade = new JTextField();
        cb_estado = new JComboBox();
        lb_rg = new JLabel("RG");
        lb_cpf = new JLabel("CPF");
        lb_nasc = new JLabel ("Nasc.:");
        lb_fone = new JLabel("Telefone");
        lb_email = new JLabel("E-mail");
        tf_email = new JTextField();
               
        try{
            telefone = new MaskFormatter("(##) ####-####");
            telefone.setPlaceholderCharacter('_');
            cep = new MaskFormatter("#####-###");
      		cep.setPlaceholderCharacter('_');
      		rg = new MaskFormatter("###.###.###-##");
      		rg.setPlaceholderCharacter('_');
      		cpf = new MaskFormatter("###.###.###-##");
      		cpf.setPlaceholderCharacter('_');
      		nasc = new MaskFormatter("##/##/####");
      		nasc.setPlaceholderCharacter('_');
        }
        catch(ParseException excp){
            // caso alguma excecao ocorra
        }
        
        m_fone = new JFormattedTextField(telefone);
        m_cep = new JFormattedTextField(cep); 
        m_rg = new JFormattedTextField(rg);
        m_cpf = new JFormattedTextField(cpf);
        m_nasc = new JFormattedTextField(nasc);
               
        // Instanciando Botoes
        bt_Ok = new JButton("OK");
        bt_Cancela = new JButton("Cancelar");
        bt_Limpa = new JButton("Limpar");
        bt_Sair = new JButton("Sair");
    	bt_Proximo = new JButton("Proximo");
    	bt_Adiciona = new JButton("Adiciona");
    	bt_Remove = new JButton("Remove");
    	bt_Inicio = new JButton("Inicio");
        
        painelPrincipal = new JPanel();
        
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                sai();
            }
        }
        );
        
        //addWindowListener(this);
        bt_Ok.addActionListener(this);
        bt_Cancela.addActionListener(this);
        bt_Limpa.addActionListener(this);
  		bt_Sair.addActionListener(this);
    	bt_Proximo.addActionListener(this);
    	bt_Adiciona.addActionListener(this);
    	bt_Remove.addActionListener(this);
    	bt_Inicio.addActionListener(this);
        
        painelPrincipal.setLayout(null);
        
        // Montando a Tela
        
        // Nome
        lb_nome.setBounds(10,8,60,30);
        painelPrincipal.add(lb_nome);
        tf_nome.setBounds(80,10,375,25);
        painelPrincipal.add(tf_nome);
        
        // Endereco
        lb_end.setBounds(10,38,60,30);
        painelPrincipal.add(lb_end);
        tf_end.setBounds(80,40,255,25);
        painelPrincipal.add(tf_end);
        
        // Cep
        lb_cep.setBounds(340,38,60,30);
        painelPrincipal.add(lb_cep);
        m_cep.setBounds(380,40,75,25);
        painelPrincipal.add(m_cep);
        
        // Bairro
        lb_bairro.setBounds(10,68,60,30);
        painelPrincipal.add(lb_bairro);
        tf_bairro.setBounds(80,70,100,25);
        painelPrincipal.add(tf_bairro);
        
        // Cidade
        lb_cidade.setBounds(190,68,60,30);
        painelPrincipal.add(lb_cidade);
        tf_cidade.setBounds(235,70,100,25);
        painelPrincipal.add(tf_cidade);
        
        // Estado
        for(int i = 0; i < estados.length; i++) cb_estado.addItem(estados[i]);
        cb_estado.setBounds(340,70,115,25);
        painelPrincipal.add(cb_estado);
        
        // RG
        lb_rg.setBounds(10,98,60,30);
        painelPrincipal.add(lb_rg);
        m_rg.setBounds(80,100,100,25);
        painelPrincipal.add(m_rg);
        
        // CPF
        lb_cpf.setBounds(190,98,60,30);
        painelPrincipal.add(lb_cpf);
        m_cpf.setBounds(235,100,100,25);
        painelPrincipal.add(m_cpf);
        
        // Data Nascimento
        lb_nasc.setBounds(340,98,60,30);
        painelPrincipal.add(lb_nasc);
        m_nasc.setBounds(380,100,75,25);
        painelPrincipal.add(m_nasc);
        
        // Telefone
        lb_fone.setBounds(10,128,60,30);
        painelPrincipal.add(lb_fone);
        m_fone.setBounds(80,130,100,25);
        painelPrincipal.add(m_fone);
        
        // E-mail
        lb_email.setBounds(190,128,60,30);
        painelPrincipal.add(lb_email);
        tf_email.setBounds(235,130,220,25);
        painelPrincipal.add(tf_email);
        
        // Botoes
        bt_Ok.setBounds(10,170,90,25);
        painelPrincipal.add(bt_Ok);
        
        bt_Cancela.setBounds(110,170,90,25);
        painelPrincipal.add(bt_Cancela);
        
        bt_Limpa.setBounds(210,170,90,25);
        painelPrincipal.add(bt_Limpa);
        
        bt_Sair.setBounds(310,170,90,25);
        painelPrincipal.add(bt_Sair);
        
        bt_Proximo.setBounds(10,200,90,25);
        painelPrincipal.add(bt_Proximo);
        
        bt_Adiciona.setBounds(110,200,90,25);
        painelPrincipal.add(bt_Adiciona);
        
        bt_Remove.setBounds(210,200,90,25);
        painelPrincipal.add(bt_Remove);
        
        bt_Inicio.setBounds(310,200,90,25);
        painelPrincipal.add(bt_Inicio);
        
        painelPrincipal.setBackground(Color.LIGHT_GRAY);
        this.getContentPane().add(painelPrincipal);
        painelPrincipal.setPreferredSize(new Dimension(510,250));
                
        pack(); // ?
        
    }
    
    // Método de Limpar dados do Formulario
    public void limparCampos(){
   		tf_nome.setText("");
   		tf_end.setText("");
   		m_cep.setText("");
   		tf_bairro.setText("");
   		tf_cidade.setText("");
   		m_rg.setText("");
   		m_cpf.setText("");
   		m_nasc.setText("");
   		m_fone.setText("");
   		tf_email.setText("");
   		cb_estado.setSelectedIndex(0); 
   		tf_nome.requestFocus();  		
    }
    
    // Método de Sair do Cadastro
    private void sai(){
        System.out.println("Fechando Aplicacao ...");
        System.out.println("Aguarde ...");
        System.exit(0);
    }
    
    //**************************************************************************
    // Conectando Banco de Dados (Estudando ...)
    
    private void ConeccaoDB()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:LocadoraDB", "", "");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	private void DadosDB()
	{
		try
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Cliente");
			rs.next();
            PreencheCampos();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	private void PreencheCampos() // Começa a pegar informações do BD.
	{
        try
	       { 
              tf_nome.setText(rs.getString("Nome"));
		      tf_end.setText(rs.getString("Endereco"));
		   }
        catch (Exception e)
           {
		      System.out.println(e.toString());
		      System.exit(0);
       	   }
    }
    
    public void actionPerformed(java.awt.event.ActionEvent evt)
    {
        String a,b;
        int max;
        
        if (evt.getSource()==bt_Ok)
        {
            System.out.println(" ** Dados Registrados **");
            System.out.println("Nome.....: "+tf_nome.getText());
            System.out.println("Endereco.: "+tf_end.getText());
            System.out.println("Cep......: "+m_cep.getText());
            System.out.println("Bairro...: "+tf_bairro.getText());
            System.out.println("Cidade...: "+tf_cidade.getText());
            System.out.println("RG.......: "+m_rg.getText());
            System.out.println("CPF......: "+m_cpf.getText());
            System.out.println("Nasc.....: "+m_nasc.getText());
            System.out.println("Telefone.: "+m_fone.getText());
            System.out.println("E-mail...: "+tf_email.getText());
            
        }else if (evt.getSource()==bt_Cancela){
            sai();
        }
        
        else if (evt.getSource()==bt_Limpa)
        {
        	limparCampos();
        }
        
        else if (evt.getSource() == bt_Sair)
           System.exit(0);
            
        else if (evt.getSource() == bt_Proximo)
           try
           {
              if (rs.next())
              {
                 PreencheCampos();
              }
           }
           catch (Exception f)
           {
			  System.out.println(f.toString());
			  System.exit(0);
		   }
		        
         else if (evt.getSource() == bt_Adiciona)
            try
            {
               stmt = con.createStatement();
               a=tf_nome.getText();
               b=tf_end.getText();
               rs =stmt.executeQuery("SELECT max(Cod_Cliente) FROM Cliente");
               rs.next();
               max=rs.getInt(1);
               max++;
               stmt.executeUpdate("INSERT INTO Cliente VALUES ("+max+",'"+a+"','"+b+"')");
               rs = stmt.executeQuery("SELECT * FROM Cliente");
		       rs.next();
               PreencheCampos();
               limparCampos();
            }
            catch (SQLException f)
	        {
			   System.out.println(f.toString());
			   System.exit(0);
		    }
		        
         else if (evt.getSource() == bt_Remove) // Funcionando Perfeitamente
            try
            {
               stmt = con.createStatement();
               a=tf_nome.getText();
               rs =stmt.executeQuery("SELECT Cod_Cliente FROM Cliente WHERE Nome='"+a+"'");
               rs.next();
               max=rs.getInt(1);
               stmt.executeUpdate("DELETE FROM Cliente WHERE Cod_Cliente="+max);
               rs = stmt.executeQuery("SELECT * FROM Cliente");
		       rs.next();
               PreencheCampos();
            }
            catch (SQLException f)
		    {
			   System.out.println(f.toString());
			   System.exit(0);
            }
         else if (evt.getSource() == bt_Inicio)
            try
            {
               stmt = con.createStatement();
               rs = stmt.executeQuery("SELECT * FROM Cliente");
		       rs.next();
               PreencheCampos();
            }
            catch (SQLException f)
        	{
		        	System.out.println(f.toString());
			        System.exit(0);
		    }


        }
        
    //Metodos do WindowListener
	public void windowActivated(WindowEvent evt)
	{
	// Comentario
	}

	public void windowDeactivated(WindowEvent evt)
	{
	// Comentario
	}

	public void windowClosing(WindowEvent evt)
	{
        System.exit(0);
	}

	public void windowClosed(WindowEvent evt)
    {
    //Comentario
	}

	public void windowOpened(WindowEvent evt)
	{
	// Comentario
	}

	public void windowIconified(WindowEvent evt)
	{
	// Comentario
	}

	public void windowDeiconified(WindowEvent evt)
	{
	// Comentario
	}
    
    // Fim de Banco de Dados
    //**************************************************************************
    
    public static void main(String args[]){
        Cliente cli = new Cliente("Cadastro de Cliente");
        cli.setVisible(true);
        cli.setResizable(false); // Não dar opcao de Maximizar a tela
    }
}
