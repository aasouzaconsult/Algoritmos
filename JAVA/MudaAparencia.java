// MudaAparencia.java

import javax.swing.*;
import java.awt.*;

class Janela extends JFrame
{
    public Janela()
    {
        Container c = getContentPane();    
        c.setLayout(new GridLayout(2, 2));
        c.add(new JButton("Teste"));
        c.add(new JTextField());
        c.add(new JComboBox());
        c.add(new JRadioButton("Teste"));
        pack();
    }
}

public class MudaAparencia
{
    public static void main(String args[])
    {
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) { }

        Janela j = new Janela();
        j.show();
    }
}
