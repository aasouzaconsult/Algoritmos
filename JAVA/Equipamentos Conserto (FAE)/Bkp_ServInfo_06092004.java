import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ServInfo extends Frame implements WindowListener, ActionListener
{
	private Button btnOk;
    private Button btnSair;
    private Button btnLimpa;
    private Button btnProximo;
    private Button btnAdiciona;
    private Button btnRemove;
    private Button btnInicio;
	private Label lbTitulo;
	private Label lbEquip;
	private Label lbSerie;
	private Label lbModelo;
	private Label lbDefeito;
	private Label lbUsuario;
	private Label lbSetor;
	//private Label lbEscolha;
	private TextField edEquip;
	private TextField edSerie;
	private TextField edModelo;
	private TextField edDefeito;
	private TextField edUsuario;
	private Choice edSetor;
	//private CheckboxGroup edEscolha;
	//private Checkbox edEscolha1;
	//private Checkbox edEscolha2;
	private Canvas cvBarra;
    private Panel pnTitulo;
    private List lstSaida;
	private Connection con;
	private Statement stmt;
    private ResultSet rs;

    ServInfo()
	{
        super(" by Antonio Alex ");

		setLayout(null);
		setSize(700,550);
        setResizable(true);
        setBackground(Color.gray);

		//Criando o Layout da Tela de apresentação

        // (Coluna,linha,largura,Altura )
        pnTitulo = new Panel();
        pnTitulo.setBounds(20,30,650,40);
        pnTitulo.setBackground(Color.yellow);
        add(pnTitulo);

		lbTitulo = new Label("Controle de Materiais - FAE");
        lbTitulo.setBounds(200,30,250,40);
        lbTitulo.setFont(new Font("Courier",Font.BOLD,24));
        pnTitulo.add(lbTitulo);

        cvBarra = new Canvas();
        cvBarra.setBounds(20,295,650,15);
        cvBarra.setBackground(Color.yellow);
        add(cvBarra);

		lbEquip = new Label("Equipamento:");
        lbEquip.setBounds(20,80,85,24);
        lbEquip.setFont(new Font("Times Roman",Font.BOLD,12));
        add(lbEquip);
        
        edEquip = new TextField("");
        edEquip.setBounds(110,80,450,24);
        add(edEquip);

        lbSerie = new Label("Nº Serie:");
        lbSerie.setBounds(20,120,60,24);
        lbSerie.setFont(new Font("Times Roman",Font.BOLD,12));
        add(lbSerie);

        edSerie = new TextField(" ");
        edSerie.setBounds(110,120,200,24);
        add(edSerie);
        
        lbModelo = new Label("Modelo:");
        lbModelo.setBounds(320,120,50,24);
        lbModelo.setFont(new Font("Times Roman",Font.BOLD,12));
        add(lbModelo);

		edModelo = new TextField(" ");
        edModelo.setBounds(370,120,190,24);
        add(edModelo);
        
        lbDefeito = new Label("Defeito:");
        lbDefeito.setBounds(20,160,85,24);
        lbDefeito.setFont(new Font("Times Roman",Font.BOLD,12));
        add(lbDefeito);
        
        edDefeito = new TextField("");
        edDefeito.setBounds(110,160,450,24);
        add(edDefeito);
        
        lbUsuario = new Label("Usuario:");
        lbUsuario.setBounds(20,200,60,24);
        lbUsuario.setFont(new Font("Times Roman",Font.BOLD,12));
        add(lbUsuario);

        edUsuario = new TextField("");
        edUsuario.setBounds(110,200,200,24);
        add(edUsuario);

		lbSetor = new Label("Setor:");
        lbSetor.setBounds(320,200,50,24);
        lbSetor.setFont(new Font("Times Roman",Font.BOLD,12));
        add(lbSetor);
		
		edSetor = new Choice();
        edSetor.setBounds(370,200,190,24);
		edSetor.add("Eng.Produto");
		edSetor.add("Montagem");
		edSetor.add("Hidrômetros");
		edSetor.add("Rec.Humanos");
		edSetor.add("Contabilidade");
		edSetor.add("Qualidade");
	    edSetor.add("Ambulatório");
        add(edSetor);
        
		/* 
		lbEscolha = new Label("Escolha:");
        lbEscolha.setBounds(40,240,60,24);
        lbEscolha.setFont(new Font("Times Roman",Font.BOLD,12));
        add(lbEscolha);
    
	    edEscolha = new CheckboxGroup();
		edEscolha1 = new Checkbox("Masculino",edEscolha,true);
        edEscolha1.setBounds(100,240,90,24);
        add(edEscolha1);
		edEscolha2 = new Checkbox("Feminino",edEscolha,false);
        edEscolha2.setBounds(100,265,90,24);
        add(edEscolha2); 
        */

		btnOk = new Button("Confirma Dados!");
        btnOk.setBounds(550,350,120,40);
        add(btnOk);

        lstSaida = new List();
        lstSaida.setBounds(40,330,500,200);
        add(lstSaida);

        btnSair = new Button("Sair");
        btnSair.setBounds(550,470,120,40);
        add(btnSair);

        btnLimpa = new Button("Limpa Cadastro");
        btnLimpa.setBounds(550,410,120,40);
        add(btnLimpa);

		btnProximo = new Button("Próximo");
        btnProximo.setBounds(200,250,100,30);
        add(btnProximo);

		btnAdiciona = new Button("Adiciona");
        btnAdiciona.setBounds(310,250,100,30);
        add(btnAdiciona);

		btnRemove = new Button("Remove");
        btnRemove.setBounds(420,250,100,30);
        add(btnRemove);

  		btnInicio = new Button("Início");
        btnInicio.setBounds(530,250,100,30);
        add(btnInicio);

		//Adicionador dos botoes superiores da caixa do Frame
		addWindowListener(this);
		btnOk.addActionListener(this);
		btnLimpa.addActionListener(this);
		btnSair.addActionListener(this);
        btnProximo.addActionListener(this);
        btnAdiciona.addActionListener(this);
        btnRemove.addActionListener(this);
        btnInicio.addActionListener(this);


		coneccaoDB();
		dadosDB();

	}
	
	private void coneccaoDB()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:ServInfoDB", "", "");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}

	private void preencheCampos() // Começa a pegar informações do BD.
	{
        try
	{
        edEquip.setText(rs.getString("Equipamento"));
		edSerie.setText(rs.getString("Endereco"));
		edModelo.setText(rs.getString("Modelo"));
		/*
		if (rs.getInt("Escolha") == 1)
        {
           edEscolha2.setState(true);
           edEscolha1.setState(false);
        }
        else
        {
           edEscolha2.setState(false);
           edEscolha1.setState(true);
        }
        */
        
        edSetor.select(rs.getInt("Setor"));
       
        }
           catch (Exception e)
           {
		      System.out.println(e.toString());
		      System.exit(0);
       	   }
        }
	
	private void dadosDB()
	{
		try
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM FichaDB");
			rs.next();
            preencheCampos();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}


        public void actionPerformed(ActionEvent e)
        {
        String a,b, c;
        int d, max;
        if (e.getSource() == btnOk)
        {
          lstSaida.add("Equipamento: "+edEquip.getText());
          lstSaida.add("Endereço: "+edSerie.getText());
          lstSaida.add("Modelo: "+edModelo.getText());
          
          /*
          if (edEscolha1.getState())
            lstSaida.add("Escolha: Opção 1");
          else
            lstSaida.add("Escolha: Opção 2");
            lstSaida.add("Setor: "+edSetor.getSelectedItem());
          */

         }
         
         else if (e.getSource() == btnLimpa)
         {
            LimpaSaida();
            edEquip.requestFocus();

         }
         
         else if (e.getSource() == btnSair)
            System.exit(0);
            
         else if (e.getSource() == btnProximo)
            try
                {
                   if (rs.next())
                   {
                    preencheCampos();
                   }

                }
                catch (Exception f)
		        {
			        System.out.println(f.toString());
			        System.exit(0);
		        }
		        
         else if (e.getSource() == btnAdiciona)
            try
               {
                   stmt = con.createStatement();
                   a=edEquip.getText();
                   b=edSerie.getText();
                   c=edModelo.getText();
                   /*
                   if (edEscolha1.getState())
                     c=0;
                   else
                     c=1;
                   */
                   
                   d=edSetor.getSelectedIndex();
                   rs =stmt.executeQuery("SELECT MAX(CodAluno) FROM fichaDB");
                   rs.next();
                   max=rs.getInt(1);
                   max++;
                   stmt.executeUpdate("INSERT INTO fichaDB VALUES ("+max+",'"+a+"','"+b+"',"+c+","+d+")");
                   //stmt.executeUpdate("INSERT INTO fichaDB VALUES ("+max+",'"+a+"','"+b+"',"+d+")");
                   rs = stmt.executeQuery("SELECT * FROM fichaDB");
		           rs.next();
                   preencheCampos();

                }
                catch (SQLException f)
	          	{
			        System.out.println(f.toString());
			        System.exit(0);
		        }
		        
         else if (e.getSource() == btnRemove)
                try
                {
                   stmt = con.createStatement();
                   a=edEquip.getText();
                   rs =stmt.executeQuery("SELECT CodAluno FROM fichaDB WHERE Equipamento='"+a+"'");
                   rs.next();
                   max=rs.getInt(1);
                   stmt.executeUpdate("DELETE FROM fichaDB WHERE CodAluno="+max);
                   rs = stmt.executeQuery("SELECT * FROM fichaDB");
		           rs.next();
                   preencheCampos();

                }
                catch (SQLException f)
		        {
			       System.out.println(f.toString());
			       System.exit(0);
                }
         else if (e.getSource() == btnInicio)
                try
                {
                   stmt = con.createStatement();
                   rs = stmt.executeQuery("SELECT * FROM fichaDB");
		           rs.next();
                   preencheCampos();
                }
                catch (SQLException f)
        		{
		        	System.out.println(f.toString());
			        System.exit(0);
		        }


        }

	//Metodos do WindowListener
	public void windowActivated(WindowEvent e)
	{
	// Comentario
	}

	public void windowDeactivated(WindowEvent e)
	{
	// Comentario
	}

	public void windowClosing(WindowEvent e)
	{
        System.exit(0);
	}

	public void windowClosed(WindowEvent e)
    {
    //Comentario
	}

	public void windowOpened(WindowEvent e)
	{
	// Comentario
	}

	public void windowIconified(WindowEvent e)
	{
	// Comentario
	}

	public void windowDeiconified(WindowEvent e)
	{
	// Comentario
	}

	private void LimpaSaida()
	{
       edEquip.setText("");
       edSerie.setText("");
       edModelo.setText("");
       //edEscolha1.setState(true);
       edSetor.select(0);
	   lstSaida.removeAll();
	}
	public static void main(String args[])
	{

       ServInfo form = new ServInfo();
	   form.setVisible(true);

    }
}
