package telejogo4;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;


public class JogoParedao extends Jogo
                  implements MouseMotionListener, KeyListener {


  protected Raquete jogador1;
  protected int pontos = 0;

  public void criar( Vector vFundo, Vector vParado, Vector vAnimado, int w, int h){

    vParado.addElement( new Borda( Borda.DIR, Color.yellow) );
    vParado.addElement( new Borda( Borda.SUP, Color.yellow) );
    vParado.addElement( new Borda( Borda.INF, Color.yellow) );

    vAnimado.addElement( jogador1 = new Raquete( 10, h/2, 20, h-10, Color.blue) );
 
    vAnimado.addElement( new Bola( w/2, h/2, 20, 12) );

  }


  public void iniciar() {
    placar.setText("Paredao - " + 0 + " pontos!!!");
    placar.repaint();
  }


  public void parar() {
  }


  public void limpar() {
  }


  public void ponto( int x, int y) {
    ++pontos;
    placar.setText("Paredao - " + pontos + " pontos!!!");
    placar.repaint();
  }


  /** Methods of the MouseMotionListener interface
  */

  public void mouseDragged( MouseEvent evt){
  }

  public void mouseMoved( MouseEvent evt){
    int x = evt.getX();
    int y = evt.getY();
    jogador1.setTarget( y);
  }


  /** Methods of the KeyListener interface
  */

  public void keyPressed(KeyEvent evt) {
  }

  public void keyReleased(KeyEvent evt) {
  }

  public void keyTyped( KeyEvent evt) {
    switch( evt.getKeyChar() ) {
      case 'a': jogador1.setAtitude( Raquete.SOBE );
                break;
      case 'z': jogador1.setAtitude( Raquete.DESCE );
                break;
      case ' ': jogador1.setAtitude( Raquete.PARADO );
                break;
    }
  }




}//class

