/**----------------------------------------------------------------------*/
/** Traça linhas marcadas (ponto inicial e final) com o mouse.           */
/** Os pontos existentes são mantidos em dois vetores dinâmicos para     */
/** que as linhas já traçadas possam ser re-desenhadas.                  */
/** Evita tremidos usando Swing que usa buffer duplo.                    */
/** Browsers não suportam métodos get, add, e remove de VECTOR; por      */
/** isso, usam-se os métodos elementAt, addElement, removeElementAt.     */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Linhas4.java         
// <applet code=Linhas4.class height=500 width=500>
// </applet>

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;

public class Linhas4 extends JApplet {

  public void init() {
    Container c = getContentPane();
    Linhas4x p = new Linhas4x();
    c.add(p,BorderLayout.CENTER);
    c.setBackground(Color.yellow);
    c.addMouseListener(p);
    c.addMouseMotionListener(p);
  }

}

class Linhas4x extends JPanel
      implements MouseListener, MouseMotionListener {  

  Vector começa  = new Vector(100,50); // Coordenadas dos pontos iniciais
  Vector termina = new Vector(100,50); // Coordenadas dos pontos finais
  Point inicial;                       // Começo da linha corrente
  Point corrente;                      // Fim da linha até o momento
  Point anterior;                      // Para limpar reta anterior  

  public Linhas4x() {
    super(null,true);
    setBackground(Color.yellow);
  }

  public void paintComponent(Graphics tela) {
    super.paintComponent(tela);

    // Apaga a linha incompleta  anterior
    if (inicial != null && anterior != null) { 
      tela.setColor(getBackground());
      tela.drawLine(inicial.x,inicial.y,anterior.x,anterior.y);
      tela.setColor(getForeground());
    }
      
    // Desenha as linhas já traçadas anteriormente
    tela.setColor(Color.blue);
    for (int k = 0; k < começa.size(); k++) {
      Point pi = (Point) começa.elementAt(k);
      Point pf = (Point) termina.elementAt(k); 
      tela.drawLine(pi.x,pi.y,pf.x,pf.y);
    }

    // Desenha a linha corrente com cor diferente
    tela.setColor(Color.magenta);
    if (inicial != null && corrente != null)
      tela.drawLine(inicial.x,inicial.y,corrente.x,corrente.y);
  }

  public void adicionaLinha(Point ponto) {
    if (inicial != null && corrente != null) {
      começa.addElement(inicial);
      termina.addElement(ponto);
    }
    corrente = inicial = null;
    repaint();
  }

  public void mousePressed(MouseEvent e) {
    inicial = e.getPoint();
  }

  public void mouseDragged(MouseEvent e) {
    anterior = corrente;
    corrente = e.getPoint();
    repaint();
  }

  public void mouseReleased(MouseEvent e) {
    adicionaLinha(e.getPoint());
  }

    public void mouseEntered(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}

}   