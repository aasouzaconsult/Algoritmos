package telejogo4;

import java.awt.*;

abstract public class ObjetoAnimado extends ObjetoSimulado {

  abstract public void paint( MaquinaJogo mj, java.awt.Graphics g, int wTotal, int hTotal );

  abstract public void tick( MaquinaJogo mj, Jogo j);

  public double efeito(int bolaY){
    return 0.0;
  }

}
