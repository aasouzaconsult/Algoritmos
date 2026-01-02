import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PainelDesenhaFormas extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.drawRect(10, 10, 80, 80);
        g.drawRoundRect(100, 10, 80, 30, 15, 15);        
        g.setColor(Color.red);
        for (int i = 0; i < 100; i += 3)
            g.drawOval(100, 100, i, i);
    }    
}

class JanelaDesenhaFormas extends JFrame
{
    public JanelaDesenhaFormas()
    {
        setTitle("Desenha Formas");
        setSize(300, 200);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            { System.exit(0); }
        });
        getContentPane().add(new PainelDesenhaFormas());
    }
}

public class DesenhaFormas
{
    public static void main(String args[])
    {
        JanelaDesenhaFormas jdf = new JanelaDesenhaFormas();
        jdf.show();
    }
}
