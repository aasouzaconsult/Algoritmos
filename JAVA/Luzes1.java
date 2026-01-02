/**----------------------------------------------------------------------*/
/** Exemplo de um jogo gráfico usando apenas primitivos de desenho.      */
/** O objetivo do jogo é acender todas as luzes do quadro (amarelo).     */
/** O clique em uma casa inverte o seu estado (acesa/apagada) além do    */
/** estado de todas as casas adjacentes na mesma linha e mesma coluna.   */
/** Substitui o método update para eliminar o tremido da tela.           */
/** Funciona tanto como applet quanto como aplicativo usa classe JANELA. */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Luzes1.java            
// <applet code=Luzes1.class width=300 height=250>
// </applet>

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Luzes1 extends Applet implements MouseListener {
  final int dim = 5;
  final int lado = 200;
  final int casa = lado/dim;
  boolean[][] luzes = new boolean[dim][dim];
  int acesas = 0, apagadas = 0;
  boolean end = false;
  Font f1 = new Font("Courier New",Font.BOLD,18);
  Font f2 = new Font("Courier New",Font.PLAIN,12);

  public Luzes1() {
    setBackground(Color.white);
    addMouseListener(this);
  }

  public void init() {
    for (int i=0; i < dim; i++)
      for (int j=0; j < dim; j++)
        luzes[i][j] = false;
    end = false;
    repaint();
  }

  public void update(Graphics g) {
    g.setColor(getBackground());
    g.fillRect(0,210,294,35);
    paint(g);
  }

  public void paint(Graphics g) {
    desenhaQuadro(g);
    desenhaLuz(g);
    desenhaBotão(g);
    desenhaContadores(g);
  }

  private void desenhaQuadro(Graphics g) {
    g.setColor(Color.black);
    g.drawLine(0,0,0,lado);
    g.drawLine(0,lado,lado,lado);
    g.drawLine(lado,lado,lado,0);
    g.drawLine(lado,0,0,0);
    for (int i = 1; i < dim; i++) {
      g.drawLine(lado*i/dim,0,lado*i/dim,lado);
      g.drawLine(0,lado*i/dim,lado,lado*i/dim);
    }
  }

  private void desenhaLuz(Graphics g) {
    acesas = apagadas = 0;
    for (int i=0; i < dim; i++)
      for (int j=0; j < dim; j++) {
        if (luzes[i][j]) {
          g.setColor(Color.yellow);
          ++acesas;
        } else { 
          g.setColor(Color.gray);
          ++apagadas;
        }
        g.fillRect(j*casa+2,i*casa+2,casa-3,casa-3);
      }
  }

  private void desenhaBotão(Graphics g) {
    g.setColor(Color.cyan);
    g.fillRect(210,165,84,20);
    g.setColor(Color.red);
    g.setFont(f2);
    g.drawString("Recomeçar",214,178);
  }

  private void desenhaContadores(Graphics g) {
    g.setColor(Color.yellow);
    g.fillRect(210,20,84,20);
    g.setColor(Color.lightGray);
    g.fillRect(210,85,84,20);
    g.setColor(Color.black);
    g.setFont(f2);
    g.drawString(acesas + " acesas",214,35);
    g.drawString(apagadas + " apagadas",214,99);
    if (apagadas <= 3) verifica(g);
  }

  private void verifica(Graphics g) {
    g.setColor(Color.blue);
    g.fillRect(0,210,294,35);
    g.setFont(f1);
    g.setColor(Color.red);
    if (apagadas == 3) g.drawString("Chegou perto da solução!",5,232);
    else if (apagadas == 2) g.drawString("Faltou um pouquinho só!",5,232);
    else if (apagadas == 1) g.drawString("Quase vale uma vitória!",5,232);
    else g.drawString("Acertou! Meus parabéns!",5,232);
  }

  public void mouseReleased(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    if (x > 209 && x < 294 && y > 164 && y < 185) init();
    else if (end) return;
    else {
      int i = y / casa;
      int j = x / casa;

      if (i < 0 || i >= dim || j < 0 || j >= dim) return;

      luzes[i][j] = !luzes[i][j];
      if (i < dim-1) luzes[i+1][j] = !luzes[i+1][j];
      if (i > 0)     luzes[i-1][j] = !luzes[i-1][j];
      if (j < dim-1) luzes[i][j+1] = !luzes[i][j+1];
      if (j > 0)     luzes[i][j-1] = !luzes[i][j-1];
      repaint();
    }
  }

  public void mousePressed(MouseEvent e) {}
  public void mouseClicked(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}

  public static void main(String[] args) {
    Janela1 frame = new Janela1("Jogo das Luzes");
    Luzes1 applet = new Luzes1();
    frame.add(applet,BorderLayout.CENTER);
    frame.setSize(310,300);
    frame.setLocation(300,300);
    frame.show();
    applet.init();
    applet.start();
  }

}