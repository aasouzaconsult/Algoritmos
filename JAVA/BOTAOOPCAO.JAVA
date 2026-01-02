/*
 * Comentário sobre este programa(código)
 *
 *
 *
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BotaoOpcao extends JFrame{
  JPanel meio;
  
  public BotaoOpcao(){
    super("Uso da classe JRadioButton");
 
    Container tela = getContentPane();
    
    BorderLayout layout = new BorderLayout();
    tela.setLayout(layout);
    
    Tratador trat = new Tratador();
    
    JLabel rotulo = new JLabel("Qual sua linguagem favorita?");
    
    JRadioButton primeiro = new JRadioButton("Java");
    primeiro.setMnemonic(KeyEvent.VK_J);
    
    JRadioButton segundo = new JRadioButton("C++");
    segundo.setMnemonic(KeyEvent.VK_C);
    
    JRadioButton terceiro = new JRadioButton("Perl");
    terceiro.setMnemonic(KeyEvent.VK_P);
    
    JRadioButton quarto = new JRadioButton("Delphi ");
    quarto.setMnemonic(KeyEvent.VK_D);
    
    ButtonGroup grupo = new ButtonGroup();
    grupo.add(primeiro);
    grupo.add(segundo);
    grupo.add(terceiro);
    grupo.add(quarto);
    primeiro.setSelected(true);
    
    JPanel superior = new JPanel();
    superior.setLayout(new FlowLayout(FlowLayout.LEFT));
    superior.add(rotulo);
    
    JButton ok = new JButton("Responder");
    ok.addActionListener(trat);
    
    meio = new JPanel();
    meio.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
    meio.add(primeiro);
    meio.add(segundo);
    meio.add(terceiro);
    meio.add(quarto);
    
    JPanel inferior = new JPanel();
    inferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
    inferior.add(ok);
    
    tela.add(superior, BorderLayout.NORTH);
    tela.add(meio, BorderLayout.CENTER);
    tela.add(inferior, BorderLayout.SOUTH);
    
    pack();
    setSize(300,200);
    setLocation(280,235);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    BotaoOpcao app = new BotaoOpcao();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
  	public void actionPerformed(ActionEvent e){
      String escolha = "";
      
      for(int i = 0; i < meio.getComponentCount(); i++){
        Component comp = meio.getComponent(i);
        
        if(comp.getClass().getName().equals("javax.swing.JRadioButton"))
          if(((JRadioButton)(comp)).isSelected())
            escolha += ((JRadioButton)(comp)).getText() + "\n";
      }
      
      JOptionPane.showMessageDialog(null, escolha);
  	}
  }
}