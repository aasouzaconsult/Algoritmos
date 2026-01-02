import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Foco extends JFrame{
  JTextField caixa1, caixa2;
  JButton btn1, btn2;
  
  public Foco(){
    super("Direcionando o foco");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    TratadorEventos trat = new TratadorEventos();
    
    caixa1 = new JTextField("Texto 1", 10);
    caixa2 = new JTextField("Texto 2", 10);
    
    btn1 = new JButton("Caixa 1");
    btn1.addActionListener(trat);
    
    btn2 = new JButton("Caixa 2");
    btn2.addActionListener(trat);
    
    tela.add(caixa1);
    tela.add(caixa2);
    tela.add(btn1);
    tela.add(btn2);
    
    setSize(410, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Foco app = new Foco();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class TratadorEventos implements ActionListener{
    public void actionPerformed(ActionEvent evento){
      if(evento.getSource() == btn1)
        caixa1.requestFocus();
      else
        caixa2.requestFocus();
    }
  }
}