import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuContexto extends JFrame{
  JPopupMenu popup;
  JMenuItem recortar, copiar, colar, selecionar;
  JTextArea areaTexto;
  
  public MenuContexto(){
    super("Usando um menu de contexto");
 
    ImageIcon[] imagens = new ImageIcon[3];
    
    String icones[] = {"imagens/recortar.gif", 
                       "imagens/copiar.gif", 
                       "imagens/colar.gif"};
    
    for(int i = 0; i < icones.length; i++){
       imagens[i] = new ImageIcon(icones[i]); 
    }
    
    Container tela = getContentPane();
  
    areaTexto = new JTextArea();
    areaTexto.setLineWrap(true);
    areaTexto.setWrapStyleWord(true);
    JScrollPane painelRolagem = new JScrollPane(areaTexto);
    tela.add(painelRolagem);
    
    areaTexto.addMouseListener(
      new MouseAdapter(){
        public void mouseReleased(MouseEvent e) {
          if(e.isPopupTrigger())
            popup.show(e.getComponent(), e.getX(), e.getY());
        }
      }
    );
    
    Tratador trat = new Tratador();
    
    popup = new JPopupMenu();
    
    recortar = new JMenuItem("Recortar", imagens[0]);
    recortar.setMnemonic(KeyEvent.VK_T);
    recortar.addActionListener(trat);
    
    copiar = new JMenuItem("Copiar", imagens[1]);
    copiar.setMnemonic(KeyEvent.VK_C);
    copiar.addActionListener(trat);
    
    colar = new JMenuItem("Colar", imagens[2]);
    colar.setMnemonic(KeyEvent.VK_O);
    colar.addActionListener(trat);
    
    selecionar = new JMenuItem("Selecionar Tudo");
    selecionar.setMnemonic(KeyEvent.VK_S);
    selecionar.addActionListener(trat);
    
    popup.add(recortar);
    popup.add(copiar);
    popup.add(colar);
    popup.addSeparator();
    popup.add(selecionar);
    
    setLocation(280,235);
    setSize(300, 150);
    setVisible(true);
  }
  
  public static void main(String args[]){
    MenuContexto app = new MenuContexto();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if(e.getSource() == selecionar)
        areaTexto.selectAll();
      else if(e.getSource() == recortar)
        areaTexto.cut();
      else if(e.getSource() == copiar)
        areaTexto.copy();
      else if(e.getSource() == colar)
        areaTexto.paste();
        
      repaint();  
    } 
  }
}