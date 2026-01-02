import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CaixaSelecao extends JFrame{
  JPanel meio;
  
  public CaixaSelecao(){
    super("Uso da classe JCheckBox");
 
    Container tela = getContentPane();
    
    BorderLayout layout = new BorderLayout();
    tela.setLayout(layout);
    
    Tratador trat = new Tratador();
    
    JLabel rotulo = new JLabel("Quais suas linguagens favoritas?");
    
    JCheckBox primeira = new JCheckBox("Java");
    primeira.setMnemonic(KeyEvent.VK_J);
    primeira.setSelected(true);
    
    JCheckBox segunda = new JCheckBox("C++");
    segunda.setMnemonic(KeyEvent.VK_C);
    
    JCheckBox terceira = new JCheckBox("Perl");
    terceira.setMnemonic(KeyEvent.VK_P);
    
    JCheckBox quarta = new JCheckBox("Delphi");
    quarta.setMnemonic(KeyEvent.VK_D);
    
    JPanel superior = new JPanel();
    superior.setLayout(new FlowLayout(FlowLayout.LEFT));
    superior.add(rotulo);
    
    JButton ok = new JButton("Responder");
    ok.addActionListener(trat);
    
    meio = new JPanel();
    meio.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
    meio.add(primeira);
    meio.add(segunda);
    meio.add(terceira);
    meio.add(quarta);
    
    JPanel inferior = new JPanel();
    inferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
    inferior.add(ok);
    
    tela.add(superior, BorderLayout.NORTH);
    tela.add(meio, BorderLayout.CENTER);
    tela.add(inferior, BorderLayout.SOUTH);
    
    pack();
    setVisible(true);  
  }
  
  public static void main(String args[]){
    CaixaSelecao app = new CaixaSelecao();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
  	public void actionPerformed(ActionEvent e){
  	  String escolhas = "";
  	  
      for(int i = 0; i < meio.getComponentCount(); i++){
        Component comp = meio.getComponent(i);
        
        if(comp.getClass().getName().equals("javax.swing.JCheckBox"))
          if(((JCheckBox)(comp)).isSelected())
            escolhas += ((JCheckBox)(comp)).getText() + "\n";
      }
  	  
  	  JOptionPane.showMessageDialog(null, escolhas);
  	}
  }
}