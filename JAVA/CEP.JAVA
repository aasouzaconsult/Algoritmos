import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
import java.text.*;

public class Cep extends JFrame{
  JFormattedTextField caixa;
  MaskFormatter cep;
  
  public Cep(){
    super("CEP");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    try{
      cep = new MaskFormatter("#####-###");
      cep.setPlaceholderCharacter('_');
    }
    catch(ParseException excp){
      // caso alguma exceção ocorra
    }
    
    caixa = new JFormattedTextField(cep);
    caixa.setPreferredSize(new Dimension(80, 20)); 
    
    JButton ok = new JButton("OK");
    ok.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          JOptionPane.showMessageDialog(null, caixa.getText());  
        } 
      }
    );
    
    tela.add(new JLabel("Informe o CEP:"));
    tela.add(caixa);
    tela.add(ok);
   
    setSize(350, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Cep app = new Cep();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}