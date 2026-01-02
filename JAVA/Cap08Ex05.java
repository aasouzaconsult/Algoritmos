// JBUTTON

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cap08Ex05 extends JPanel {

    JButton b1;

    public Cap08Ex05() {
        
        b1 = new JButton("PROCURAR");
        add(b1);
    
    }

    public static void main(String[] args) {
        JFrame Cap08Ex05 = new JFrame("Exemplo de JButton");

        Cap08Ex05.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        

        Cap08Ex05.setContentPane(new Cap08Ex05());
        Cap08Ex05.setSize(300,80);
        Cap08Ex05.show();
    }
}
