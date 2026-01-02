import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class UsandoTimer extends Frame implements ActionListener
{
    public UsandoTimer()
    {           
        setBackground(Color.white);
        setTitle("Círculos aleatórios usando Timer");
        Timer t = new Timer(200, this);
        t.start();
    }

    public void actionPerformed(ActionEvent evt)
    {
        Graphics g = getGraphics();
        Graphics2D g2 = (Graphics2D)g;
        Random r = new Random();
        int tx = getWidth();
        int ty = getHeight();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(r.nextFloat() * 5));
        GradientPaint redtowhite = new GradientPaint(0, 0, Color.green,
                                               tx, ty, Color.black);
        g2.setPaint(redtowhite);
        g2.draw(new Ellipse2D.Double(r.nextInt(tx), r.nextInt(ty),
                                     r.nextInt(tx), r.nextInt(ty)));     
    }

    public static void main(String args[])
    {
        UsandoTimer ut = new UsandoTimer();
        ut.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            { System.exit(0); }
        });
        ut.setSize(470, 300);
        ut.show();
    }
}

