import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
import java.text.*;

public class MascaraTelefone extends JFrame{
  JFormattedTextField caixa;
  MaskFormatter telefone;
  
  public MascaraTelefone(){
    super("Uso da classe JFormattedTextField");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    try{
      telefone = new MaskFormatter("(###) ###-####");
      telefone.setPlaceholderCharacter('_');
    }
    catch(ParseException excp){
      // caso alguma exce��o ocorra
    }
    
    caixa = new JFormattedTextField(telefone);
    caixa.setPreferredSize(new Dimension(100, 20)); 
    
    JButton ok = new JButton("OK");
    ok.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          JOptionPane.showMessageDialog(null, caixa.getText());  
        } 
      }
    );
    
    tela.add(new JLabel("Telefone:"));
    tela.add(caixa);
    tela.add(ok);
   
    setLocation(285,260);
    setSize(350, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    MascaraTelefone app = new MascaraTelefone();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}