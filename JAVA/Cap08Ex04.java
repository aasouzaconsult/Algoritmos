// JTEXTFIELD

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cap08Ex04 extends JPanel {

    JTextField c1;

    public Cap08Ex04() {
        
 
        c1 = new JTextField("",20);
        add(c1);
    
    }

    public static void main(String[] args) {
        JFrame Cap08Ex04 = new JFrame("Exemplo de TEXTFIELD");

        Cap08Ex04.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Cap08Ex04.setContentPane(new Cap08Ex04());
        Cap08Ex04.setSize(300,80);
        Cap08Ex04.show();
    }
}
