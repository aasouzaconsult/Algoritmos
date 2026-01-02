import javax.swing.*;
import java.awt.*;

public class Controles3 extends JFrame{
  Container tela;
  
  public Controles3(){
    super("Adicionando controles à janela");
 
    tela = getContentPane();
    
    FlowLayout layout = new FlowLayout();
    layout.setAlignment(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    JLabel rotulo = new JLabel("Seu Nome:");
    JTextField nome = new JTextField(10);
    JButton btn = new JButton("OK!");
    tela.add(rotulo);
    tela.add(nome);
    tela.add(btn);
    
    setLocation(280,235);
    setSize(300,100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Controles3 app = new Controles3();
    
    int quant = app.tela.getComponentCount();
    JOptionPane.showMessageDialog(null, "Numero de Controles: " + quant);
    
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  } 
}