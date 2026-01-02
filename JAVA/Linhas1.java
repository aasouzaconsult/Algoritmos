/**----------------------------------------------------------------------*/
/** Traça linhas marcadas (ponto inicial e final) com o mouse.           */
/** Os pontos existentes são mantidos em dois vetores dinâmicos para     */
/** que as linhas já traçadas possam ser re-desenhadas.                  */
/** A tela treme devido à limpeza de tela feita pelo método update()     */
/** antes de chamar o paint(). Veja soluções em Linhas2 e Linhas3.       */
/** Browsers não suportam métodos get, add, e remove de VECTOR; por      */
/** isso, usam-se os métodos elementAt, addElement, removeElementAt.     */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Linhas1.java         
// <applet code=Linhas1.class height=400 width=400>
// </applet>

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;

public class Linhas1 extends Applet
  implements MouseListener, MouseMotionListener {

  Vector começa  = new Vector(100,50); // Coordenadas dos pontos iniciais
  Vector termina = new Vector(100,50); // Coordenadas dos pontos finais
  Point inicial;                       // Começo da linha atual
  Point corrente;                      // Fim da linha até o momento

  public void init() {
    setBackground(Color.yellow);
    addMouseListener(this);
    addMouseMotionListener(this);
  }

  public void paint(Graphics g) {

    // Desenha as linhas já traçadas anteriormente
    g.setColor(Color.blue);
    for (int k = 0; k < começa.size(); k++) {
      Point pi = (Point) começa.elementAt(k);
      Point pf = (Point) termina.elementAt(k); 
      g.drawLine(pi.x,pi.y,pf.x,pf.y);
    }

    // Desenha a linha corrente com cor diferente
    g.setColor(Color.magenta);
    if (inicial != null && corrente != null)
      g.drawLine(inicial.x,inicial.y,corrente.x,corrente.y);
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
