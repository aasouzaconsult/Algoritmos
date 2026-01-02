package telejogo4;

import java.awt.*;

public class Borda extends ObjetoParado {

  protected final String tipo = "borda";

  public static final int SUP = 1;
  public static final int INF = 2;
  public static final int ESQ = 3;
  public static final int DIR = 4;

  private int tamBorda = 10;
  private int pos;
  private Color cor = Color.black;

  private int wTotal;
  private int hTotal;

  public Borda( int p) {
    pos = p;
   }

  public Borda( int p, int b) {
    pos = p;
    tamBorda = b;
   }

  public Borda( int p, Color c) {
    pos = p;
    cor = c;
   }

  public Borda( int p, int b, Color c) {
    pos = p;
    tamBorda = b;
    cor = c;
   }

  public Rectangle toRectangle() {
    switch( pos ){
      case SUP: return new Rectangle( 0, 0, wTotal, tamBorda);	// borda superior
      case INF: return new Rectangle( 0, 0+hTotal-tamBorda, wTotal, tamBorda);	// borda inferior
      case ESQ: return new Rectangle( 0, 0, tamBorda, hTotal);	// borda esquerda
      case DIR: return new Rectangle( 0+wTotal-tamBorda, 0, tamBorda, hTotal);	// borda direita
      }
    return null;
  }

  public void paint( MaquinaJogo j, Graphics g, int w, int h ) {
    wTotal = w;
    hTotal = h;

    if( !isVisible() ) return;

    g.setColor( cor);
    switch( pos ){
      case SUP: g.fillRect( 0,         0,            wTotal,             tamBorda);	// borda superior
		break;
      case INF: g.fillRect( 0,         0+hTotal-tamBorda,      wTotal,   tamBorda);	// borda inferior
		break;
      case ESQ: g.fillRect( 0,         0,            tamBorda,           hTotal);      	// borda esquerda
		break;
      case DIR: g.fillRect( 0+wTotal-tamBorda, 0,    tamBorda,           hTotal);	// borda direita
		break;
      }
    // show("paint " + tipo + " " + nome + "pos S/I/E/D " + pos);
  }


}

