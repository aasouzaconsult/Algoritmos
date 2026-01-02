import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mouse2 extends JFrame{
  JButton btnUm, btnDois;
  JLabel rotulo;
  
  public Mouse2(){
    super("Detectando eventos do mouse");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout);
    
    Tratador trat = new Tratador();
    
    btnUm = new JButton("Botão 1");
    btnUm.addMouseListener(trat);
    
    btnDois = new JButton("Botão 2");
    btnDois.addMouseListener(trat);
    
    rotulo = new JLabel("Informações do evento");
    
    tela.add(btnUm);
    tela.add(btnDois);
    tela.add(rotulo);
    
    setSize(300, 150);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Mouse2 app = new Mouse2();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador extends MouseAdapter{
  	public void mouseClicked(MouseEvent e){
  	  JButton comp = (JButton)(e.getSource());
  	  rotulo.setText("Clique ocorreu no controle: " + comp.getText());
    }
  }
}