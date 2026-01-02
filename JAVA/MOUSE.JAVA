import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mouse extends JFrame{
  JButton btnUm, btnDois;
  JLabel rotulo;
  
  public Mouse(){
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
    
    setLocation(280,235);
    setSize(300, 150);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Mouse app = new Mouse();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements MouseListener{
  	public void mousePressed(MouseEvent e){
  	  JButton comp = (JButton)(e.getSource());
  	  rotulo.setText("Botão pressionado no controle: " + comp.getText());
    }
  
    public void mouseClicked(MouseEvent e){
  	  JButton comp = (JButton)(e.getSource());
  	  rotulo.setText("Clique ocorreu no controle: " + comp.getText());
    }
  
    public void mouseReleased(MouseEvent e){
  	  JButton comp = (JButton)(e.getSource());
  	  rotulo.setText("Botão liberado no controle: " + comp.getText());
    }
  
    public void mouseEntered(MouseEvent e){
  	  JButton comp = (JButton)(e.getSource());
  	  rotulo.setText("Cursor adentrou o controle: " + comp.getText());
    }
  
    public void mouseExited(MouseEvent e){
  	  JButton comp = (JButton)(e.getSource());
  	  rotulo.setText("Cursor saiu do controle: " + comp.getText());
    }
  }
}