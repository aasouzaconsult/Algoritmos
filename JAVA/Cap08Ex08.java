// JLABEL + JTEXTFIELD + JBUTTON + EVENTO

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cap08Ex08 extends JPanel implements ActionListener {

	JLabel l1;
	JTextField c1;
    JButton b1;

    public Cap08Ex08() {
        
 		l1 = new JLabel("Nome: ");
 		c1 = new JTextField("",15);
        b1 = new JButton("FECHAR");
        
        add(l1);
        add(c1);
        add(b1);
        
        b1.addActionListener(this);
    
    }
    
    public void actionPerformed(ActionEvent evt) {
    	Object source = evt.getSource();
    	System.exit(0);
    }

    public static void main(String[] args) {
        JFrame Cap08Ex08 = new JFrame("Exemplo com JLabel, JTextField e JButton");

        Cap08Ex08.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        

        Cap08Ex08.setContentPane(new Cap08Ex08());
        Cap08Ex08.setSize(400,80);
        Cap08Ex08.show();
    }
}
