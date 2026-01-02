/*
 *
 * Este programa tem como objetivo ensinar ao aluno como inserir Menus
 * e sub-menus , sem funcionalidade de açãosssss
 *
 * @uthor Clademir Queiroz 24 setembro 2004
 *
 */



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menus extends JFrame{
  public Menus(){
    super("Usando menus em aplicativos Java");
 
    JMenuBar barra = new JMenuBar();
    setJMenuBar(barra);
    
    JMenu arquivo = new JMenu("Arquivo");
    arquivo.setMnemonic(KeyEvent.VK_A);
    
    JMenuItem sair = new JMenuItem("Sair");
    sair.setMnemonic(KeyEvent.VK_R);
    arquivo.add(sair);
    
    JMenu editar = new JMenu("Editar");
    editar.setMnemonic(KeyEvent.VK_E);
    
    JMenuItem recortar = new JMenuItem("Recortar");
    recortar.setMnemonic(KeyEvent.VK_T);
    
    JMenuItem copiar = new JMenuItem("Copiar");
    copiar.setMnemonic(KeyEvent.VK_C);
    
    JMenuItem colar = new JMenuItem("Colar");
    colar.setMnemonic(KeyEvent.VK_O);
    
    JMenuItem selecionar = new JMenuItem("Selecionar Tudo");
    selecionar.setMnemonic(KeyEvent.VK_S);
    
    editar.add(recortar);
    editar.add(copiar);
    editar.add(colar);
    editar.addSeparator();
    editar.add(selecionar);
    
    barra.add(arquivo);
    barra.add(editar);
    
    
    setLocation(280,235);
    setSize(300, 150);
    setVisible(true);
  }
  
  public static void main(String args[]){
    Menus app = new Menus();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}