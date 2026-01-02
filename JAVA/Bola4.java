/**----------------------------------------------------------------------*/
/** Move uma bola de um lado para outro.                                 */
/** Usa buferização dupla para evitar os tremidos da tela do applet.     */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Bola3.java         
// <applet code=Bola4.class width=600 height=200>
// </applet>

import java.awt.*;
import java.applet.*;

public class Bola4 extends Applet implements Runnable {
  Thread tarefa;
  final int xco = 40, yco = 40; 
  int x = xco, dx = 4;
  int largura, altura, diâmetro;  
  Image trabalho;
  Graphics fora;

  public void init() {
    trabalho = createImage(getWidth(),getHeight());
    fora = trabalho.getGraphics();
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

  public void destroy() {
    fora.dispose();
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

  public void update(Graphics tela) {
    fora.clearRect(0,0,getWidth(),getHeight());
    paint(tela);
  }

  public void paint(Graphics tela) {

    // Desenha retângulo preto onde a bola se desloca  
    fora.setColor(Color.black);
    fora.fillRect(xco,yco,largura,altura);
  
    // Desenha bola
    fora.setColor(Color.red);
    fora.fillOval(x,yco,diâmetro,diâmetro);

    // Copia desenho para área do applet
    tela.drawImage(trabalho,0,0,this);
  }

}
