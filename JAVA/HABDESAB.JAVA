import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HabDesab extends JFrame{
  JTextField caixa;
  JButton hab, desab;
  
  public HabDesab(){
    super("Habilitando e desabilitando componentes");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    TratadorEventos trat = new TratadorEventos();
    
    caixa = new JTextField("Digite aqui...", 10);
    caixa.setEnabled(false);
    
    hab = new JButton("Habilitar");
    hab.addActionListener(trat);
    
    desab = new JButton("Desabilitar");
    desab.addActionListener(trat);
    
    tela.add(caixa);
    tela.add(hab);
    tela.add(desab);
    
    setSize(350, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    HabDesab app = new HabDesab();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class TratadorEventos implements ActionListener{
    public void actionPerformed(ActionEvent evento){
      if(evento.getSource() == hab){
        caixa.setEnabled(true);
      }
      else{
        caixa.setEnabled(false);
      }
    }
  }
}