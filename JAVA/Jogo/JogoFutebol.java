package telejogo4;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;


public class JogoFutebol extends Jogo
                  implements MouseMotionListener, KeyListener {

  protected int tamGol = 200;
  protected int tamBorda = 10;

  protected int pontosEsq, pontosDir;
  protected Raquete jogadorEsq, jogadorDir;


  public void criar( Vector vFundo, Vector vParado, Vector vAnimado, int w, int h) {
    vParado.addElement( new Borda( Borda.SUP) );
    vParado.addElement( new Borda( Borda.INF) );

    vParado.addElement( new Parede( 0, 0, 10, (h-tamGol)/2 ) );  // esquerda sup
    vParado.addElement( new Parede( 0, ((h-tamGol)/2)+tamGol, tamBorda, (h-tamGol)/2 ) );  // esquerda inf
    vParado.addElement( new Parede( 0+w-tamBorda, 0, tamBorda, (h-tamGol)/2 ) );  // direita sup
    vParado.addElement( new Parede( 0+w-tamBorda, ((h-tamGol)/2)+tamGol, tamBorda, (h-tamGol)/2 ) );  // direita inf

    vAnimado.addElement( new VaiVem( w/4-10, h/3-10, 40, 40) );
    vAnimado.addElement( new VaiVem( w/4-10, 2*h/3-10, 40, 40) );
    vAnimado.addElement( new VaiVem( 2*w/4-10, h/3-10, 40, 40) );
    vAnimado.addElement( new VaiVem( 2*w/4-10, 2*h/3-10, 40, 40) );
    vAnimado.addElement( new VaiVem( 3*w/4-10, h/3-10, 40, 40) );
    vAnimado.addElement( new VaiVem( 3*w/4-10, 2*h/3-10, 40, 40) );

    vAnimado.addElement( jogadorEsq = new Raquete( 10, h/2, 20, h-10, Color.blue) );
    vAnimado.addElement( jogadorDir = new Raquete( w-20, h/2, 20, h-10, Color.blue) );
 
    vAnimado.addElement( new Bola( 10, 10, 20, 12) );

  }


  public void iniciar() {
    pontosEsq = 0;
    pontosDir = 0;
    placar.setText("Futebol - Esquerda: " + pontosEsq + "   Direita: " + pontosDir);
    placar.repaint();
  }


  public void parar() {
  }


  public void limpar() {
  }


  public void ponto( int x, int y) {
    if( x < 0 )
      ++pontosDir;
    else
      ++pontosEsq;
    placar.setText("Tenis - Esquerda: " + pontosEsq + "   Direita: " + pontosDir);
    placar.repaint();
  }


  /** Methods of the KeyListener interface
  */

  public void keyTyped( KeyEvent evt) {
    switch( evt.getKeyChar() ) {
      case 'q': jogadorEsq.setAtitude( Raquete.SOBE );
                break;
      case 'z': jogadorEsq.setAtitude( Raquete.DESCE );
                break;
      case 'a': jogadorEsq.setAtitude( Raquete.PARADO );
                break;
      case 'u': jogadorDir.setAtitude( Raquete.SOBE );
                break;
      case 'm': jogadorDir.setAtitude( Raquete.DESCE );
                break;
      case 'j': jogadorDir.setAtitude( Raquete.PARADO );
                break;
      default:  break;
    }
  }


}//class
