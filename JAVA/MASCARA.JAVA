import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
import java.text.*;

public class Mascara extends JFrame{
  JFormattedTextField caixa;
  MaskFormatter mascara;
  
  public Mascara(){
    super("Uso da classe JFormattedTextField");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    try{
      mascara = new MaskFormatter("#####");
      mascara.setPlaceholderCharacter('_');
    }
    catch(ParseException excp){
      // caso alguma exceção ocorra
    }
    
    caixa = new JFormattedTextField(mascara);
    caixa.setPreferredSize(new Dimension(80, 20)); 
    
    JButton ok = new JButton("OK");
    ok.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          JOptionPane.showMessageDialog(null, caixa.getText());  
        } 
      }
    );
    
    tela.add(new JLabel("Código do Cliente:"));
    tela.add(caixa);
    tela.add(ok);
   
    setLocation(285,235);
    setSize(350, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Mascara app = new Mascara();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}