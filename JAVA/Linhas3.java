/**----------------------------------------------------------------------*/
/** Traça linhas marcadas (ponto inicial e final) com o mouse.           */
/** Os pontos existentes são mantidos em dois vetores dinâmicos para     */
/** que as linhas já traçadas possam ser re-desenhadas.                  */
/** Evita tremidos usando buffer duplo (tela virtual).                   */
/** Browsers não suportam métodos get, add, e remove de VECTOR; por      */
/** isso, usam-se os métodos elementAt, addElement, removeElementAt.     */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Linhas2.java         
// <applet code=Linhas3.class height=500 width=500>
// </applet>

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.Vector;

public class Linhas3 extends Applet 
    implements MouseListener, MouseMotionListener {

  Vector começa  = new Vector(100,50); // Coordenadas dos pontos iniciais
  Vector termina = new Vector(100,50); // Coordenadas dos pontos finais
  Point inicial;                       // Começo da linha corrente
  Point corrente;                      // Fim da linha até o momento
  Point anterior;                      // Para limpar reta anterior
  Image trabalho;                      // Tela virtual
  Graphics fora;                       // Ferramenta gráfica
  int largura, altura;                 // Dimensões da tela 

  public void init() {
    largura = getWidth();
    altura = getHeight();
    trabalho = createImage(largura,altura); // Cria tela virtual 
    fora = trabalho.getGraphics();          // Cria ferramenta gráfica
    setBackground(Color.yellow);
    addMouseListener(this);
    addMouseMotionListener(this);
  }

  public void update(Graphics tela) {
    paint(tela);
  }

  public void paint(Graphics tela) {
    
    // Limpa a tela virtual
    fora.setColor(getBackground());
    fora.fillRect(0,0,largura,altura);      

    // Desenha as linhas já traçadas anteriormente
    fora.setColor(Color.blue);
    for (int k = 0; k < começa.size(); k++) {
      Point pi = (Point) começa.elementAt(k);
      Point pf = (Point) termina.elementAt(k); 
      fora.drawLine(pi.x,pi.y,pf.x,pf.y);
    }

    // Desenha a linha corrente com cor diferente
    fora.setColor(Color.magenta);
    if (inicial != null && corrente != null)
      fora.drawLine(inicial.x,inicial.y,corrente.x,corrente.y);

    // Copia tela virtual para tela real
    tela.drawImage (trabalho,0,0,this);
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