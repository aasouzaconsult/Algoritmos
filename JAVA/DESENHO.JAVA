import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class Desenho extends JFrame{
  int posX = -10, posY = -10;
  
  public Desenho(){
    super("Um programa de desenho");
 
    addMouseMotionListener(
      new MouseMotionAdapter(){
        public void mouseDragged(MouseEvent e){
          posX = e.getX();
          posY = e.getY();
          repaint();
        }
      }
    );
    
    setBackground(Color.white);
    setLocation(280,235);
    setSize(300,250);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Desenho app = new Desenho();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void paint(Graphics g){
    g.fillOval(posX, posY, 3, 3);  
  }
}