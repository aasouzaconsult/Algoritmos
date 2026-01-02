import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Foco2 extends JFrame{
  JTextField caixa;
  JButton ok;
  JLabel rotulo;
  
  public Foco2(){
    super("Uso da interface FocusListener");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    TratadorEventos trat = new TratadorEventos();
    
    rotulo = new JLabel("Digite aqui:");
    rotulo.setPreferredSize(new Dimension(400, 20));
    
    caixa = new JTextField(10);
    caixa.addFocusListener(trat);
    
    ok = new JButton("Clique!");
    ok.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          JOptionPane.showMessageDialog(null, caixa.getText());
        }
      }
    );
    
    tela.add(rotulo);
    tela.add(caixa);
    tela.add(ok);
    
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Foco2 app = new Foco2();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class TratadorEventos implements FocusListener{
    public void focusGained(FocusEvent e){
      caixa.setText("");
    }
    
    public void focusLost(FocusEvent e){
      String texto = caixa.getText();
      char digito;
      boolean numerico = true;
      
      for(int i = 0; i < texto.length(); i++){
        digito = texto.charAt(i);
      
        if(!Character.isDigit(digito)){
          numerico = false;
          break; 
        }
      }
    
      if((!numerico)||(texto.equals(""))){
        JOptionPane.showMessageDialog(null, "Conteúdo Inválido");
        caixa.setText("");
        caixa.requestFocus(); 
      }
    }
  }
}