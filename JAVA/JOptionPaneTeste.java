// JOptionPaneTeste.java

import javax.swing.*;

public class JOptionPaneTeste
{
    public static void main(String args[])
    {
        String primeiroNumero, segundoNumero;
        int primeiro, segundo, soma;
 
        primeiroNumero = JOptionPane.showInputDialog("Entre com o primeiro número");
        segundoNumero = JOptionPane.showInputDialog("Entre com o segundo número");

        primeiro = Integer.parseInt(primeiroNumero);
        segundo = Integer.parseInt(segundoNumero);

        soma = primeiro + segundo;

        JOptionPane.showMessageDialog(null, "A soma é " + soma, "Resultado",
            JOptionPane.PLAIN_MESSAGE);

        System.exit(0);
    }
}
