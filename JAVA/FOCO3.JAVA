/*
 * Direcionando o Foco ao pressionar a tecla ENTER
  */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Foco3 extends JFrame{
  JTextField caixa1, caixa2, caixa3;
  
  public Foco3(){
    super("Direcionando o foco ao pressionar Enter");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    TratadorEventos trat = new TratadorEventos();
    
    caixa1 = new JTextField(10);
    caixa2 = new JTextField(10);
    caixa3 = new JTextField(10);
    
    tela.add(caixa1);
    tela.add(caixa2);
    tela.add(caixa3);
    
    for(int i = 0; i < tela.getComponentCount(); i++){
      Component comp = tela.getComponent(i);
      if(comp.getClass().getName().equals("javax.swing.JTextField")){
        ((JTextField)(comp)).addActionListener(trat);
      }
    }
    
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Foco3 app = new Foco3();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class TratadorEventos implements ActionListener{
    public void actionPerformed(ActionEvent e){
      ((JComponent)(e.getSource())).transferFocus(); 
    }
  }
}