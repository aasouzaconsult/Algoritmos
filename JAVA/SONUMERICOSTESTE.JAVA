import javax.swing.*;
import java.awt.*;

public class SoNumericosTeste extends JFrame{
  JTextField caixa;
  
  public SoNumericosTeste(){
    super("Somente Valores Numéricos");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    caixa = new JTextField(10);
    caixa.setDocument(new SoNumericos());
    
    tela.add(caixa);
   
    setSize(350, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    SoNumericosTeste app = new SoNumericosTeste();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}