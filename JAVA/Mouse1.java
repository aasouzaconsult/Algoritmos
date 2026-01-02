/**----------------------------------------------------------------------*/
/** Mostra as coordenadas dos cliques do mouse.                          */
/** Mostra se o clique ocorreu dentro ou fora do retângulo.              */
/** Informa se o mouse está dentro ou fora da área do applet.            */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

// Para executar este applet, use: appletviewer Mouse1.java         
// <applet code=Mouse1.class width=600 height=200>
// </applet>

import java.awt.*;
import java.applet.*;
import java.awt.event.*; 

public class Mouse1 extends Applet implements MouseListener {
  int xpos = -1;                     // Coordenada X do último clique
  int ypos = -1;                     // Coordenada Y do último clique
  int xco=40,yco=40,largura,altura;  // Retângulo
  String msgarea = "Applet começou"; 
  String msgret = "";                // Dentro ou fora do retângulo
  Font fonte = new Font("Courier New",Font.BOLD,14);

  public void init() {
    setBackground(Color.orange);
    setFont(fonte);
    addMouseListener(this);
  } 

  public void paint(Graphics g) {
    g.setColor(Color.blue); 
    Rectangle rec = getBounds();
    largura = rec.width-2*xco;
    altura = rec.height-2*yco;
    g.fillRect(xco,yco,largura,altura);
    g.setColor(Color.white); 
    if (xpos >= 0) g.drawString("(" + xpos + "," + ypos + ")",xpos,ypos); 
    g.setColor(Color.black); 
    g.drawString("Retângulo " + largura + "X" + altura + 
                 " em (" + xco + "," + yco + ")",xco,yco+altura+15);
    g.drawString(msgret,xco,yco+altura+30);
    showStatus(msgarea);
  } 

  public void mouseClicked (MouseEvent e) { 
    String botão,posição;
    xpos = e.getX();            // Coordenada X do clique
    ypos = e.getY();            // Coordenada Y do clique
    int n = e.getClickCount();  // Quantidade de cliques
    String s = (n > 1) ? "es" : "";
    
    if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0)
      botão = "esquerdo ";
    else if ((e.getModifiers() & InputEvent.BUTTON2_MASK) != 0)
      botão = "do meio ";
    else botão = "direito ";

    if (xpos >= xco && xpos <= xco+largura &&
        ypos >= yco && ypos <= yco+altura) 
      posição = "dentro";
    else posição = "fora";
    
    msgret = "Clicou " + n + " vez" + s + " com o botão " +
                botão + posição + " do retângulo azul";

    repaint(); 
  } 

   public void mouseEntered (MouseEvent e) {
     msgarea = "Mouse na área do applet";
     repaint();
   } 

   public void mouseExited (MouseEvent e) {
     msgarea = "Mouse fora da área do applet";
     repaint();
   }  

   public void mousePressed (MouseEvent e) {} 
   public void mouseReleased (MouseEvent e) {}  

}