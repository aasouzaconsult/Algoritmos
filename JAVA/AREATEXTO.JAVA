import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AreaTexto extends JFrame{
  JTextArea areaTexto;
  
  public AreaTexto(){
    super("Uso da classe JTextArea");
 
    Container tela = getContentPane();
    
    BorderLayout layout = new BorderLayout();
    tela.setLayout(layout);
    
    Tratador trat = new Tratador();
    
    JLabel rotulo = new JLabel("Seu comentário:");
    JButton btn = new JButton("Exibir!");
    btn.addActionListener(trat);
    
    areaTexto = new JTextArea(10, 20);
    
    JPanel pSuperior = new JPanel();
    pSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));
    pSuperior.add(rotulo);
    
    JPanel pCentro = new JPanel();
    pCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
    pCentro.add(areaTexto);
    
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
    AreaTexto app = new AreaTexto();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
  	public void actionPerformed(ActionEvent e){
  	  JOptionPane.showMessageDialog(null, areaTexto.getText());
  	}
  }
}