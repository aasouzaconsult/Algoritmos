import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menus4 extends JFrame{
  public Menus4(){
    super("Usando menus em aplicativos Java");
 
    ImageIcon[] imagens = new ImageIcon[3];
    
    String icones[] = {"imagens/recortar.gif", 
                       "imagens/copiar.gif", 
                       "imagens/colar.gif"};
    
    for(int i = 0; i < icones.length; i++){
       imagens[i] = new ImageIcon(icones[i]); 
    }
    
    JMenu arquivo = new JMenu("Arquivo");
    arquivo.setMnemonic(KeyEvent.VK_A);
    
    JMenuItem sair = new JMenuItem("Sair");
    sair.setMnemonic(KeyEvent.VK_R);
    arquivo.add(sair);
    
    JMenuBar barra = new JMenuBar();
    setJMenuBar(barra);
    
    JMenu editar = new JMenu("Editar");
    editar.setMnemonic(KeyEvent.VK_E);
    
    JMenuItem recortar = new JMenuItem("Recortar", imagens[0]);
    recortar.setMnemonic(KeyEvent.VK_T);
    
    JMenuItem copiar = new JMenuItem("Copiar", imagens[1]);
    copiar.setMnemonic(KeyEvent.VK_C);
    
    JMenuItem colar = new JMenuItem("Colar", imagens[2]);
    colar.setMnemonic(KeyEvent.VK_O);
    
    editar.add(recortar);
    editar.add(copiar);
    editar.add(colar);
    
    barra.add(arquivo);
    barra.add(editar);
    
    setLocation(280,235);
    setSize(350,200);
    setVisible(true);
  }
  
  public static void main(String args[]){
    Menus4 app = new Menus4();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}