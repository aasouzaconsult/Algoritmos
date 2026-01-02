// BOTÃO QUE CONTA O NÚMERO DE CLIQUES

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cap08Ex06 {
    private static String labelPrefix = "Número de cliques no botão: ";
    private int numClicks = 0;

    public Component createComponents() {
        final JLabel label = new JLabel(labelPrefix + "0    ");

        JButton b1 = new JButton(">>> CLIQUE EM MIM <<<");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numClicks++;
                label.setText(labelPrefix + numClicks);
            }
        });
        label.setLabelFor(b1);

        JPanel Cap08Ex06 = new JPanel();
        Cap08Ex06.setBorder(BorderFactory.createEmptyBorder(
                                        30,
                                        30,
                                        10,
                                        30)
                                        );
        Cap08Ex06.setLayout(new GridLayout(0, 1));
        Cap08Ex06.add(b1);
        Cap08Ex06.add(label);

        return Cap08Ex06;
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) { }

        JFrame frame = new JFrame("Outro Exemplo com JButton");
        Cap08Ex06 app = new Cap08Ex06();
        Component contents = app.createComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.show();
    }
}
