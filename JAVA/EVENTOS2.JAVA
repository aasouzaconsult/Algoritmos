import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Eventos2 extends JFrame{
  JTextField texto;
  
  public Eventos2(){
    super("Introdução ao uso de eventos");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    JLabel rotulo = new JLabel("Texto:");
    texto = new JTextField(10);
    JButton btn = new JButton("Exibir!");
    
    TratEventos trat = new TratEventos();
    
    texto.addActionListener(trat);
    btn.addActionListener(trat);
    
    tela.add(rotulo);
    tela.add(texto);
    tela.add(btn);
    
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Eventos2 app = new Eventos2();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class TratEventos implements ActionListener{
  	public void actionPerformed(ActionEvent evento){
  	  String txt = "A nome da classe do componente em que o evento " +
  	               "\nocorreu é: " + evento.getSource().getClass();
  	                
  	  JOptionPane.showMessageDialog(null, txt);   
  	}
  } 
}