
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class fichaCS extends  Frame implements WindowListener, ActionListener
{
	private Button btnOk;
    private Button btnSair;
    private Button btnLimpa;
    private Button btnProximo;
    private Button btnAdiciona;
    private Button btnRemove;
    private Button btnInicio;
	private Label lbTitulo;
	private Label lbNome;
	private Label lbEndereco;
	private Label lbSexo;
	private Label lbProfissao;
	private TextField edNome;
	private TextField edEndereco;
	private CheckboxGroup edSexo;
	private Checkbox edSexoMasc;
	private Checkbox edSexoFem;
	private Choice edProfissao;
    private Canvas cvBarra;
    private Panel pnTitulo;
    private List lstSaida;
	private Connection con;
	private Statement stmt;
    private ResultSet rs;

    fichaCS()
	
	{
        super("Estudando - Cadastro");

		setLayout(null);
		setSize(700,550);
        setResizable(true);
        setBackground(Color.gray);

		//Criando o Layout da Tela de apresentação

        pnTitulo = new Panel();
        pnTitulo.setBounds(20,30,650,40);
        pnTitulo.setBackground(Color.yellow);
        add(pnTitulo);

		lbTitulo = new Label("Cadastro");
        lbTitulo.setBounds(200,30,250,40);
        lbTitulo.setFont(new Font("Courier",Font.BOLD,24));
        pnTitulo.add(lbTitulo);

        cvBarra = new Canvas();
        cvBarra.setBounds(20,295,650,15);
        cvBarra.setBackground(Color.yellow);
        add(cvBarra);

		lbNome = new Label("Nome:");
        lbNome.setBounds(40,80,50,24);
        lbNome.setFont(new Font("Times Roman",Font.BOLD,12));
        add(lbNome);

        lbEndereco = new Label("Endereço:");
        lbEndereco.setBounds(40,140,60,24);
        lbEndereco.setFont(new Font("Times Roman",Font.BOLD,12));
        add(lbEndereco);

		lbSexo = new Label("Sexo:");
        lbSexo.setBounds(40,200,60,24);
        lbSexo.setFont(new Font("Times Roman",Font.BOLD,12));
        add(lbSexo);

        lbProfissao = new Label("Profissão:");
        lbProfissao.setBounds(250,200,60,24);
        lbProfissao.setFont(new Font("Times Roman",Font.BOLD,12));
        add(lbProfissao);

		edNome = new TextField("");
        edNome.setBounds(100,80,400,24);
        add(edNome);

		edEndereco = new TextField(" ");
        edEndereco.setBounds(100,140,500,24);
        add(edEndereco);

		edSexo = new CheckboxGroup();
		edSexoMasc = new Checkbox("Masculino",edSexo,true);
        edSexoMasc.setBounds(100,200,90,24);
        add(edSexoMasc);
		edSexoFem = new Checkbox("Feminino",edSexo,false);
        edSexoFem.setBounds(100,225,90,24);
        add(edSexoFem);


		edProfissao = new Choice();
        edProfissao.setBounds(315,200,180,24);
		edProfissao.add("Analista de Sistemas");
		edProfissao.add("Administrador de Rede");
		edProfissao.add("Médico");
		edProfissao.add("Fisioterapeuta");
		edProfissao.add("Engenheiro");
		edProfissao.add("Economista");
	    edProfissao.add("Outros");
        add(edProfissao);


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
			con = DriverManager.getConnection("jdbc:odbc:JavafichaDB", "", "");
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
        edNome.setText(rs.getString("Nome"));
		edEndereco.setText(rs.getString("Endereco"));
		if (rs.getInt("Sexo") == 1)
        {
           edSexoFem.setState(true);
           edSexoMasc.setState(false);
        }
        else
        {
           edSexoFem.setState(false);
           edSexoMasc.setState(true);
        }
        
        edProfissao.select(rs.getInt("Profissao"));
       
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
        String a,b;
        int c,d, max;
        if (e.getSource() == btnOk)
        {
          lstSaida.add("Nome: "+edNome.getText());
          lstSaida.add("Endereço: "+edEndereco.getText());
          if (edSexoMasc.getState())
            lstSaida.add("Sexo: Masculino");
          else
            lstSaida.add("Sexo: Feminino");
            lstSaida.add("Profissão: "+edProfissao.getSelectedItem());


         }
         
         else if (e.getSource() == btnLimpa)
         {
            LimpaSaida();
            edNome.requestFocus();

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
                   a=edNome.getText();
                   b=edEndereco.getText();
                   if (edSexoMasc.getState())
                     c=0;
                   else
                     c=1;
                   d=edProfissao.getSelectedIndex();
                   rs =stmt.executeQuery("SELECT MAX(CodAluno) FROM fichaDB");
                   rs.next();
                   max=rs.getInt(1);
                   max++;
                   stmt.executeUpdate("INSERT INTO fichaDB VALUES ("+max+",'"+a+"','"+b+"',"+c+","+d+")");
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
                   a=edNome.getText();
                   rs =stmt.executeQuery("SELECT CodAluno FROM fichaDB WHERE Nome='"+a+"'");
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
       edNome.setText("");
       edEndereco.setText("");
       edSexoMasc.setState(true);
       edProfissao.select(0);
	   lstSaida.removeAll();
	}
	public static void main(String args[])
	{

       fichaCS form = new fichaCS();
	   form.setVisible(true);

    }
}
