import javax.swing.*;
import java.awt.*;

public class Controles2 extends JFrame{
  public Controles2(){
    super("Adicionando controles à janela");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout();
    layout.setAlignment(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    JLabel rotulo = new JLabel("Seu Nome:");
    JTextField nome = new JTextField(10);
    JButton btn = new JButton("OK!");
    tela.add(rotulo);
    tela.add(nome);
    tela.add(btn);
    
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Controles2 app = new Controles2();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  } 
}