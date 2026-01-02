import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class CaixaSelecaoEvento extends JFrame{
  JPanel meio;
  JLabel status;
  
  public CaixaSelecaoEvento(){
    super("Uso da classe JCheckBox");
 
    Container tela = getContentPane();
    
    BorderLayout layout = new BorderLayout();
    tela.setLayout(layout);
    
    JLabel rotulo = new JLabel("Quais suas linguagens favoritas?");
    
    JCheckBox primeira = new JCheckBox("Java");
    primeira.setMnemonic(KeyEvent.VK_J);
    
    JCheckBox segunda = new JCheckBox("C++");
    segunda.setMnemonic(KeyEvent.VK_C);
    
    JCheckBox terceira = new JCheckBox("Perl");
    terceira.setMnemonic(KeyEvent.VK_P);
    
    JCheckBox quarta = new JCheckBox("Delphi");
    quarta.setMnemonic(KeyEvent.VK_D);
    
    JPanel superior = new JPanel();
    superior.setLayout(new FlowLayout(FlowLayout.LEFT));
    superior.add(rotulo);
    
    meio = new JPanel();
    meio.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
    meio.add(primeira);
    meio.add(segunda);
    meio.add(terceira);
    meio.add(quarta);
    
    for(int i = 0; i < meio.getComponentCount(); i++){
      Component comp = meio.getComponent(i);
        
      if(comp.getClass().getName().equals("javax.swing.JCheckBox"))
        ((JCheckBox)(comp)).addChangeListener(
          new ChangeListener(){
            public void stateChanged(ChangeEvent e){
              String texto = "";
              JCheckBox ref = ((JCheckBox)(e.getSource()));
              
              if(ref.isSelected())
                texto += "Opção " + ref.getText() + " foi marcada.";
              else
                texto += "Opção " + ref.getText() + " foi desmarcada.";
                
              status.setText(texto); 
            }
          }
        );
    }
    
    
    status = new JLabel(" ");
    JPanel inferior = new JPanel();
    inferior.setLayout(new FlowLayout(FlowLayout.LEFT));
    inferior.add(status);
    
    tela.add(superior, BorderLayout.NORTH);
    tela.add(meio, BorderLayout.CENTER);
    tela.add(inferior, BorderLayout.SOUTH);
    
    pack();
    setVisible(true);  
  }
  
  public static void main(String args[]){
    CaixaSelecaoEvento app = new CaixaSelecaoEvento();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}