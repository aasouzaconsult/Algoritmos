// MenuDemo.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Janela extends JFrame
{
    JTextArea texto;    

    public Janela()
    {
        setTitle("Visualizador de Arquivos");
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        JMenu menuArquivo = new JMenu("Arquivo");
        menuArquivo.setMnemonic('A');
        JMenu menuEstilo = new JMenu("Estilo");
        menuEstilo.setMnemonic('E');        
        JMenu menuAjuda = new JMenu("Ajuda");
        menuAjuda.setMnemonic('U');
        bar.add(menuArquivo);
        bar.add(menuEstilo);
        bar.add(menuAjuda);
        JMenuItem itemAbrir = new JMenuItem("Abrir");
        itemAbrir.setMnemonic('A');
        itemAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(Janela.this); 
            }
        });
        menuArquivo.add(itemAbrir);
        menuArquivo.addSeparator();
        menuArquivo.add(new JMenuItem("Sair"));
        menuEstilo.add(new JMenuItem("Copiar"));
        menuEstilo.add(new JMenuItem("Colar"));
        menuEstilo.add(new JMenuItem("Recortar"));
        JMenuItem itemSobre = new JMenuItem("Sobre...");
        itemSobre.setMnemonic('S');
        itemSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "Mini Visualizador de Arquivos");
            }
        });
        menuAjuda.add(itemSobre);
        setSize(400, 200);
        texto = new JTextArea();
        getContentPane().add(texto);
    }
}

public class MenuDemo
{
    public static void main(String args[])
    {
        Janela j = new Janela();
        j.show();
    }
}
