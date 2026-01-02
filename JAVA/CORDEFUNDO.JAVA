import javax.swing.*;
import java.awt.*;

public class CorDeFundo extends JFrame{
  public CorDeFundo(){
    super("Definindo a cor de fundo para a janela");
 
    Container tela = getContentPane();
    tela.setBackground(Color.red);//white
    
    FlowLayout layout = new FlowLayout();
    layout.setAlignment(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    JLabel rotulo = new JLabel("Seu Nome:");
    JTextField nome = new JTextField(10);
    JButton btn = new JButton("OK!");
    tela.add(rotulo);
    tela.add(nome);
    tela.add(btn);
    
    setLocation(280,235);
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    CorDeFundo app = new CorDeFundo();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  } 
}