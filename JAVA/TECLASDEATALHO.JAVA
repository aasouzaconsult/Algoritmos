import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TeclasDeAtalho extends JFrame{
  JTextField caixa;
  JButton ok;
  JLabel rotulo;
  
  public TeclasDeAtalho(){
    super("Uso de objetos da classe JTextField");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    TratadorEventos trat = new TratadorEventos();
    
    rotulo = new JLabel("Digite aqui:");
    rotulo.setPreferredSize(new Dimension(400, 20));
    
    caixa = new JTextField(10);
    
    ok = new JButton("Clique!");
    ok.addActionListener(trat);
    
    tela.add(rotulo);
    tela.add(caixa);
    tela.add(ok);
    
    setLocation(280,235);
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    CaixasDeTexto app = new CaixasDeTexto();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class TratadorEventos implements ActionListener{
    public void actionPerformed(ActionEvent evento){
      rotulo.setText(caixa.getText());
    }
  }
}