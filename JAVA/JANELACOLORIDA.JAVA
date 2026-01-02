import javax.swing.*;
import java.awt.Color;

public class JanelaColorida extends JFrame{
  public JanelaColorida(){
    super("Definindo a cor da janela");
    
    
    setBackground(Color.green);
    
    setLocation(280,235);
    setSize(300,150);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    JanelaColorida app = new JanelaColorida();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  } 
}