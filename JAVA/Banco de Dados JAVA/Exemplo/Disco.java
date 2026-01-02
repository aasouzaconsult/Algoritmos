import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Disco extends Frame implements ActionListener, ItemListener{
   private Choice choiceGrupo;
   private Choice choiceDisco;
   private Label labelGrupo;
   private Label labelDisco;
   private Label labelMusica;
   private List listMusicas;
   private Connection con;
   private MenuBar   menubar;
   private Menu      menu;
   private MenuItem  mcons;
   private MenuItem  msair;
   private Button    bc;
   private Dialog    cons;

/**
Metodo: Disco
Funcao: Construtor que cria componentes da interface grafica
**/

  public Disco() {
    //seta configuracoes do frame principal
    super("JDBC - Controle de uma Discoteca");
    setLayout(null);
    setSize(610,450);

    //criacao dos componentes
    menubar = new MenuBar();
    setMenuBar(menubar);

    menu = new Menu("Discos");
    menubar.add(menu);

    mcons = new MenuItem("Consultar...");
    msair = new MenuItem("Sair");

    //adiciona itens de menu ao menu Arquivo
    menu.add(mcons);
    menu.add(msair);

    //define que eventos do menu serao tratados em actionPerformed
    mcons.addActionListener(this);
    msair.addActionListener(this);

    //define que eventos de janela serao tratados em windowPerformed
    addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e){
           System.exit(0);}
    });
 }

/**
Metodo: Consulta
Funcao: Cria interface grafic da consulta, chama
        metodo que conecta-se ao banco e atualiza
        a combo com grupos existentes
**/

 private void Consulta(){
   cons = new Dialog(this, "Consulta de Discos");
   cons.setLayout(null);
   cons.setSize(370,390);
   cons.setBackground(Color.white);
   cons.setLocation(150, 20);

   labelGrupo = new Label("Grupo:");
   labelGrupo.setBounds(10, 35, 100, 25);
   cons.add(labelGrupo);

   labelDisco = new Label("Discos:");
   labelDisco.setBounds(10, 120, 100, 25);
   cons.add(labelDisco);

   labelMusica = new Label("Músicas:");
   labelMusica.setBounds(10, 200, 100, 25);
   cons.add(labelMusica);

   choiceGrupo = new Choice();
   choiceGrupo.setBounds(10, 70, 280, 25);
   cons.add(choiceGrupo);

   choiceDisco = new Choice();
   choiceDisco.setBounds(10, 150, 280,25);
   cons.add(choiceDisco);

   listMusicas = new List();
   listMusicas.setBounds(10, 230, 280, 80);
   cons.add(listMusicas);

   bc = new Button("Fechar");
   bc.setBounds( 120, 330, 80, 30 );
   cons.add(bc);
   //define que tratamento de evento do botao
   //sera efetuado nesta classe
   bc.addActionListener(this);

   addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e){
           System.exit(0);}
   });
   choiceGrupo.addItemListener(this);
   choiceDisco.addItemListener(this);

   cons.setVisible(true);
   //conecta-se ao banco
   Conecte();
   //busca os grupos, preenchendo o combo de grupo
   Grupo();
}

/**
Metodo: Conecte
Funcao: Conectar-se ao banco
**/

 private void Conecte(){
   try {
     //registra o driver
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     //Cria e estabelece a conexao. Discos: nome da fonte de dados configurada no JDBC
     con = DriverManager.getConnection("jdbc:odbc:Discos", "", "");
    }catch (Exception e){
	System.out.println(e.toString());
	System.exit(0);
  }
}

/**
Metodo: Grupo
Funcao: Consultar nome dos grupos no banco e
        atualizar a comboBox
**/

 private void Grupo(){
    try {
      //Cria um comando
      Statement stmt = con.createStatement();
      //Executa o comando e recebe os resultados
      ResultSet rs = stmt.executeQuery("SELECT DISTINCT GRUPO FROM Discos");
      //processa os resultados
      while (rs.next()){
	choiceGrupo.addItem(rs.getString(1));
      }
      rs.close();
      stmt.close();
      choiceGrupo.select(0);
    }
    catch (Exception e){
      System.out.println(e.toString());
      System.exit(0);
    }
 }

/**
Metodo: Disco
Funcao: Consultar nome dos discos do grupo no banco e
        atualizar a combo
Parametro: String grp com o nome do grupo selecionado
**/

  private void Disco(String grp){

     choiceDisco.removeAll();//limpa combo
     try{
	  //Cria um comando
	  Statement stmt = con.createStatement();
          //Executa o comando e recebe os resultados
	  ResultSet rs = stmt.executeQuery("SELECT t1.NomeCD, t1.Ano FROM Discos t1 WHERE Grupo = '" + grp + "'");
          //pega resultados (Nome do cd e ano )e atualiza na combo
	  while (rs.next()){
   	    choiceDisco.addItem(rs.getString(1)+ " | " +  rs.getString(2));
	  }
	  rs.close();
	  stmt.close();
	}
	catch (Exception e){
          System.out.println(e.toString());
	  System.exit(0);
	}
}

/**
Metodo: Musicas
Funcao: Consultar nome dos grupos no banco e
        atualizar a combo
Parametro: String disco com o nome do disco selecionado
**/
  private void Musicas( String disco ){

    //elimina o ano do nome do disco
    int i = 0;
    String str = new String();
    while ( disco.charAt(i+1) != '|')
          str += disco.charAt(i++);
    //limpa lista de musicas
    listMusicas.removeAll();
    try	{
       	//Cria um comando
       	Statement stmt = con.createStatement();
       	//Executa o comando e recebe os resultados
       	ResultSet rs = stmt.executeQuery("SELECT  t1.NomeMusica, t1.Faixa FROM Musicas t1, Discos t2 WHERE t2.CodigoDisco = t1.CodigoMusica and t2.NOMECD = '" + str + "'");
       	//pega resultados ( nome da musica e faixa ) e atualiza na lista de musicas. rs.next() para posicionar cursor nos registros do resultado
       	while (rs.next()){
  	  listMusicas.add(rs.getString(1)+ " - " +  rs.getString(2));
	}
	rs.close();
	stmt.close();
    }
    catch (Exception e)	{
       System.out.println(e.toString());
       System.exit(0);
    }
 }

/**
Metodo: actionPerformed
Funcao: Verifica qual evento de açao ocorreu
         e direciona para o metodo de tratamento
**/

  public void actionPerformed(ActionEvent e){
    if (e.getSource() == mcons){
        Consulta();
    }
    else if (e.getSource() == msair){
           Sair();
    }
    else if (e.getSource() == bc){
            cons.setVisible(false);
            cons.dispose();
            cons = null;
    }
}

/**
Metodo: Sair
Funcao: Fecha aplicação e sai
**/

  public void Sair(){
    this.dispose();
    System.exit(0);
  }

/**
Metodo: itemStateChanged
Funcao: Verifica qual item esta selecionado nas combos
        e direciona para o metodo apropriado
**/

  public void itemStateChanged(ItemEvent e){
    if (e.getSource() == choiceGrupo )
       Disco(choiceGrupo.getSelectedItem());
    else if (e.getSource() == choiceDisco )
	    Musicas(choiceDisco.getSelectedItem());
  }

//****************************************************

  public static void main(String args[]){
    Disco app = new Disco();
    app.setVisible(true);
  }
}
