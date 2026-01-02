import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class JanelaApplet extends Applet
{
    private Button b1, b2, b3, b4;

    public JanelaApplet()
    {
        b1 = new Button("Abrir");
        add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                Frame f = new Frame();
                f.setLayout(new GridLayout(2, 2));
                f.add(new Label("Nome"));
                f.add(new TextField());
                f.add(new Label("Senha"));
                f.add(new TextField());
                f.setSize(200, 100); 
                f.show();
            }
        });
    }
}
