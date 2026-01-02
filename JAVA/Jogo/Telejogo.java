package telejogo4;

import java.awt.*;
import java.lang.*;

public class TeleJogo extends Frame {

  private Button botaoFim;
  private Button botaoJogo;
  private Label titulo;
  private MaquinaJogo j;
  private int tipoJogo;
  private String nomeJogo;

  public TeleJogo() {
    super();

    addWindowListener (new java.awt.event.WindowAdapter () {
        public void windowClosing (java.awt.event.WindowEvent evt) {
          System.exit (0);
        }
      }
    );

    setLayout(new BorderLayout() );

    /* Cria um painel para os botoes */
    Panel p = new Panel( new GridLayout(1,2) );
    add ( p, "South");

    /* Coloca o botao de jogo */
    botaoJogo = new Button ();
    botaoJogo.setLabel ("Jogo");
    botaoJogo.setFont (new Font ("Dialog", 0, 14));
    botaoJogo.addActionListener (new java.awt.event.ActionListener () {
      public void actionPerformed (java.awt.event.ActionEvent evt) {

        if( ++tipoJogo > MaquinaJogo.ULTIMO )
          tipoJogo = MaquinaJogo.PRIMEIRO;

        j.parar();

        switch( tipoJogo ){
          case MaquinaJogo.FECHADO: j.selecionar( MaquinaJogo.FECHADO ); nomeJogo = "Campo Fechado";
                             break;
          case MaquinaJogo.PAREDAO: j.selecionar( MaquinaJogo.PAREDAO ); nomeJogo = "Paredao";
                             break;
          case MaquinaJogo.TENIS: j.selecionar( MaquinaJogo.TENIS ); nomeJogo = "Tenis";
                           break;
          case MaquinaJogo.FUTEBOL: j.selecionar( MaquinaJogo.FUTEBOL ); nomeJogo = "Futebol";
                             break;
          }
        titulo.setText("Aqui deveria ser o placar deste jogo");   
        j.iniciar();

        }
      }
    );
    p.add (botaoJogo);


    /* Coloca o botao de fim */
    botaoFim = new java.awt.Button ();
    botaoFim.setLabel ("Fim");
    botaoFim.setFont (new Font ("Dialog", 0, 14));
    botaoFim.addActionListener (new java.awt.event.ActionListener () {
      public void actionPerformed (java.awt.event.ActionEvent evt) {
        System.exit (0);
        }
      }
    );
    p.add (botaoFim);


    /* Coloca o titulo */
    titulo = new Label ();
    titulo.setText ("Inicio");
    titulo.setFont (new java.awt.Font ("Dialog", 0, 18));
    add (titulo, "North");

    /* Coloca o campo de jogo */
    j = new MaquinaJogo( titulo );
    add( j, "Center");

    /* Arruma as coisas */
    setTitle("TeleJogo 0.1");
    setIconImage( null );

    setResizable( false);
    setSize( new Dimension( 800, 600));
    show();

    /* Seleciona jogo inicial */
    j.selecionar( MaquinaJogo.FECHADO );
    tipoJogo = MaquinaJogo.FECHADO;
    nomeJogo = "Campo Fechado";
    j.iniciar();

    }

  public static void main(String[] args) {
    new TeleJogo();
  }


}

