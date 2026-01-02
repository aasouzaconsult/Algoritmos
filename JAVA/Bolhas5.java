/**----------------------------------------------------------------------*/
/** Desenha dez bolas com posições e velocidades diferentes.             */
/** As bolhas passeiam pela área do applet e ricocheteiam nas paredes.   */
/** Usa uma classe interna para instanciar as bolhas.                    */
/** Evita tremidos evitando limpar a tela e apagando a bola anterior.    */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Bolhas4.java 
// <applet code=Bolhas5.class width=400 height=400>
// </applet>

import java.awt.*;
import java.applet.*;

public class Bolhas5 extends Applet implements Runnable {
  final int maximo = 10;
  int largura, altura;
  Thread tarefa;
  Bolha5[] bolha = new Bolha5[maximo];

  final int[] x  = {50,60,15,150,210,80,170,30,160,10};
  final int[] y  = {20,100,70,60,30,120,130,90,140,50};
  final int[] dx = {1,-2,-2,-3,2,-2,-4,3,1,-4};
  final int[] dy = {2,-3,-2,-2,4,-4,-2,1,3,-1};
  final Color[] cor = {Color.blue,Color.red,Color.green,Color.cyan,
                       Color.magenta,Color.black,Color.white,
                       Color.orange,Color.yellow,Color.gray
                      }; 
  
  public void init() {
    setBackground(Color.lightGray);
    largura = getWidth();
    altura = getHeight();

    for (int i = 0; i < maximo; i++)
      bolha[i] = new Bolha5(x[i],y[i],dx[i],dy[i],cor[i]);
    Bolha5.limites(largura,altura);
  }

  public void start() {
    if (tarefa == null) {
      tarefa = new Thread(this);
      tarefa.start();
    }
  }

  public void stop() {
    tarefa = null;
  }

  public void run() {
    while(tarefa != null) {
      try {tarefa.sleep(20);}
      catch (Exception e) {}

      for (int i = 0; i < maximo; ++i)
        bolha[i].moveBolha();

     repaint();
    }
  }

  public void update(Graphics g) {
    paint(g);
  }

  public void paint(Graphics g) {
    for (int i = 0; i < maximo; i++)
       bolha[i].desenhaBolha(g,getBackground());
  }

}

class Bolha5 { 
  final static int diametro = 30;
  static int largura, altura;
  int xa, ya, x, y, dx, dy;
  Color cor;

  // Xinicial, Yinicial, deslocX, deslocY, cor
  Bolha5(int x, int y, int dx, int dy, Color cor) {
    this.x = x;
    this.y = y;
    this.dx = dx;
    this.dy = dy;
    this.cor = cor;
  }

  static void limites(int w, int h) {
    largura = w;
    altura = h;
  }

  void moveBolha() {
    xa = x;  // Lembra anterior
    x += dx;
    if (x < 0) {
      x = 0;
      dx = -dx;
    }
    else if (x > largura - diametro) {
      x = largura - diametro;
      dx = -dx;
    }
    
    ya = y;  //Lembra anterior 
    y += dy;
    if (y < 0) {
      y = 0;
      dy = -dy;
    }
    else if (y > altura - diametro) {
      y = altura - diametro;
      dy = -dy;
    }
  }

  void desenhaBolha(Graphics g, Color fundo) {
    // Apaga bolha anterior
    g.setColor(fundo);
    g.fillOval(xa,ya,diametro,diametro);
    // Desenha nova bolha
    g.setColor(cor);
    g.fillOval(x,y,diametro,diametro);
  }

}
