import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PlafPanel extends JPanel implements ActionListener
{
    private JButton metalButton;
    private JButton motifButton;
    private JButton windowsButton;

    public PlafPanel()
    {
        metalButton = new JButton("Metal");
        motifButton = new JButton("Motif");
        windowsButton = new JButton("Windows");
        add(metalButton);
        add(motifButton);
        add(windowsButton);
        metalButton.addActionListener(this);
        motifButton.addActionListener(this);
        windowsButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt)
    {
        Object source = evt.getSource();
        String plaf = "";
        if (source == metalButton)
            plaf = "javax.swing.plaf.metal.MetalLookAndFeel";
        if (source == motifButton)
            plaf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        if (source == windowsButton)
            plaf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"; 
        try {
            UIManager.setLookAndFeel(plaf);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {}
    }
}

class PlafFrame extends JFrame
{
    public PlafFrame()
    {
        setTitle("Plaf Teste");
        setSize(300, 200);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            { System.exit(0); } 
        });
        getContentPane().add(new PlafPanel());
    }
}

public class PlafTeste
{
    public static void main(String args[])
    {
        PlafFrame pf = new PlafFrame();
        pf.show();
    }
}
