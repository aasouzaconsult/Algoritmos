import javax.swing.*;
import java.awt.*;

public class TamanhoMaximoTeste extends JFrame{
  JTextField caixa;
  
  public TamanhoMaximoTeste(){
    super("Limitando a quantidade de caracteres em um JTextField");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    caixa = new JTextField(10);
    caixa.setDocument(new TamanhoMaximo(5));
    
    tela.add(caixa);
   
    setSize(350, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    TamanhoMaximoTeste app = new TamanhoMaximoTeste();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}