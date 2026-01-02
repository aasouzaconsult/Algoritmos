package telejogo4;

import java.awt.*;

public class Parede extends ObjetoParado {

  protected final String tipo = "parede";

  private int x = 0;
  private int y = 0;
  private int w = 20;
  private int h = 20;

  private Color cor = Color.black;

  public Parede( int xPos, int yPos, int weigth, int height, Color c) {
    x = xPos;
    y = yPos;
    w = weigth;
    h = height;
    cor = c;
   }

  public Parede( int xPos, int yPos, int weigth, int height) {
    x = xPos;
    y = yPos;
    w = weigth;
    h = height;
   }

  public Rectangle toRectangle() {
    return new Rectangle( x, y, w, h);
  }

  public void paint( MaquinaJogo j, Graphics g, int wTotal, int hTotal ) {
    int w1 = w;
    int h1 = h;

    if( !isVisible() ) return;

    g.setColor( cor);
    if( w1 == TOTAL ) w1 = wTotal;
    if( h1 == TOTAL ) h1 = hTotal;
    g.fillRect( x, y, w1, h1);

    //show("paint " + tipo + " " + nome);

  }

}

