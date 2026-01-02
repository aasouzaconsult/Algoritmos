/**----------------------------------------------------------------------*/
/** Classe usada por programas que querem funcionar tanto como applets   */
/** quanto como aplicativos.                                             */
/** É mais cômodo escutar os eventos de janela através de uma subclasse  */
/** de WindowAdapter) evitando a codificação dos métodos vazios; veja    */
/** como fazer isso em JANELA2.JAVA e JANELA3.JAVA                       */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

import java.awt.*;
import java.awt.event.*;

class Janela1 extends Frame implements WindowListener {
    
   public Janela1(String s) {
     super(s);
     addWindowListener(this);
   }

  public void windowOpened(WindowEvent e) {}
  public void windowClosed(WindowEvent e) {}
  public void windowIconified(WindowEvent e) {}
  public void windowDeiconified(WindowEvent e) {}
  public void windowActivated(WindowEvent e) {}
  public void windowDeactivated(WindowEvent e) {}

  public void windowClosing(WindowEvent e) {
    System.exit(0);
  }

}