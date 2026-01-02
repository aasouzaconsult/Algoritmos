/**----------------------------------------------------------------------*/
/** Desenha pontos (bolhas) marcados com o mouse.                        */
/** As bolhas existentes são mantidas em um vetor dinâmico para          */
/** que aquelas já marcadas anteriormente possam ser redesenhadas.       */
/** Evita tremidos substituindo o método update sem limpar a tela, pois  */
/** as bolhas são redesenhadas em cima das já existentes.                */
/** Um clique duplo dentro de uma bolha (cursor muda de formato),        */
/** elimina-a do tela: método paint desenha a bolha com a cor de fundo.  */
/** Browsers não suportam métodos get, add, e remove de VECTOR; por      */
/** isso, usam-se os métodos elementAt, addElement, removeElementAt.     */
/** Classes adaptadoras internas evitam declarações de métodos vazios.   */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Bolhas2.java         
// <applet code=Bolhas2.class height=400 width=400>
// </applet>

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.Vector;

public class Bolhas2 extends Applet {
  Vector pontos = new Vector(100,50);  // Coordenadas dos pontos marcados
  Point removido = new Point(0,0);     // Bolha removida 
  int centro = -1;                     // Centro da bolha corrente
  int raio = 10;

  public void init() { 
    addMouseListener(
       new MouseAdapter() { // Classe interna 

         public void mousePressed(MouseEvent e) {
           adicionaBolha(e.getPoint());
         }

         public void mouseClicked(MouseEvent e) { 
           if (e.getClickCount() > 1) 
             removeBolha(e.getPoint()); 
         }
       }
    );

    addMouseMotionListener(
       new MouseMotionAdapter() { // Classe interna

         public void mouseMoved(MouseEvent e) {
           if (dentroBolha(e.getPoint()))
            setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
           else setCursor(Cursor.getDefaultCursor());
         }
       }
    );

    setBackground(Color.yellow);
  }

  public void update(Graphics g) {
    paint(g);
  }

  public void paint(Graphics g) {

    // Elimina bolha removida do desenho
    if (centro >= 0) {
      g.setColor(getBackground());
      g.fillOval(removido.x-raio,removido.y-raio,2*raio,2*raio);
    }
    
    // Desenha bolhas já marcadas anteriormente
    g.setColor(Color.blue);
    for (int i = 0; i < pontos.size(); ++i) {
      Point ponto = (Point) pontos.elementAt(i);
      g.fillOval(ponto.x-raio,ponto.y-raio,2*raio,2*raio);
    }
  }
  
  private void adicionaBolha(Point ponto) {
    if (!dentroBolha(ponto)) { 
      pontos.addElement(ponto);
      repaint();
    }
  }

  private boolean dentroBolha(Point ponto) {
    boolean achou = false;
    centro = -1;
    for (int i = 0; i < pontos.size() && !achou ; ++i) {
      Point bolha = (Point) pontos.elementAt(i);
      int dx = Math.abs(bolha.x - ponto.x);
      int dy = Math.abs(bolha.y - ponto.y);
      achou = Math.sqrt(dx*dx + dy*dy) <= raio;
      if (achou) centro = i;
    }
    return achou;
  }

  private void removeBolha(Point ponto) { 
    if (dentroBolha(ponto) && centro >= 0) {
      removido = (Point) pontos.elementAt(centro);
      pontos.removeElementAt(centro);
      repaint();
    }
  }

}
