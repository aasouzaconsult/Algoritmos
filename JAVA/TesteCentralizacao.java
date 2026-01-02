import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JanelaCentralizada extends JFrame
{
    public JanelaCentralizada()
    {
        setTitle("Janela Centralizada");
        addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    System.exit(0);
                }
            });
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int alturaTela = d.height;
        int larguraTela = d.width;
        setSize(larguraTela / 2, alturaTela / 2);
        setLocation(larguraTela / 4, alturaTela / 4);
        Image img = tk.getImage("icon.gif");
        setIconImage(img);
    }
}

public class TesteCentralizacao
{
    public static void main(String args[])
    {
        JanelaCentralizada jc = new JanelaCentralizada();
        jc.show();
    }
}
