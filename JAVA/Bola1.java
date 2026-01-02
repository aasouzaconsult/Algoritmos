/**----------------------------------------------------------------------*/
/** Move uma bola de um lado para outro.                                 */
/** Usa buferização simples para mostrar os tremidos da tela do applet.  */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Bola1.java         
// <applet code=Bola1.class width=600 height=200>
// </applet>

import java.awt.*;
import java.applet.*;

public class Bola1 extends Applet implements Runnable {
  Thread tarefa;
  final int xco = 40, yco = 40;
  int x = xco, dx = 4;
  int largura, altura, diâmetro;  

  public void init() {
    largura  = getWidth() - 2 * xco;
    altura   = getHeight() - 2 * yco;
    diâmetro = altura;
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
      repaint();
      try {tarefa.sleep(100);} 
      catch (InterruptedException e) {}
    }
  }

  public void paint(Graphics g) {
     
    // Desenha retângulo preto onde a bola se desloca  
    g.setColor(Color.black);
    g.fillRect(xco,yco,largura,altura);
  
    // Desenha bola vermelha
    g.setColor(Color.red);
    g.fillOval(x,yco,diâmetro,diâmetro);

  }

}
