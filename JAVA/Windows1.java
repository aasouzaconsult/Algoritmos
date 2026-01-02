import java.awt.*;
import java.awt.event.*;

public class Windows1 {
  
  public static void main(String[] args){
    final Frame frame = new Frame("Eventos relativos a janelas");
    frame.setSize(300,200);
    frame.setVisible(true);
    frame.addWindowListener(new Captura1(frame));
  }

}

class Captura1 implements WindowListener {
  Frame frame;

  Captura1(Frame frame){
    this.frame = frame;
  }

  public void windowClosed(WindowEvent e) { // Quando se executa dispose()
    System.out.println(getClass().getName() + ": windowClosed");
    System.exit(0);
  }
  
  public void windowIconified(WindowEvent e) { // Quando é minimizada
    System.out.println(getClass().getName() + ": windowIconified");
  }
  
  public void windowOpened(WindowEvent e){ // Quando se torna visível
    System.out.println(getClass().getName() + ": windowOpened");
  }

  public void windowClosing(WindowEvent e) { // Quando usuário fecha 
    System.out.println(getClass().getName() + ": windowClosing");
    frame.dispose();  
  }

  public void windowDeiconified(WindowEvent e) { // Quando volta ao normal
    System.out.println(getClass().getName() + ": windowDeiconified");
  }

  public void windowActivated(WindowEvent e) { // Quando recebe o foco
    System.out.println(getClass().getName() + ": windowActivated");
  }

  public void windowDeactivated(WindowEvent e) { // Quando perde o foco
    System.out.println(getClass().getName() + ": windowDeactivated");
  }

}
