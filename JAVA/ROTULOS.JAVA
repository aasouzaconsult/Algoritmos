import javax.swing.*;
import java.awt.*;

public class Rotulos extends JFrame{
  public Rotulos(){
    super("Uso da classe JLabel");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    JLabel rotulo1 = new JLabel();
    rotulo1.setText("Este é o r�tulo 1");
    rotulo1.setPreferredSize(new Dimension(300, 20));
    
    JLabel rotulo2 = new JLabel("Este é o rótulo 2");
    
    tela.add(rotulo1);
    tela.add(rotulo2);
    
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Rotulos app = new Rotulos();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}