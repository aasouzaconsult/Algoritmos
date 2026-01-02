import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NovaJanela extends JFrame{
  Janela janela;
  
  public NovaJanela(){
    super("Uso da classe JDialog");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    JButton abrir = new JButton("Abrir Nova Janela");
    abrir.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          janela = new Janela(null, "Segunda Janela", true);
          janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          janela.setVisible(true);	
        }	
      }	
    );
    
    tela.add(abrir);
    
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    NovaJanela app = new NovaJanela();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void alteraTitulo(String titulo){
  	setTitle(titulo); 
  } 
  
  private class Janela extends JDialog{
  	public Janela(Frame owner, String title, boolean modal){
  	  super(owner, title, modal);
  	  setSize(300, 200);
  	  
  	  addWindowListener(
  	    new WindowAdapter(){
  	  	  public void windowActivated(WindowEvent e){
  	  	    alteraTitulo("Olá, Sou a janela secundária.");	
  	  	  }
  	    }	
  	  );	
  	}
  }
}