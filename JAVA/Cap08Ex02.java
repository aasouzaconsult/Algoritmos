// FRAME (QUADRO)

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cap08Ex02 {
    public static void main(String s[]) {
        JFrame Cap08Ex02 = new JFrame();
        Cap08Ex02.setTitle("Exemplo de Frame.");
 		Cap08Ex02.setSize(200,200);
        Cap08Ex02.show();

        Cap08Ex02.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
    
                   System.exit(0);
      		}
		});
    }
}