import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Eventos extends JFrame{
  JTextField texto;
  
  public Eventos(){
    super("Introdução ao uso de eventos");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    JLabel rotulo = new JLabel("Texto:");
    texto = new JTextField(10);
    JButton btn = new JButton("Exibir!");
    
    TratEventos trat = new TratEventos();
    btn.addActionListener(trat);
    
    tela.add(rotulo);
    tela.add(texto);
    tela.add(btn);
    
    setLocation(285,250);
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Eventos app = new Eventos();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class TratEventos implements ActionListener{
  	public void actionPerformed(ActionEvent evento){
  	  String txt = "Você digitou: " + texto.getText();
  	  JOptionPane.showMessageDialog(null, txt);   
  	}
  } 
}