// JLABEL + JTEXTFIELD + JBUTTON

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cap08Ex07 extends JPanel {

	JLabel l1;
	JTextField c1;
    JButton b1;

    public Cap08Ex07() {
        
 		l1 = new JLabel("Nome: ");
 		c1 = new JTextField("",15);
        b1 = new JButton("PROCURAR");
        
        add(l1);
        add(c1);
        add(b1);
    
    }

    public static void main(String[] args) {
        JFrame Cap08Ex07 = new JFrame("Exemplo com JLabel, JTextField e JButton");

        Cap08Ex07.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        

        Cap08Ex07.setContentPane(new Cap08Ex07());
        Cap08Ex07.setSize(400,80);
        Cap08Ex07.show();
    }
}
