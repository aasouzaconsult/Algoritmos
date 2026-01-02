import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Confirmar extends JFrame{
  public Confirmar(){
    super("Usando diálogos de confirmação");
 
    setSize(300, 200);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    final Confirmar app = new Confirmar();
    app.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    
    app.addWindowListener(
      new WindowAdapter(){
        public void windowClosing(WindowEvent e){
          int status = JOptionPane.showConfirmDialog(null,
            "Deseja mesmo fechar o aplicativo?", "Fechar", JOptionPane.YES_NO_OPTION);
            
          if(status == JOptionPane.YES_OPTION)
            System.exit(0);
        }	
      }	
    );
  }
}