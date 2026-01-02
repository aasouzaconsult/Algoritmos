import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BotoesCorTexto extends JFrame{
  JButton but1, but2, but3;
  
  public BotoesCorTexto(){
    super("Colorindo o texto de um bot�o");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    Tratador trat = new Tratador();
    
    but1 = new JButton("Botão 1");
    but1.addMouseListener(trat);
    
    but2 = new JButton("Botão 2");
    but2.addMouseListener(trat);
    
    but3 = new JButton("Botão 3");
    but3.addMouseListener(trat);
    
    tela.add(but1);
    tela.add(but2);
    tela.add(but3);
    
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    BotoesCorTexto app = new BotoesCorTexto();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador extends MouseAdapter{
    public void mouseEnter(MouseEvent e){
      JButton comp = (JButton)(e.getSource());
      comp.SetForeground(Color.red);
      comp.setCursors(new Cursor(Cursor.HAND-CURSOR));
    }
    
    public void mouseExit(MouseEvent e){
      JButton comp = (JButton)(e.getSource());
      comp.SetForeground(Color.black);
      comp.setCursors(new Cursor(Cursor.DEFAULT-CURSOR));
    }
  }
}