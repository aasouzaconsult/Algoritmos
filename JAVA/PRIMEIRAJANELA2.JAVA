import javax.swing.*;
import java.awt.event.*;

public class PrimeiraJanela2 extends JFrame{
  public PrimeiraJanela2(){
    super("Nossa primeira janela - versão 2");
    
    setLocation(280,235);
    setSize(300, 150);
    setVisible(true);
  }
  
  public static void main(String args[]){
  	PrimeiraJanela2 app = new PrimeiraJanela2();
  	
  	app.addWindowListener(
  	  new WindowAdapter(){
  	  	public void windowClosing(WindowEvent e){
  	  	  String aviso = "A janela será fechada agora";
  	  	  JOptionPane.showMessageDialog(null, aviso);
  	  	  System.exit(0);	
  	  	}
  	  }	
  	);
  } 	
}