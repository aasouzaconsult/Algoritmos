import javax.swing.*;
import java.awt.*;

public class Controles extends JFrame{
  public Controles(){
    super("Adicionando controles à janela");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout();
    tela.setLayout(layout); 
    
    JButton btn = new JButton("Clique Aqui");
    tela.add(btn);
    
    setSize(300, 150);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Controles app = new Controles();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  } 
}