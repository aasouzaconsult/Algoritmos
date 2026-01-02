import javax.swing.*;
import java.awt.*;

public class BorderLayoutTeste extends JFrame{
  public BorderLayoutTeste(){
    super("O gerenciador de layout BorderLayout");
 
    Container tela = getContentPane();
    
    BorderLayout layout = new BorderLayout();
    tela.setLayout(layout);
    
    JButton bt1 = new JButton("Botão 1");
    JButton bt2 = new JButton("Botão 2");
    JButton bt3 = new JButton("Botão 3");
    JButton bt4 = new JButton("Botão 4");
    JButton bt5 = new JButton("Botão 5");
    
    tela.add(BorderLayout.CENTER, bt1);
    tela.add(BorderLayout.NORTH, bt2);
    tela.add(BorderLayout.SOUTH, bt3);
    tela.add(BorderLayout.EAST, bt4);
    tela.add(BorderLayout.WEST, bt5);
    
    setSize(300, 150);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    BorderLayoutTeste app = new BorderLayoutTeste();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}