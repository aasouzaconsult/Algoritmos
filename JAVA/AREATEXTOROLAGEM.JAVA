import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AreaTextoRolagem extends JFrame{
  JTextArea areaTexto;
  
  public AreaTextoRolagem(){
    super("Uso da classe JTextArea");
 
    Container tela = getContentPane();
    
    BorderLayout layout = new BorderLayout();
    tela.setLayout(layout);
    
    Tratador trat = new Tratador();
    
    JLabel rotulo = new JLabel("Seu coment�rio:");
    JButton btn = new JButton("Exibir!");
    btn.addActionListener(trat);
    
    areaTexto = new JTextArea(10, 20);
    JScrollPane painelRolagem = new JScrollPane(areaTexto);
    painelRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    painelRolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    
    JPanel pSuperior = new JPanel();
    pSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));
    pSuperior.add(rotulo);
    
    JPanel pCentro = new JPanel();
    pCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
    pCentro.add(painelRolagem);
    
    JPanel pInferior = new JPanel();
    pInferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
    pInferior.add(btn);
    
    tela.add(BorderLayout.NORTH, pSuperior);
    tela.add(BorderLayout.CENTER, pCentro);
    tela.add(BorderLayout.SOUTH, pInferior);
    
    pack();
    setVisible(true);  
  }
  
  public static void main(String args[]){
    AreaTextoRolagem app = new AreaTextoRolagem();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
  	public void actionPerformed(ActionEvent e){
  	  JOptionPane.showMessageDialog(null, areaTexto.getText());
  	}
  }
}