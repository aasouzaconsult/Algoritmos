/**----------------------------------------------------------------------*/
/** Escreve o símbolo correspondente à tecla usada no centro da tela.    */
/** As quatro setas do teclado podem ser usadas para mover o símbolo     */
/** ao longo da tela com velocidade simples ou dupla (shift + seta).     */
/** O applet garante que o símbolo é desenhando completamento na tela.   */
/** Evita tremidos apagando a tecla anterior e atual (substitui update). */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Teclado1.java       
// <applet code=Teclado1.class width=750 height=550>
// </applet>

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Teclado1 extends Applet implements KeyListener {

  char tecla = ' ', anterior;
  int x,xant;
  int y,yant;
  Font fonte = new Font("Helvetica",Font.BOLD,40);
  FontMetrics fm = getFontMetrics(fonte);
 
  public void init() {
    x = (getSize().width - fm.stringWidth("m")) / 2;  
    y = getSize().height / 2;
    
    setBackground(Color.yellow);
    setFont(fonte);
    requestFocus();
    addKeyListener(this);
  }

  public int verificax(int x,int delta) { 
    x += delta;

	  int largura = fm.stringWidth("" + tecla);
    if (x < 0) x = 0;
    if (x > getSize().width - largura) 
      x = getSize().width - largura;
    return x;
  }

  public int verificay(int y, int delta) { 
    y += delta;
  	FontMetrics fm = getFontMetrics(fonte);
    if (y < fm.getAscent()) y = fm.getAscent();
    if (y > getSize().height - fm.getDescent()) 
      y = getSize().height - fm.getDescent();
    return y;
  }  

  public void keyPressed(KeyEvent e) {
    int delta;
    xant = x; yant = y;
    if (e.isShiftDown())
      delta = 10;
    else delta = 5;
    if (e.getKeyCode() == e.VK_LEFT) 
      x = verificax(x,-delta);
    else if (e.getKeyCode() == e.VK_RIGHT)  
      x = verificax(x,delta);
    else if (e.getKeyCode() == e.VK_DOWN) 
      y = verificay(y,delta);
    else if (e.getKeyCode() == e.VK_UP) 
      y = verificay(y,-delta);
    repaint();
  }

  public void keyTyped(KeyEvent e) {
    anterior = tecla;
    tecla = e.getKeyChar();
    repaint();
    }

  public void keyReleased(KeyEvent e) {}

  public void update(Graphics g) {
    paint(g);
  }

  public void paint(Graphics g) {
    g.setColor(getBackground());
    g.drawString("" + tecla,xant,yant);
    g.drawString("" + anterior,x,y);
    g.setColor(Color.blue);
    g.drawString("" + tecla,x,y);
  }

}
