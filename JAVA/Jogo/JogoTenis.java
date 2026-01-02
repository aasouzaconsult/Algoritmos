package telejogo4;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;


public class JogoTenis extends Jogo
                  implements MouseMotionListener, KeyListener {

  protected int tamBorda = 10;

  protected int pontosEsq, pontosDir;
  protected Raquete jogadorEsq, jogadorDir;



  public void criar( Vector vFundo, Vector vParado, Vector vAnimado, int w, int h) {

    vFundo.addElement( new Parede( (w-tamBorda)/2, 0, tamBorda, ObjetoParado.TOTAL, Color.red) ); // meio do campo

    vParado.addElement( new Borda( Borda.SUP, Color.yellow) );
    vParado.addElement( new Borda( Borda.INF, Color.yellow) );

    vAnimado.addElement( jogadorEsq = new Raquete( 10, h/2, 20, h-10, Color.blue) );
    vAnimado.addElement( jogadorDir = new Raquete( w-20, h/2, 20, h-10, Color.blue) );
 
    vAnimado.addElement( new Bola( 10, 10, 20, 12) );

  }


  public void iniciar() {
    pontosEsq = 0;
    pontosDir = 0;
    placar.setText("Tenis - Esquerda: " + pontosEsq + "   Direita: " + pontosDir);
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

