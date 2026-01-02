// LABEL

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cap08Ex03 extends JPanel {
    JLabel l1, l2;

    public Cap08Ex03() {
        
        setLayout(new GridLayout(2,1));
        
        l1 = new JLabel("Nome: ",JLabel.LEFT);
        l2 = new JLabel("Telefone: ",JLabel.LEFT);

        add(l1);
        add(l2);
    
    }

    public static void main(String[] args) {
        JFrame Cap08Ex03 = new JFrame("Exemplo de LABEL");

        Cap08Ex03.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Cap08Ex03.setContentPane(new Cap08Ex03());
        Cap08Ex03.setSize(300,80);
        Cap08Ex03.show();
    }
}
