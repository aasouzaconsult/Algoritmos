import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*; 

public class BotaoOpcaoPainel extends JFrame{
  JPanel superior;
  
  public BotaoOpcaoPainel(){
    super("Uso da classe JPanel");
 
    Container tela = getContentPane();
    
    BorderLayout layout = new BorderLayout();
    tela.setLayout(layout);
    
    Tratador trat = new Tratador();
    
    JRadioButton primeiro = new JRadioButton("Java");
    primeiro.setMnemonic(KeyEvent.VK_J);
    
    JRadioButton segundo = new JRadioButton("C++");
    segundo.setMnemonic(KeyEvent.VK_C);
    
    JRadioButton terceiro = new JRadioButton("Perl");
    terceiro.setMnemonic(KeyEvent.VK_P);
    
    JRadioButton quarto = new JRadioButton("Delphi");
    quarto.setMnemonic(KeyEvent.VK_D);
    
    ButtonGroup grupo = new ButtonGroup();
    grupo.add(primeiro);
    grupo.add(segundo);
    grupo.add(terceiro);
    grupo.add(quarto);
    primeiro.setSelected(true);
    
    JButton ok = new JButton("Responder");
    ok.addActionListener(trat);
    
    String titulo = "Qual sua linguagem favorita?";
    Border etched = BorderFactory.createEtchedBorder();
    Border border = BorderFactory.createTitledBorder(etched, titulo);
    
    superior = new JPanel();
    superior.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    superior.setBorder(border);
    
    superior.add(primeiro);
    superior.add(segundo);
    superior.add(terceiro);
    superior.add(quarto);
    
    JPanel inferior = new JPanel();
    inferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
    inferior.add(ok);
    
    tela.add(superior, BorderLayout.NORTH);
    tela.add(inferior, BorderLayout.SOUTH);
    
    pack();
    setVisible(true);  
  }
  
  public static void main(String args[]){
    BotaoOpcaoPainel app = new BotaoOpcaoPainel();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
  	public void actionPerformed(ActionEvent e){
      String escolha = "";
      
      for(int i = 0; i < superior.getComponentCount(); i++){
        Component comp = superior.getComponent(i);
        
        if(comp.getClass().getName().equals("javax.swing.JRadioButton"))
          if(((JRadioButton)(comp)).isSelected())
            escolha += ((JRadioButton)(comp)).getText() + "\n";
      }
      
      JOptionPane.showMessageDialog(null, escolha);
  	}
  }
}