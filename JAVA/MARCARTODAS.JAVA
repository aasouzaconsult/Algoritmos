import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MarcarTodas extends JFrame{
  JPanel meio;
  
  public MarcarTodas(){
    super("Uso da classe JCheckBox");
 
    Container tela = getContentPane();
    
    BorderLayout layout = new BorderLayout();
    tela.setLayout(layout);
    
    Tratador tratador = new Tratador();
    
    JLabel rotulo = new JLabel("Quais cidades você visitou este ano?");
    
    JCheckBox primeira = new JCheckBox("Nova York");
    primeira.setMnemonic(KeyEvent.VK_N);
    
    JCheckBox segunda = new JCheckBox("Rio de Janeiro");
    segunda.setMnemonic(KeyEvent.VK_R);
    
    JCheckBox terceira = new JCheckBox("Curitiba");
    terceira.setMnemonic(KeyEvent.VK_C);
    
    JCheckBox quarta = new JCheckBox("Salvador");
    quarta.setMnemonic(KeyEvent.VK_S);
    
    JPanel superior = new JPanel();
    superior.setLayout(new FlowLayout(FlowLayout.LEFT));
    superior.add(rotulo);
    
    JButton marcar = new JButton("Marcar Todas");
    marcar.addActionListener(trat);
    
    meio = new JPanel();
    meio.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
    meio.add(primeira);
    meio.add(segunda);
    meio.add(terceira);
    meio.add(quarta);
    
    JPanel inferior = new JPanel();
    inferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
    inferior.add(marcar);
    
    tela.add(superior, BorderLayout.NORTH);
    tela.add(meio, BorderLayout.CENTER);
    tela.add(inferior, BorderLayout.SOUTH);
    
    pack();
    setVisible(true);  
  }
  
  public static void main(String args[]){
    MarcarTodas app = new MarcarTodas();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
  	public void actionPerformed(actionEvent e){
  	  for(int i = 0; i < meio.getComponentCount(); i++){
        Component comp = meio.getComponent(i);
        
        if(comp.getClass().getName().equals("javax.swing.JCheckBox"))
          (JCheckBox)(comp)).setSelected();
      }
  	}
  }
}