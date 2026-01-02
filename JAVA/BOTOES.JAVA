import javax.swing.*;
import java.awt.*;

public class Botoes extends JFrame{
  public Botoes(){
    super("Uso de objetos da classe JButton");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    ImageIcon icone = new ImageIcon("java_exemplos/imagens/diretorio.gif");//diretorio
    ImageIcon icone2 = new ImageIcon("java_exemplos/imagens/box.gif");
    
    JButton but1 = new JButton("Clique Aqui");
    JButton but2 = new JButton("Clique", icone);
    JButton but3 = new JButton(icone2);
    
    tela.add(but1);
    tela.add(but2);
    tela.add(but3);
    
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Botoes app = new Botoes();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}