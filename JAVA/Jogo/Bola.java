package telejogo4;

import java.awt.*;
import java.util.*;

public class Bola extends ObjetoAnimado {

  protected final String tipo = "bola";

  private int diameter = 20;

  private int posX;
  private int posY;
  private int velX;
  private int velY;

  private int minVelX;
  private int maxVelX;
  private int minVelY;
  private int maxVelY;

  private int inicialPosX;
  private int inicialPosY;
  private int inicialVelX;
  private int inicialVelY;

  private Color cor = Color.red;


/* Construtores */

  public Bola( int x, int y, int d, int v, Color c) {
    posX = inicialPosX = x;
    posY = inicialPosY = y;
    diameter = d;
    velX = velY = inicialVelX = inicialVelY = v;
    cor = c;
    minVelX = minVelY = v;
    maxVelX = maxVelY = 2*v;
   }

  public Bola( int x, int y,  int d, int v) {
    posX = inicialPosX = x;
    posY = inicialPosY = y;
    diameter = d;
    velX = velY = inicialVelX = inicialVelY = v;
    minVelX = minVelY = v;
    maxVelX = maxVelY = 2*v;
   }

  public Rectangle toRectangle() {
    return new Rectangle( posX, posY, diameter, diameter);
  }

  public void paint( MaquinaJogo j, Graphics g, int wTotal, int hTotal ) {
    if( !isVisible() ) return;
    g.setColor( cor);
    g.fillOval( posX, posY, diameter, diameter);
  }


  public void tick( MaquinaJogo mj, Jogo j){
    boolean colisaoX = false;
    boolean colisaoY = false;

    // Calcula a nova velocidade
    if( velX > minVelX ) --velX;
    else if( velX < -minVelX) ++velX;

    if( velY > minVelY ) --velY;
    else if( velY < -minVelY) ++velY;

    // Calcula a nova posicao
    int x = posX + velX;
    int y = posY + velY;
    Rectangle novoX = new Rectangle( x, posY, diameter, diameter);
    Rectangle novoY = new Rectangle( posX, y, diameter, diameter);
   
    // Verifica consistencia com relacao ao Jogo j, objetos parados
    Vector v = mj.getParados();
    for( int i=0; i<v.size(); ++i) {
      ObjetoParado op = (ObjetoParado)v.get(i);
      if( !colisaoX )
        if( novoX.intersects( op.toRectangle() ) )
          colisaoX = true;
      if( !colisaoY )
        if( novoY.intersects( op.toRectangle() ) )
          colisaoY = true;

      if( colisaoX && colisaoY )  break;
    }

    // Verifica consistencia com relacao ao Jogo j, objetos animados
    double efeito = 0.0;
    v = mj.getAnimados();
    for( int i=0; i<v.size(); ++i) {
      ObjetoAnimado op = (ObjetoAnimado)v.get(i);
      if( op == this ) continue;
      if( !colisaoX )
        if( novoX.intersects( op.toRectangle() ) ) {
          colisaoX = true;
          efeito += op.efeito(y+diameter/2);
          }
      if( !colisaoY )
        if( novoY.intersects( op.toRectangle() ) ) {
          colisaoY = true;
          }

      if( colisaoX && colisaoY )  break;
    }
    
   // Corrige a posicao e estado
    if( colisaoX ) {
      show("Colisao X " + efeito); 
      // velX = -1 * velX; sem alteracao de velocidade
      velX = maxVelX * ( -1 * velX / Math.abs(velX) );
      velY = velY + (int)(efeito * maxVelY);
      x = posX;
    }

    if( colisaoY ) {
      show("Colisao Y "); 
      // velY = -1 * velY; sem alteracao de velocidade
      velY = maxVelY * ( -1 * velY / Math.abs(velY) );
      y = posY;
    }

    // Assume posicao definitiva neste quadro
    posX = x;
    posY = y;

    // No futuro poderah tambem gerar eventos e registra-los com outros objetos
    if( posX < 0  ||  posX > mj.getWidth()  ||  posY < 0  ||  posY > mj.getHeight() ) {
      j.ponto( posX, posY);
      posX = inicialPosX;
      posY = inicialPosY;
      velX = inicialVelX;
      velY = inicialVelY;
    } 
  }

}

