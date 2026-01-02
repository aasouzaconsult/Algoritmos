/**----------------------------------------------------------------------*/
/** Exemplo de captura de eventos de janela.                             */
/** Usa classe adaptadora WindowAdapter e codifica apenas os métodos     */
/** não vazios, facilitando a codificação.                               */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

import java.awt.*;
import java.awt.event.*;

public class Windows2 {
  
  public static void main(String[] args){
    final Frame frame = new Frame("Eventos relativos a janelas");
    frame.setSize(300,200);
    frame.setVisible(true);
    frame.addWindowListener(new Captura2(frame));
  }

}

class Captura2 extends WindowAdapter {
  Frame frame;

  Captura2(Frame frame){
    this.frame = frame;
  } 
  
  public void windowIconified(WindowEvent e) { 
    System.out.println(getClass().getName() + ": windowIconified");
  }
  
  public void windowDeiconified(WindowEvent e) { 
    System.out.println(getClass().getName() + ": windowDeiconified");
  }

  public void windowClosing(WindowEvent e) { 
    System.out.println(getClass().getName() + ": windowClosing");
    frame.dispose(); 
    System.exit(0);
  }

}