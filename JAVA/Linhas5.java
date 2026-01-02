/**----------------------------------------------------------------------*/
/** Permite desenho à mão livre.                                         */
/** Os pontos existentes são mantidos evitando que update limpe a tela.  */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Linhas5.java         
// <applet code=Linhas5.class height=500 width=500>
// </applet>

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Linhas5 extends Applet 
    implements MouseListener, MouseMotionListener {

  Point inicial, seguinte; 

  public void init() {
    setBackground(Color.yellow);
    addMouseListener(this);
    addMouseMotionListener(this);
  }

  public void update(Graphics tela) {
    paint(tela);
  }
    
  public void paint(Graphics tela) {
    tela.setColor(Color.blue);
    if (inicial != null && seguinte != null) 
      tela.drawLine(inicial.x,inicial.y,seguinte.x,seguinte.y);
    inicial = seguinte;
  }

  public void mousePressed(MouseEvent e) {
    inicial = e.getPoint();
  }

  public void mouseDragged(MouseEvent e) {
    seguinte = e.getPoint();
    repaint();
  }

  public void mouseReleased(MouseEvent e) {
    inicial = seguinte = null;
  }
 
  public void mouseEntered(MouseEvent e) {}
  public void mouseClicked(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
  public void mouseMoved(MouseEvent e) {}

}   