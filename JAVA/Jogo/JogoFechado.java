package telejogo4;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;


public class JogoFechado extends Jogo
                  implements MouseMotionListener, KeyListener {

  public void criar(Vector vFundo, Vector vParado, Vector vAnimado, int w, int h) {

    VaiVem y;

    vParado.addElement( new Borda( Borda.SUP, Color.blue) );
    vParado.addElement( new Borda( Borda.INF, Color.blue) );
    vParado.addElement( new Borda( Borda.ESQ, Color.blue) );
    vParado.addElement( new Borda( Borda.DIR, Color.blue) );

    VaiVem.velocidadeDefault = 2;
    VaiVem.sizeDefault = 20;

    vAnimado.addElement( y = new VaiVem( w/4-10, h/3-10, 40, 40) );
    vAnimado.addElement( y = new VaiVem( w/4-10, 2*h/3-10, 40, 40) );
    vAnimado.addElement( y = new VaiVem( 2*w/4-10, h/3-10, 40, 40) );
    vAnimado.addElement( y = new VaiVem( 2*w/4-10, 2*h/3-10, 40, 40) );
    vAnimado.addElement( y = new VaiVem( 3*w/4-10, h/3-10, 40, 40) );
    vAnimado.addElement( y = new VaiVem( 3*w/4-10, 2*h/3-10, 40, 40) );

    vAnimado.addElement( new Bola( 20, 20, 10, 10) );
  }


  public void iniciar() {
    placar.setText("Fechado - Este jogo nao tem placar !!!");
    placar.repaint();
  }


  public void parar() {
  }


  public void limpar() {
  }


}//class
