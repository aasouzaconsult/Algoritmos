/**----------------------------------------------------------------------*/
/** Classes usadas por programas que querem funcionar tanto como applets */
/** quanto como aplicativos.                                             */
/** Usa classe adaptadora WindowAdapter evitando a codificação de        */
/** métodos vazios.                                                      */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

import java.awt.*;
import java.awt.event.*;

class Janela2 extends Frame {
    
   public Janela2(String s) {
     super(s);
     addWindowListener(new OuveJanela());
   }
}

class OuveJanela extends WindowAdapter {

  public void windowClosing(WindowEvent e) {
    System.exit(0);
  }

}