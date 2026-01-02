import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class RollOver extends JFrame{
  JButton clique;
  
  public RollOver(){
    super("Efeito rollover em bot�es");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout();
    tela.setLayout(layout); 
    
    ImageIcon icone = new ImageIcon("img1.gif");
    ImageIcon icone2 = new ImageIcon("img2.gif");
    
    clique = new JButton(icone);
    clique.setRolloverIcon(icone3);
    clique.setPreferredSize(new Dimension(150, 31));
    clique.setBorder(new EmptyBorder(0, 0, 0, 0));
    
    tela.add(clique);
    
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    RollOver app = RollOver();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}