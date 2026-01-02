import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Botoes2 extends JFrame{
  public Botoes2(){
    super("Uso de objetos da classe JButton");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    ImageIcon icone = new ImageIcon("java_exemplos/imagens/diretorio.gif");
    ImageIcon icone2 = new ImageIcon("java_exemplos/imagens/box.gif");
    
    JButton but1 = new JButton("Clique Aqui");
    JButton but2 = new JButton("Clique", icone);
    JButton but3 = new JButton(icone2);
    
    TratadorBotoes trat = new TratadorBotoes();
    
    but1.addActionListener(trat);
    but2.addActionListener(trat);
    but3.addActionListener(trat);
    
    tela.add(but1);
    tela.add(but2);
    tela.add(but3);
    
    setLocation(280,235);
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Botoes2 app = new Botoes2();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class TratadorBotoes implements ActionListener{
    public void actionPerformed(ActionEvent evento){
      String texto = ((JButton)(evento.getSource())).getText();
      JOptionPane.showMessageDialog(null, texto);
    }
  }
}