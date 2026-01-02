import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menus3 extends JFrame{
  public Menus3(){
    super("Usando menus em aplicativos Java");
 
    JMenuBar barra = new JMenuBar();
    setJMenuBar(barra);
    
    JMenu formatar = new JMenu("Formatar");
    formatar.setMnemonic(KeyEvent.VK_F);
    
    JMenuItem cor = new JMenuItem("Cor de Fundo");
    cor.setMnemonic(KeyEvent.VK_C);
    
    JMenuItem paragrafo = new JMenuItem("Parágrafo");
    paragrafo.setMnemonic(KeyEvent.VK_P);
    
    JMenu fonte = new JMenu("Fonte");
    fonte.setMnemonic(KeyEvent.VK_N);
    
    JMenuItem nome = new JMenuItem("Nome");
    nome.setMnemonic(KeyEvent.VK_N);
    
    JMenuItem estilo = new JMenuItem("Estilo");
    estilo.setMnemonic(KeyEvent.VK_E);
    
    fonte.add(nome);
    fonte.add(estilo); 
    
    formatar.add(cor);
    formatar.add(fonte);
   
    barra.add(formatar);
    
    setLocation(280,235);
    setSize(350,250);
    setVisible(true);
  }
  
  public static void main(String args[]){
    Menus3 app = new Menus3();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}