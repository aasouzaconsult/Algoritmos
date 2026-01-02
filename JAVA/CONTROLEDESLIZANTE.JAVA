import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;

public class ControleDeslizante extends JFrame{
  JTextField caixa;
  int valor;
  
  public ControleDeslizante(){
    super("Uso do controle JSlider");
 
    Container tela = getContentPane();
    tela.setLayout(new FlowLayout());
    
    JLabel rotulo = new JLabel("Valor:");
    caixa = new JTextField("0", 5);
    caixa.setEditable(false);
    
    JSlider cDeslizante = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
    
    cDeslizante.setMajorTickSpacing(2);
    cDeslizante.setMinorTickSpacing(1);
    cDeslizante.setPaintTicks(true);
    cDeslizante.setPaintLabels(true);
    cDeslizante.setSnapToTicks(true);
    
    cDeslizante.addChangeListener(
      new ChangeListener(){
        public void stateChanged(ChangeEvent e) {
          JSlider comp = (JSlider) e.getSource();
          
          if(!comp.getValueIsAdjusting())
            valor = comp.getValue();
            caixa.setText((new Integer(valor)).toString());
        }
      }
    );
    
    tela.add(rotulo);
    tela.add(caixa);
    tela.add(cDeslizante);
 
    pack();
    setVisible(true);
  }
  
  public static void main(String args[]){
    ControleDeslizante app = new ControleDeslizante();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}