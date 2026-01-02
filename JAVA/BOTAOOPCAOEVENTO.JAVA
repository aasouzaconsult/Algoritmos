import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class BotaoOpcaoEvento extends JFrame{
  JPanel meio;
  JLabel status;
  
  public BotaoOpcaoEvento(){
    super("Uso da classe JRadioButton");
 
    Container tela = getContentPane();
    
    BorderLayout layout = new BorderLayout();
    tela.setLayout(layout);
    
    JLabel rotulo = new JLabel("Qual sua linguagem favorita?");
    
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
    
    JPanel superior = new JPanel();
    superior.setLayout(new FlowLayout(FlowLayout.LEFT));
    superior.add(rotulo);
    
    meio = new JPanel();
    meio.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
    meio.add(primeiro);
    meio.add(segundo);
    meio.add(terceiro);
    meio.add(quarto);
    
    for(int i = 0; i < meio.getComponentCount(); i++){
      Component comp = meio.getComponent(i);
        
      if(comp.getClass().getName().equals("javax.swing.JRadioButton"))
        ((JRadioButton)(comp)).addItemListener(
          new ItemListener(){
            public void itemStateChanged(ItemEvent e){
              String texto = "";
              JRadioButton ref = ((JRadioButton)(e.getSource()));
              
              if(ref.isSelected())
                texto += "Opção " + ref.getText() + " foi marcada.";
                
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
    setSize(300,200);
    setLocation(280,235);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    BotaoOpcaoEvento app = new BotaoOpcaoEvento();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}