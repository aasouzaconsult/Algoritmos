import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Redimensionar extends JFrame{
  JButton btn1, btn2;
  Border borda1, borda2;
  
  public Redimensionar(){
    super("Redimensionando controles");
 
    Container tela = getContentPane();
    tela.setLayout(null);
    
    btn1 = new JButton("Botão 1");
    tela.add(btn1);
    btn1.setBounds(20, 20, 100, 50);
    
    btn1.addKeyListener(
      new KeyAdapter(){
        public void keyPressed(KeyEvent e){
          switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT: 
              btn1.setSize(btn1.getWidth() - 1, btn1.getHeight());
              break;
            case KeyEvent.VK_RIGHT: 
              btn1.setSize(btn1.getWidth() + 1, btn1.getHeight());
              break;
            case KeyEvent.VK_UP: 
              btn1.setSize(btn1.getWidth(), btn1.getHeight() - 1);
              break;
            case KeyEvent.VK_DOWN: 
              btn1.setSize(btn1.getWidth(), btn1.getHeight() + 1);
              break;
          }	
        }	
      }	
    );
    
    btn2 = new JButton("Botão 2");
    tela.add(btn2);
    btn2.setBounds(150, 20, 100, 50);
    
    borda1 = btn1.getBorder();
    borda2 = BorderFactory.createLineBorder(Color.red, 2);
    
    btn1.addFocusListener(
      new FocusListener(){
        public void focusGained(FocusEvent e){
          btn1.setBorder(borda2);	
        }
        
        public void focusLost(FocusEvent e){
          btn1.setBorder(borda1);	
        }	
      }	
    );
    
    setSize(290, 150);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Redimensionar app = new Redimensionar();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}