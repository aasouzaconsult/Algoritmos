package telejogo4;

import java.awt.*;

public class VaiVem extends ObjetoAnimado {

  static public int velocidadeDefault = 1;
  static public int sizeDefault = 10;
  static public Color corDefault = Color.black;

  protected final String tipo = "vaivem";

  private int xi;
  private int yi;
  private int xf;
  private int yf;
  private boolean indo;

  private int size;
  private int velocidade;
  private Color cor;

  private int x;
  private int y;

/* Construtores */

  public VaiVem( int x1, int y1, int dx, int dy, int s, Color c) {
    xi = x1;
    yi = y1;
    xf = x1+dx;
    yf = y1+dy;

    size = s;
    velocidade = velocidadeDefault;
    cor = c;

    x = xi;  y = yi;  indo = true;
   }

  public VaiVem( int x1, int y1, int dx, int dy, int s) {
    xi = x1;
    yi = y1;
    xf = x1+dx;
    yf = y1+dy;

    size = s;
    velocidade = velocidadeDefault;
    cor = corDefault;

    x = xi;  y = yi;  indo = true;
   }

  public VaiVem( int x1, int y1, int dx, int dy, String n) {
    xi = x1;
    yi = y1;
    xf = x1+dx;
    yf = y1+dy;
    setNome(n); 

    size = sizeDefault;
    velocidade = velocidadeDefault;
    cor = corDefault;

    x = xi;  y = yi;  indo = true;
   }

  public VaiVem( int x1, int y1, int dx, int dy) {
    xi = x1;
    yi = y1;
    xf = x1+dx;
    yf = y1+dy;

    size = sizeDefault;
    velocidade = velocidadeDefault;
    cor = corDefault;

    x = xi;  y = yi;  indo = true;
   }

  public Rectangle toRectangle() {
    return new Rectangle( x, y, size, size);
  }

  public int getVelocidade() {
    return velocidade;
  }

  public void setVelocidade( int v) {
    velocidade = v;
  }

  public int getSize() {
    return size;
  }

  public void setSize( int s) {
    size = s;
  }

  public void paint( MaquinaJogo j, Graphics g, int wTotal, int hTotal ) {
    if( !visible ) return;
    g.setColor( cor);
    g.fillRect( x, y, size, size);
  }


  public void tick( MaquinaJogo mj, Jogo j){
    // Calcula nova posicao e estado
    // Verifica consistencia com relacao ao Jogo j
    // Corrige a posicao e estado
    // No futuro poderah tambem gerar eventos e registra-los com outros objetos

    //show("tick " + tipo + " " + nome );
    if( indo ) {
      x = x + velocidade;
      y = y + velocidade;
      if( x >= xf  &&  y >= yf ) indo = false;
    } else {
      x = x - velocidade;
      y = y - velocidade;
      if( x <= xi  &&  y <= yi ) indo = true;
    }

  }

}

