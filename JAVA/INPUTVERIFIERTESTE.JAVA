import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputVerifierTeste extends JFrame{
  JTextField caixa;
  
  public InputVerifierTeste(){
    super("Uso da classe InputVerifier");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    caixa = new JTextField(10);
    caixa.setInputVerifier(new Verificador());
    
    JButton ok = new JButton("OK");
    ok.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          JOptionPane.showMessageDialog(null, caixa.getText());  
        } 
      }
    );
    
    tela.add(caixa);
    tela.add(new JTextField(10));
    tela.add(ok);
   
    setLocation(280,235);
    setSize(350, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    InputVerifierTeste app = new InputVerifierTeste();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Verificador extends InputVerifier{
    public boolean verify(JComponent input) {
      JTextField caixaTexto = (JTextField) input;
      
      int quant = caixaTexto.getText().length(); 
      
      return (quant == 5);
    }  
  }
}