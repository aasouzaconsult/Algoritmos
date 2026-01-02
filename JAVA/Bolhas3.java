/**----------------------------------------------------------------------*/
/** Desenha pontos (bolhas pulsantes) marcados com o mouse.              */
/** As bolhas são criadas com cor e diâmetro aleatórios, aumentam até    */
/** o máximo, e diminuem até o mínimo a cada 15 milisegundos.            */
/** As bolhas existentes são mantidas em um vetor dinâmico para          */
/** que aquelas já marcadas anteriormente possam ser redesenhadas.       */
/** Usa uma classe interna para instanciar as bolhas.                    */
/** Evita tremidos com buferização dupla.                                */
/** Browsers não suportam métodos get, add, e remove de VECTOR; por      */
/** isso, usam-se os métodos elementAt, addElement, removeElementAt.     */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Bolhas3.java 
// <applet code=Bolhas3.class width=600 height=500>
// </applet>

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;

public class Bolhas3 extends Applet implements Runnable, MouseListener {
  Image trabalho;
  Graphics fora;
  Thread tarefa;
  Vector v = new Vector(100,50);
  Bolha3 bolha;

  public void init() {
    trabalho = createImage(getWidth(),getHeight());
    fora = trabalho.getGraphics();
    addMouseListener(this);
  }

  public void start() {
    if (tarefa == null) {
      tarefa = new Thread (this);
      tarefa.start();
    }
  }

  public void stop()  {
    tarefa = null;
  }

  public void destroy() {
    fora.dispose();
  }

  public void run() {
    while (tarefa != null) {
      try {tarefa.sleep(15);}
      catch (Exception e) {}
      for (int i = 0; i < v.size(); ++i) {
        bolha = (Bolha3) v.elementAt(i);
        bolha.pulsaBolha();
      }
      repaint();  
    }
  }

  public void update(Graphics g) {
    fora.setColor(Color.white);
    fora.fillRect(0,0,getWidth(),getHeight());
    fora.setColor(Color.black);
    fora.drawRect(0,0,getWidth(),getHeight());
    paint(g);
  }

  public void paint(Graphics g) {
    for (int i = 0; i < v.size(); ++i) {
      bolha = (Bolha3) v.elementAt(i);
      bolha.desenhaBolha(fora);
    }
    g.drawImage(trabalho,0,0,this);
  }

  public void mousePressed(MouseEvent e) {
    bolha = new Bolha3();
    bolha.marcaCentro(e.getPoint());
    v.addElement(bolha);
  }

  public void mouseReleased(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
  public void mouseClicked(MouseEvent e) {}

}


class Bolha3 {
  int diametro, minimo, maximo;
  Point centro = new Point(0,0);
  Color umaCor;
  boolean crescente = true;

  public Bolha3() {
    int vermelho = (int) (Math.random()*255);
    int verde    = (int) (Math.random()*255);
    int azul     = (int) (Math.random()*255);

    umaCor = new Color(vermelho,verde,azul);
    minimo = (int) (Math.random()*20) + 10;
    maximo = (int) (Math.random()*100) + 50;
    diametro = minimo;
  }

  void marcaCentro(Point ponto) {
    centro = ponto;
  }

  void desenhaBolha (Graphics g) {
    g.setColor(umaCor);
    g.fillOval(centro.x-diametro/2,centro.y-diametro/2,diametro,diametro);
  }

  void pulsaBolha() {
    if (crescente) 
      if (diametro < maximo) diametro++;
      else crescente = false;
    else if (diametro > minimo) diametro--;
         else crescente = true;
  }
}
