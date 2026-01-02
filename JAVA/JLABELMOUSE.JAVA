import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JLabelMouse extends JFrame{
  public JLabelMouse(){
    super("Eventos do mouse em um objeto JLabel");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    JLabel rotulo = new JLabel("Posicione o mouse sobre o controle!");
    
    rotulo.addMouseListener(
      new MouseAdapter(){
        public void mouseEntered(MouseEvent evento){
          ((JLabel)(evento.getSource())).setForeground(Color.red);
        }
        
        public void mouseExited(MouseEvent evento){
          ((JLabel)(evento.getSource())).setForeground(Color.black);
        }
      }
    );
    
    tela.add(rotulo);
    
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    JLabelMouse app = new JLabelMouse();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}