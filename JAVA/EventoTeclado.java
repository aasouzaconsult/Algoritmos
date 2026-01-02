import java.awt.*;
import java.awt.event.*;

public class EventoTeclado extends Frame implements KeyListener
{
    private Point start = new Point(0, 0);
    private Point end = new Point(0, 0);

    public EventoTeclado()
    {
        addKeyListener(this);
    }

    public void keyPressed(KeyEvent evt)
    {
        int keyCode = evt.getKeyCode(); 
        int d;
        if (evt.isShiftDown())
            d = 5;
        else
            d = 1;
        if (keyCode == KeyEvent.VK_LEFT) add(-d, 0);
        if (keyCode == KeyEvent.VK_RIGHT) add(d, 0);
        if (keyCode == KeyEvent.VK_UP) add(0, -d);
        if (keyCode == KeyEvent.VK_DOWN) add(0, d);
    }

    public void keyReleased(KeyEvent evt)
    {}

    public void keyTyped(KeyEvent evt)
    {}

    public void add(int dx, int dy)
    {
        end.x += dx;
        end.y += dy;
        Graphics g = getGraphics();
        g.drawLine(start.x, start.y, end.x, end.y);
        g.dispose();
        start.x = end.x;
        start.y = end.y;
    }

    public static void main(String args[])
    {
        EventoTeclado et = new EventoTeclado();
        et.setSize(300, 200);
        et.show();
    }
}
