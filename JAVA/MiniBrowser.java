import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class MiniBrowser extends Frame 
{
    private TextArea ta;
    private TextField f;

    public MiniBrowser()
    {
        setTitle("Mini Browser");
        Button b = new Button("Ok");
        b.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    ta.setText("");
                    URL url = new URL(f.getText());
                    DataInputStream dis = new DataInputStream(url.openStream());
                    String line;
                    while ((line = dis.readLine()) != null)
                        ta.append(line + "\n");
                }
                catch (IOException e)
                {
                    ta.setText("Erro: " + e.getMessage());
                }

            }
        });
        add(b, BorderLayout.SOUTH);
        f = new TextField();
        add(f, BorderLayout.NORTH);
        ta = new TextArea(); 
        ta.setEditable(false);
        add(ta, BorderLayout.CENTER);
    }

    public static void main(String args[])
    {
        MiniBrowser mb = new MiniBrowser();
        mb.setSize(500, 300);
        mb.show();
    }
}
