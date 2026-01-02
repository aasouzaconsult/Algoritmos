import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PainelMouse extends JPanel implements MouseMotionListener
{
    public PainelMouse()
    {
        addMouseMotionListener(this);
    }
    public void mouseDragged(MouseEvent evt)
    {
        Graphics g = getGraphics();
        g.drawRect(evt.getX(), evt.getY(), 1, 1);
        g.dispose();
    }
    public void mouseMoved(MouseEvent evt)
    {
        System.out.println("x:" + evt.getX() + ", y:" +  evt.getY());
    }
}

class JanelaMouse extends JFrame
{
    public JanelaMouse()
    {
        setSize(300, 300);
        getContentPane().add(new PainelMouse());
    }
}

public class DesenhoMouse
{
    public static void main(String args[])
    {
        JanelaMouse jm = new JanelaMouse();
        jm.show();
    }
}
