/**----------------------------------------------------------------------*/
/** Calculadora (muito) simples implementa as quatro operações.          */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculadora extends JFrame implements ActionListener {
  JTextField visor;
  double arg = 0;
  char op = '=';
  boolean nova = true;
  JButton igual; 
  
  public Calculadora() {
    Font fonte = new Font("Courier",Font.BOLD,16);
    
    visor = new JTextField("0");
    visor.setFont(fonte);
    visor.setEditable(false);
    visor.setBackground(Color.white);
      
    JPanel centro = new JPanel(new GridLayout(4,4,14,14));
    centro.setBackground(Color.orange);
    String botoes = "789/456*123-0.=+";

    for (int i = 0; i < botoes.length(); ++i) {
      char simbolo = botoes.charAt(i);
      JButton botao = new JButton(String.valueOf(simbolo));
      botao.setFont(fonte);
      if (simbolo >= '0' && simbolo <= '9') 
        botao.setForeground(Color.white);
      else botao.setForeground(Color.yellow);
      botao.setBackground(Color.gray);
      if (simbolo == '=') igual = botao;
      centro.add(botao);
      botao.addActionListener(this);
    }

    Container c = getContentPane();
    c.setLayout(new BorderLayout(0,20));
    c.setBackground(new Color(238,238,238));

    c.add(visor,BorderLayout.NORTH);    
    c.add(centro,BorderLayout.CENTER);

    setSize(300,350);
    setResizable(false);
    setVisible(true);
  
  }

  public void actionPerformed(ActionEvent e) {
    char c = e.getActionCommand().charAt(0); 
    if (c >= '0' && c <= '9' || c == '.') {
      if (nova) visor.setText(String.valueOf(c));
      else {
         String estado = visor.getText();
         if (c != '.' || estado.indexOf('.') < 0)
           visor.setText(estado + c);
      }
      nova = false;
    }
    else {
      if (nova)
        if (c == '-') {
          visor.setText("-");
          nova = false;
        }
        else op = c;
      else {
        double x = Double.parseDouble(visor.getText());
        calcula(x);
        op = c;
        nova = true;
      }
    }
  }
   
  private void calcula(double n) {
    if (op == '+') arg += n;
    else if (op == '-') arg -= n;
    else if (op == '*') arg *= n;
    else if (op == '/') arg /= n;
    else if (op == '=') arg = n;
    visor.setText(String.valueOf(arg));
  }

  public static void main(String[] s) {
    Calculadora app = new Calculadora();
	  app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  }

}
