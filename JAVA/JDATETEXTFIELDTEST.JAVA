import javax.swing.*;
import java.awt.*;

public class JDateTextFieldTest extends JFrame{
  JTextField caixa;
  
  public JDateTextFieldTest(){
    super("Testando a classe JDateTextField");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    caixa = new JTextField(10);
    caixa.setDocument(new JDateTextField());
    
    tela.add(caixa);
   
    setLocation(285,260);
    setSize(350, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    JDateTextFieldTest app = new JDateTextFieldTest();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}