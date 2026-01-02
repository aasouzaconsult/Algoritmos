import javax.swing.*;
import java.awt.*;

public class CaixaDeTextoMMTeste extends JFrame{
  JTextField caixa;
  
  public CaixaDeTextoMMTeste(){
    super("Somente Maiúsculas ou Minúsculas");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    caixa = new JTextField(10);
    caixa.setDocument(new CaixaDeTextoMM("ma"));
    
    tela.add(caixa);
   
    setSize(350, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    CaixaDeTextoMMTeste app = new CaixaDeTextoMMTeste();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}