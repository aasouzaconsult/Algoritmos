/*
 * GuiasPaneTest.java
 *
 * Created on 24 de Setembro de 2004, 10:05
 */

/**
 *
 * @author  claudemir
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class GuiasPaneTest {
    public static void main(String args[])
    {
        JFrame frame = new GuiasPaneTestFrame();
        frame.show();
    }
    
}

class GuiasPaneTestFrame extends JFrame implements ChangeListener {
    
    public GuiasPaneTestFrame()
    {
        setTitle("Guias de Janela");
        setSize(400,300);
        addWindowListener(new WindowAdapter()
        {
            public void WindowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        
        tabbedPane = new JTabbedPane();
        tabbedPane.addChangeListener(this);
        
        /*
         * configuramos os componentes para null e atrasamos seu
         * carregamento até que a guia seja mostrada pela primeira vez
         */
        
        
        
    
    
    
    public void stateChanged (ChangeEvent e)
    {
    }
    
}
