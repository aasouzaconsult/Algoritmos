import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Janela extends JFrame
{
    JTextField tfCampo1, tfCampo2, tfResultado;

    public Janela()
    {
        setTitle("Usando Componentes e Manipulando Eventos");

        JLabel lValor1 = new JLabel("Primeiro Valor");
        JLabel lValor2 = new JLabel("Segundo valor");
        JButton bSomar = new JButton("Calcular");
        tfCampo1 = new JTextField("0");
        tfCampo2 = new JTextField("0");
        tfResultado = new JTextField();
        tfResultado.setEditable(false);
        bSomar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                int v1 = Integer.parseInt(tfCampo1.getText());
                int v2 = Integer.parseInt(tfCampo2.getText());
                tfResultado.setText(String.valueOf(v1 + v2));
            }
        });

        Container c = getContentPane();
        c.setLayout(new GridLayout(3, 2));
        c.add(lValor1);
        c.add(tfCampo1);
        c.add(lValor2);
        c.add(tfCampo2);
        c.add(bSomar);
        c.add(tfResultado);
        pack();
    }
}
public class UsandoComponentes
{
    public static void main(String arguments[])
    {
        Janela j = new Janela();
        j.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            } });
        j.show();
    }
}

