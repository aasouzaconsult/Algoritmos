import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menus2 extends JFrame{
  JTextArea areaTexto;
  JMenuItem sair, recortar, copiar, colar, selecionar;
  
  public Menus2(){
    super("Usando menus em aplicativos Java");
 
    Container tela = getContentPane();
  
    areaTexto = new JTextArea();
    areaTexto.setLineWrap(true);
    areaTexto.setWrapStyleWord(true);
    JScrollPane painelRolagem = new JScrollPane(areaTexto);
    tela.add(painelRolagem);
    
    JMenuBar barra = new JMenuBar();
    setJMenuBar(barra);
    
    JMenu arquivo = new JMenu("Arquivo");
    arquivo.setMnemonic(KeyEvent.VK_A);
    
    Tratador trat = new Tratador();
    
    sair = new JMenuItem("Sair");
    sair.setMnemonic(KeyEvent.VK_R);
    sair.addActionListener(trat);
    arquivo.add(sair);
    
    JMenu editar = new JMenu("Editar");
    editar.setMnemonic(KeyEvent.VK_E);
    
    recortar = new JMenuItem("Recortar");
    recortar.setMnemonic(KeyEvent.VK_T);
    recortar.addActionListener(trat);
    
    copiar = new JMenuItem("Copiar");
    copiar.setMnemonic(KeyEvent.VK_C);
    copiar.addActionListener(trat);
    
    colar = new JMenuItem("Colar");
    colar.setMnemonic(KeyEvent.VK_O);
    colar.addActionListener(trat);
    
    selecionar = new JMenuItem("Selecionar Tudo");
    selecionar.setMnemonic(KeyEvent.VK_S);
    selecionar.addActionListener(trat);
    
    editar.add(recortar);
    editar.add(copiar);
    editar.add(colar);
    editar.addSeparator();
    editar.add(selecionar);
    
    barra.add(arquivo);
    barra.add(editar);
    
    setSize(300, 150);
    setVisible(true);
  }
  
  public static void main(String args[]){
    Menus2 app = new Menus2();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
  	public void actionPerformed(ActionEvent e){
  	  if(e.getSource() == sair)
  	    System.exit(0);
  	  else if(e.getSource() == selecionar)
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