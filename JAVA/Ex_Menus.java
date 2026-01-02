/* Exercicio - Menus
 * Criado em 13/10/2004
 * Por.: Antonio Alex  - Curso Java
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex_Menus extends JFrame
{
    public static void main(String args[])
    {
       Ex_Menus Janela = new Ex_Menus();
       Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Janela.setVisible(true);
    }
    
    public Ex_Menus() 
    {
    	super("Demonstrando Menus Profissional");  
    	setSize(380,150);     // Define o tamanho da Janela (Frame)
    	setLocation(280,235); // Define a Localizacao da Janela (Frame)
        setResizable(false);  // Aparece ou nao o Maximizar
                
        // Criando Barra de Menu
        JMenuBar barra = new JMenuBar();
        setJMenuBar(barra);
                
        // Criando Menu Arquivo
        JMenu arquivo = new JMenu("Arquivo");
        arquivo.setMnemonic(KeyEvent.VK_A); //SetMnemonic -> Atalho para Teclado
                
        // Criando SubMenus para Arquivos
        JMenuItem novo = new JMenuItem("Novo");
        novo.setMnemonic(KeyEvent.VK_N);
        novo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
        
        JMenuItem abrir = new JMenuItem("Abrir");
        abrir.setMnemonic(KeyEvent.VK_B);
        abrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
        //ImageIcon icon = new ImageIcon("imagem/Abrir.gif"); //Aparecer Imagem
        //abrir.setIcon(icon);
        
        JMenu salvar = new JMenu("Salvar"); // Menu puxando outro Menu
        salvar.setMnemonic(KeyEvent.VK_L);
        JMenuItem salvarcomo = new JMenuItem("Salvar Como"); 
        salvarcomo.setMnemonic(KeyEvent.VK_O);
        salvarcomo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
        salvar.add(salvarcomo);
        
        JMenuItem imprimir = new JMenuItem("Imprimir");
        imprimir.setMnemonic(KeyEvent.VK_I);
        imprimir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.ALT_MASK));
        
        JMenuItem sair = new JMenuItem("Sair");
        sair.setMnemonic(KeyEvent.VK_A);
        sair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        
        // Criando Menu Sobre
        JMenu sobre = new JMenu("Sobre");
        sobre.setMnemonic(KeyEvent.VK_S); //SetMnemonic -> Atalho para Teclado
             
        // Criando SubMenus para Sobre
        JMenuItem sistema = new JMenuItem("Sistema");
        sistema.setMnemonic(KeyEvent.VK_T);
        sistema.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
        
        // Criando Menu Ajuda
        JMenu ajuda = new JMenu("Ajuda ?");
        ajuda.setMnemonic(KeyEvent.VK_J);
        
        // Criando SubMenus para Ajuda
        JMenuItem ajudar = new JMenuItem("Ajudar");
        ajudar.setMnemonic(KeyEvent.VK_R);
        ajudar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
                
        // Montando Menus
        arquivo.add(novo);
        arquivo.add(abrir);
        arquivo.add(salvar);
        arquivo.add(imprimir);
        arquivo.addSeparator();
        arquivo.add(sair);
        
        sobre.add(sistema);
        
        ajuda.add(ajudar);
                
        barra.add(arquivo);
        barra.add(sobre);
        barra.add(ajuda);
     }
    
}
