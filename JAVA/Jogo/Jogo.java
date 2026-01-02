package telejogo4;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;


abstract public class Jogo implements MouseMotionListener, KeyListener {

/* Propriedades gerais */

  protected int minH = 100;
  protected int minW = 200;

  protected Color corFundo = Color.green;
  protected int tamTick = 200;            // Milisegundos

  protected Label placar;

  protected boolean parado;


/* Construtores */


/* Metodos acessores */

  public Color getCorFundo() {
    return corFundo;
  }

  public int getTamTick() {
    return tamTick;
  }

  public Dimension getMinSize() {
    return new Dimension( minW, minH);
  }

  public Label getPlacar() {
    return placar;
  }

  public void setPlacar(Label p) {
    placar = p;
  }

  public boolean getParado() {
    return parado;
  }


/* Metodos basicos de um jogo */

  abstract public void criar( Vector vFundo, Vector vParado, Vector vAnimado, int w, int h);
  abstract public void iniciar();
  abstract public void parar();
  abstract public void limpar();

  public void ponto( int x, int y) {
  }


  /** Methods of the MouseMotionListener interface
  */

  public void mouseDragged( MouseEvent evt){
  }

  public void mouseMoved( MouseEvent evt){
    int x = evt.getX();
    int y = evt.getY();
    //System.out.println("Mouse moved " + x + " , " + y );
  }


  /** Methods of the KeyListener interface
  */

  public void keyPressed(KeyEvent evt) {
  }

  public void keyReleased(KeyEvent evt) {
  }

  public void keyTyped( KeyEvent evt) {
    switch( evt.getKeyChar() ) {
      case 'a': //System.out.println("a");
                break;
      case 'z': //System.out.println("z");
                break;
      default:  //System.out.println("x");
                break;
    }
  }


}//class
