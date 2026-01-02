import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mouse3 extends JFrame{
  int qual, posX, posY;
  
  public Mouse3(){
    super("Detectando eventos do mouse");
 
    Container tela = getContentPane();
    
    addMouseListener(new Tratador());
    
    setLocation(280,235);
    setSize(300, 150);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Mouse3 app = new Mouse3();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void paint(Graphics g){
  	String botao = ((qual == 1) ? ("esquerdo") : ("direito")); 
  	
  	g.drawString("Botão " + botao + 
  	             " nas coordenadas " + posX + "x" + posY, posX, posY);
  }
  
  private class Tratador extends MouseAdapter{
  	public void mouseClicked(MouseEvent e){
  	  qual = e.getButton();
  	  
  	  // 1  = Bot�o esquerdo
  	  // 3  = Bot�o direito
  	  
  	  posX = e.getX();
  	  posY = e.getY();
  	  
  	  repaint();
    }
  }
}