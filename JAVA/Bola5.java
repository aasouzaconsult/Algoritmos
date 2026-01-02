/**----------------------------------------------------------------------*/
/** Move uma bola de um lado para outro.                                 */
/** Evita tremidos usando Swing que usa buffer duplo.                    */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Bola3.java         
// <applet code=Bola5.class width=600 height=200>
// </applet>

import java.awt.*;
import javax.swing.*;

public class Bola5 extends JApplet implements Runnable {
  Thread tarefa;
  final int xco = 40, yco = 40; 
  int x = xco, dx = 4;
  int largura, altura, diâmetro;  
  Bola6 bola;
  Graphics fora;

  public void init() {
    largura  = getWidth() - 2 * xco;
    altura   = getHeight() - 2 * yco;
    diâmetro = altura;
    
    Container c = getContentPane(); 
    c.add(bola = new Bola6(),BorderLayout.CENTER);
  }

  public void start() {
    if (tarefa == null); {
      tarefa = new Thread(this);
      tarefa.start();
    }
  }

  public void stop() {
    tarefa = null;
  }


  public void run() {
    while (tarefa != null) {
      x += dx; 
      if (x > xco + largura - diâmetro) {
        x = xco + largura - diâmetro;
        dx *= -1;
      }
      else if (x < xco) {
        x = xco;  
        dx *= -1;
      }
      bola.repaint();
      try {tarefa.sleep(100);} 
      catch (InterruptedException e) {}
    }
  }

  class Bola6 extends JPanel {
  
     public Bola6() {
      super(null,true);
     }

    public void paintComponent(Graphics g) {

      // Desenha retângulo preto onde a bola se desloca  
      g.setColor(Color.black);
      g.fillRect(xco,yco,largura,altura);
  
      // Desenha bola
      g.setColor(Color.red);
      g.fillOval(x,yco,diâmetro,diâmetro);

    }

  }

}
