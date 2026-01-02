/**----------------------------------------------------------------------*/
/** Desenha 400 letras de tamanhos e cores aleatórios, limpa a tela,     */
/** e repete tudo novamente.                                             */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Letras4.java 
// <applet code=Letras.class width=500 height=500>
// </applet>

import java.awt.*;
import java.applet.*;

public class Letras extends Applet implements Runnable {
  Thread tarefa;
  Color cor;
  String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  int tique = 0, largura, altura; 

  public void init() {
    largura = getSize().width;
    altura  = getSize().height;
  }

  public void start() {
    if (tarefa == null) {
      tarefa = new Thread (this);
      tarefa.start();
    }
  }

  public void stop() {
    tarefa = null;
  }

  public void run() {
    while(tarefa != null) {
      try {tarefa.sleep(50);}
      catch (Exception e) {}
      repaint();
    }
  }

  public void paint(Graphics g) {

    tique = ++tique % 400;

    int tamanho = (int)(Math.random() * 40) + 10;

    int red   = (int) (Math.random() * 255);
    int green = (int) (Math.random() * 255);
    int blue  = (int) (Math.random() * 255);
    cor = new Color(red,green,blue);
    g.setColor(cor);

    int x = (int) (Math.random() * largura);
    int y = (int) (Math.random() * altura);

    int letra = (int) (Math.random() * 26);
    String s = alfabeto.substring(letra,letra+1);

    g.setFont(new Font("TimesRoman",Font.PLAIN,tamanho));
    g.drawString(s,x,y);
  }
 
  public void update(Graphics g) {
    if (tique == 0) {  
      setBackground(cor);
      g.fillRect(0,0,largura,altura);
    }
    paint(g);
  }

}

