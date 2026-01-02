import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;

public class Alinhar extends JFrame{
  JTextField caixa;
  JButton esquerda, centro, direita;
  
  public Alinhar(){
    super("Uso de objetos da classe JTextField");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    ImageIcon icone1 = new ImageIcon("java_exemplos/imagens/esquerda.gif");
    ImageIcon icone2 = new ImageIcon("java_exemplos/imagens/centro.gif");
    ImageIcon icone3 = new ImageIcon("java_exemplos/imagens/direita.gif");
    
    TratadorEventos trat = new TratadorEventos();
    
    caixa = new JTextField("Observe este texto", 20);
    caixa.addPropertyChangeListener(
      new PropertyChangeListener(){
        public void propertyChange(PropertyChangeEvent e) {
          String prop = e.getPropertyName();
          
          if(prop.equals("horizontalAlignment")){
            String texto = prop + " = " + e.getNewValue(); 
            setTitle(texto);
          }
        }
      }
    );
    
    esquerda = new JButton(icone1);
    esquerda.setPreferredSize(new Dimension(20, 20));
    esquerda.addActionListener(trat);
    
    centro = new JButton(icone2);
    centro.setPreferredSize(new Dimension(20, 20));
    centro.addActionListener(trat);
    
    direita = new JButton(icone3);
    direita.setPreferredSize(new Dimension(20, 20));
    direita.addActionListener(trat);
    
    tela.add(caixa);
    tela.add(esquerda);
    tela.add(centro);
    tela.add(direita);
    
    setLocation(280,235);
    setSize(350, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Alinhar app = new Alinhar();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class TratadorEventos implements ActionListener{
    public void actionPerformed(ActionEvent evento){
      if(evento.getSource() == esquerda)
        caixa.setHorizontalAlignment(JTextField.LEFT);
      else if(evento.getSource() == centro)
        caixa.setHorizontalAlignment(JTextField.CENTER);
      else
        caixa.setHorizontalAlignment(JTextField.RIGHT);
    }
  }
}