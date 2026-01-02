/**----------------------------------------------------------------------*/
/** Classes usadas por programas que querem funcionar tanto como applets */
/** quanto como aplicativos.                                             */
/** Usa classe adaptadora WindowAdapter evitando a codificação de        */
/** métodos vazios, através de uma classe anônima interna.               */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

import java.awt.*;
import java.awt.event.*;

class Janela3 extends Frame {
    
   public Janela3(String s) {
     super(s);
     addWindowListener(
       new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
           System.exit(0);
         }      
       }
     );
   }
}
