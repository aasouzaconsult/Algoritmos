/*
 *  este programa tem como finalidade demonstrar como se inseri uma figura 
 *  em uma tela - JPanel
 *
 *
 */


import javax.swing.*;
import java.awt.*;

public class Rotulos2 extends JFrame{
  public Rotulos2(){
    super("Uso da classe JLabel");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    ImageIcon icone = new ImageIcon("java_exemplos/imagens/cesto.gif");//cesto
    JLabel rotulo1 = new JLabel(icone);
    
    ImageIcon icone2 = new ImageIcon("java_exemplos/imagens/diretorio.gif"); //diretorio
    JLabel rotulo2 = new JLabel("Este é o rótulo 2", icone2, JLabel.LEFT);
    
    tela.add(rotulo1);
    tela.add(rotulo2);
    
    setLocation(280,235);
    setSize(300, 160);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Rotulos2 app = new Rotulos2();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}