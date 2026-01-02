/**----------------------------------------------------------------------*/
/** Move uma bola de um lado para outro.                                 */
/** Evita tremido redesenhando somente a parte alterada.                 */
/** Como ainda treme um pouco, a solução é buferização dupla (Bola4).    */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Bola2.java         
// <applet code=Bola3.class width=600 height=200>
// </applet>

import java.awt.*;
import java.applet.*;

public class Bola3 extends Applet implements Runnable {
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
      int xant = x;
      x += dx; 
      if (x > xco + largura - diâmetro) {
        x = xco + largura - diâmetro;
        dx *= -1;
      }
      else if (x < xco) {
        x = xco;  
        dx *= -1;
      }
      if (xant < x) repaint(xant,yco,diâmetro+(x-xant),diâmetro);
      else repaint(x,yco,diâmetro+(xant-x),diâmetro);
      try {tarefa.sleep(100);} 
      catch (InterruptedException e) {}
    }
  }

  public void update(Graphics tela) {
    paint(tela);
  }

  public void paint(Graphics tela) {

    // Desenha retângulo preto onde a bola se desloca  
    tela.setColor(Color.black);
    tela.fillRect(xco,yco,largura,altura);

    // Desenha bola vermelha
    tela.setColor(Color.red);
    tela.fillOval(x,yco,diâmetro,diâmetro);

  }

}
