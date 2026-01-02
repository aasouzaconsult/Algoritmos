import javax.swing.*;
import java.awt.*;

public class JLabelHTML extends JFrame{
  public JLabelHTML(){
    super("Uso de HTML em um objeto JLabel");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    JLabel rotulo = new JLabel("<html><font color=\"red\">Veja</font> <u>a formatação deste</u><p> <i>texto</i>. <s>Note a quebra de linha</s></html>");
    tela.add(rotulo);
    
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    JLabelHTML app = new JLabelHTML();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}