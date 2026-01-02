package telejogo4;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;


public class MaquinaJogo extends Canvas implements Runnable {

/* Propriedades gerais */

  public static final int VAZIO = 0;
  public static final int PRIMEIRO = 1;
  public static final int FECHADO = 1;
  public static final int PAREDAO = 2;
  public static final int TENIS = 3;
  public static final int FUTEBOL = 4;
  public static final int ULTIMO = 4;

  private boolean poeTudo = false;  // Quando muda o jogo, tem que por tudo
  private boolean pare = false;     // Usado como sinalizacao para parar a simulacao
  private Thread maquina;           // Maquina de simulacao

  private Vector vFundo = new Vector();  // Lista de objetos de fundo
  private Vector vParado = new Vector();  // Lista de objetos parados
  private Vector vAnimado = new Vector();  // Lista de objetos animados

  private int jogoAtual;	// Tipo de jogo selecionado
  private Jogo jogo;		// Objeto do jogo atual

  private boolean parado = true;	// Indica se o jogo selecionado esta parado ou nao


  private JogoFechado fechado;
  private JogoParedao paredao;
  private JogoTenis tenis;
  private JogoFutebol futebol;


/* Propriedades associadas com o desenho */

  private Image    fixaImagem;   // Contem os elementos fundo e parado
  private Graphics fixoG;

  private Image    novaImagem;   // Contem todos os elementos
  private Graphics novoG;

  private int      wTotal;       // Total width of the game
  private int      hTotal;       // Total height of the game

/* Metodos */

  public MaquinaJogo( Label p) {
    super();
    setBackground( Color.white );

    fechado = new JogoFechado();
    fechado.setPlacar(p);

    paredao = new JogoParedao();
    paredao.setPlacar(p);

    tenis = new JogoTenis();
    tenis.setPlacar(p);

    futebol = new JogoFutebol();
    futebol.setPlacar(p);

    jogoAtual = VAZIO;
    jogo = null;
  }


  public Vector getParados() {
    return vParado;
  }

  public Vector getAnimados() {
    return vAnimado;
  }


  public void paint( Graphics g){

    //    System.out.println("paint do jogo " + jogoAtual + " parado " + vParado.size() +
    //                   " fundo " + vFundo.size() + " animado " + vAnimado.size() );

    wTotal = getWidth();
    hTotal = getHeight();

    // Vai criar uma imagem fixa
    fixaImagem = createImage( wTotal, hTotal);
    fixoG = fixaImagem.getGraphics();

    //apaga a tela
    fixoG.setColor( jogo.corFundo);
    fixoG.fillRect(0,0,wTotal,hTotal);

    //pinta cada objeto fixo
    for( int i=0; i<vFundo.size(); ++i) {
      ObjetoParado x = (ObjetoParado)vFundo.get(i);
      x.paint(this,fixoG,wTotal,hTotal);
      }
    for( int i=0; i<vParado.size(); ++i) {
      ObjetoParado x = (ObjetoParado)vParado.get(i);
      x.paint(this,fixoG,wTotal,hTotal);
      }

    // Vai desenhar sobre rascunho
    novaImagem = createImage( wTotal, hTotal);
    novoG = novaImagem.getGraphics();
    novoG.drawImage( fixaImagem, 0, 0, this);

    //atualiza cada objeto animado
    for( int i=0; i<vAnimado.size(); ++i) {
      ObjetoAnimado x = (ObjetoAnimado)vAnimado.get(i);
      x.paint(this,novoG,wTotal,hTotal);
      }

    g.drawImage( novaImagem, 0, 0, this);

  }



  public void update( Graphics g){

    //System.out.println("update do jogo " + jogoAtual);

    if( poeTudo ){
      poeTudo = false;
      paint( g);
      }
    else {
      // Vai desenhar sobre rascunho - Forma alternativa: novoG.drawImage( fixaImagem, 0, 0, this);

      //apaga a tela
      novoG.setColor( jogo.corFundo);
      novoG.fillRect(0,0,wTotal,hTotal);

      //pinta cada objeto fixo
      for( int i=0; i<vFundo.size(); ++i) {
        ObjetoParado x = (ObjetoParado)vFundo.get(i);
        x.paint(this,novoG,wTotal,hTotal);
        }
      for( int i=0; i<vParado.size(); ++i) {
        ObjetoParado x = (ObjetoParado)vParado.get(i);
        x.paint(this,novoG,wTotal,hTotal);
        }
     
      //atualiza cada objeto animado
      for( int i=0; i<vAnimado.size(); ++i) {
        ObjetoAnimado x = (ObjetoAnimado)vAnimado.get(i);
        x.paint(this,novoG,wTotal,hTotal);
        }

      g.drawImage( novaImagem, 0, 0, this);

      }
  }


/**  Controle da maquina de simulacao
*/

  public void selecionar( int tipo) {

    if( tipo == jogoAtual )
      return;
   
    if( !parado )
      parar();

    vAnimado.removeAllElements();
    vParado.removeAllElements();
    vFundo.removeAllElements();

    wTotal = getWidth();
    hTotal = getHeight();

    switch( tipo) {
      case MaquinaJogo.FECHADO: jogo = fechado;
                                jogo.criar( vFundo, vParado, vAnimado, wTotal, hTotal);
                                break;
      case MaquinaJogo.PAREDAO: jogo = paredao;
                                jogo.criar( vFundo, vParado, vAnimado, wTotal, hTotal); 
                                break;
      case MaquinaJogo.TENIS: jogo = tenis;
                              jogo.criar( vFundo, vParado, vAnimado, wTotal, hTotal); 
                              break;
      case MaquinaJogo.FUTEBOL: jogo = futebol;
                                jogo.criar( vFundo, vParado, vAnimado, wTotal, hTotal); 
                                break;
      }

    jogo.limpar();

  poeTudo = true;


  }



  public void iniciar() {
    jogo.iniciar();
    addMouseMotionListener( jogo);
    addKeyListener( jogo);
    parado = false;
    maquina = new Thread( this);
    maquina.start();
  }


  public void parar() {
    pare = true;
    removeMouseMotionListener( jogo);
    removeKeyListener( jogo);
    try{ maquina.join();
         System.out.println("maquina morreu");
         }
      catch( InterruptedException e ){ }
    parado = true;
  }




/** Maquina de simulacao implementada como uma thread separada
*/

  public void run(){
    long t1, t2, tx;
    Thread.currentThread().setPriority( Thread.MIN_PRIORITY);
    requestFocus();
    System.out.println("Maquina nasceu");
    t1 = System.currentTimeMillis();

    while( !pare ){
      if( wTotal > jogo.minW  &&  hTotal > jogo.minH ) {
        //atualiza simulacao
        for( int i=0; i<vAnimado.size(); ++i) {
          ObjetoAnimado x = (ObjetoAnimado)vAnimado.get(i);
          x.tick( this, jogo);
        }
        //atualiza tela
        repaint();
      }
      //dorme um tempo
      try{ 
        t2 = t1 + jogo.tamTick;
        tx = System.currentTimeMillis();
        if( t2 > tx ) Thread.sleep( t2 - tx );
        System.out.println( t2-tx );
        t1 = t2;
      }catch (InterruptedException e){}
    }

    // No fim do metodo "run" a thread vai morrer
    pare = false;
  }



}//class
