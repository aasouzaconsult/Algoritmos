package telejogo4;

import java.awt.*;

public class Raquete extends ObjetoAnimado {

  static public final int PARADO = 1;
  static public final int SOBE = 2;
  static public final int DESCE = 3;

  protected final String tipo = "raquete";

  private int posX;
  private int posY;
  private int atitude;

  private int minY;
  private int maxY;

  private int largura;
  private int altura;
  private int velocidade;
  private Color cor;

  private int target;

/* Construtores */

  public Raquete( int x, int y) {
    posX = x;
    posY = y;
    atitude = PARADO;
    minY = 0;
    maxY = 100;

    largura = 10;
    altura = 50;
    velocidade = 10;
    cor = Color.black;
    target = posY;
   }

  public Raquete( int x, int y, Color c) {
    posX = x;
    posY = y;
    atitude = PARADO;
    minY = 0;
    maxY = 100;

    largura = 10;
    altura = 50;
    velocidade = 10;
    cor = c;
    target = posY;
   }

  public Raquete( int x, int y, int min, int max, Color c) {
    posX = x;
    posY = y;
    atitude = PARADO;
    minY = min;
    maxY = max;

    largura = 10;
    altura = 50;
    velocidade = 10;
    cor = c;
    target = posY;
   }

  public Raquete( int x, int y, int l, int a, int v, Color c) {
    posX = x;
    posY = y;
    atitude = PARADO;
    minY = 0;
    maxY = 100;

    largura = l;
    altura = a;
    velocidade = 10;
    cor = c;
    target = posY;
   }

  public Rectangle toRectangle() {
    return new Rectangle( posX, posY, largura, altura);
  }

  public int getAtitude() {
    return atitude;
  }

  public void setAtitude( int a) {
    if( a == PARADO )
      target = posY;
    else if( a == SOBE )
      target = minY;
    else if( a == DESCE )
      target = maxY;
  }

  public void setTarget( int y) {
    if( y < minY )
      target = minY;
    else if( y >maxY )
      target = maxY;
    else
      target = y;
  }

  public int getVelocidade() {
    return velocidade;
  }

  public void setVelocidade( int v) {
    velocidade = v;
  }

  public int getAltura() {
    return altura;
  }

  public void setAltura( int a) {
    altura = a;
  }

  public int getLargura() {
    return largura;
  }

  public void setLargura( int l) {
    largura = l;
  }

  public double efeito( int bolaY ) {
    double efeito;
    int m = posY + altura/2;
    efeito = ( 1.0 * (bolaY - m) ) / ( altura/2 );   // Entre -1.0 e 0.0 e +1.0
    return efeito;
  }    

  public void paint( MaquinaJogo mj, Graphics g, int wTotal, int hTotal ) {
    if( !visible ) return;
    g.setColor( cor);
    g.fillRect( posX, posY, largura, altura);
  }


  public void tick( MaquinaJogo mj, Jogo j){
    // Calcula nova posicao e estado
    // Verifica consistencia com relacao ao Jogo j
    // Corrige a posicao e estado
    // No futuro poderah tambem gerar eventos e registra-los com outros objetos

    if( posY < target-altura/2 )
      atitude = DESCE;
    else if( posY > target )
      atitude = SOBE;
    else
      atitude = PARADO;

    switch( atitude ) {
      case PARADO: break;
      case SOBE: posY = posY - velocidade;
                 if( posY <= minY ){
                   posY = minY;
                   atitude = PARADO;
                 }
                 break;  
      case DESCE: posY = posY + velocidade;
                 if( posY >= maxY ){
                   posY = maxY;
                   atitude = PARADO;
                 }
                 break;  
      }
  }

}

