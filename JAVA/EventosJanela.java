import java.awt.*;
import java.awt.event.*;

public class EventosJanela extends Frame
{
    public EventosJanela()
    {
        setSize(300, 200);              
        setTitle("Tratando eventos de janela");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.out.println("Saindo...");
                System.exit(0);
            }
            public void windowIconified(WindowEvent e)
            {
                System.out.println("Janela foi Minimizada");
            }
            public void windowDeiconified(WindowEvent e)
            {
                System.out.println("Janela foi Maximizada");
            }
            public void windowActivated(WindowEvent e)
            {
                System.out.println("Janela tornou-se ativa");
            }
            public void windowDeactivated(WindowEvent e)
            {
                System.out.println("Janela tornou-se inativa");
            }
        });
    }
  
    public static void main(String args[])
    {
        EventosJanela ej = new EventosJanela();
        ej.show();
    }
}
