/*
 * CadLivros.java
 *
 * Created on 1 de Junho de 2004, 09:41
 */


/**
 *
 * @author  claudemir
 */

/**
 * Este programa apresenta uma forma mais pratica de manipular arquivos de texto
 * inserindo uma caixa de dialogo a partir da class FileDialog, uma classe do
 * pacote awt. Quando o usuario pressiona o botao Gravar ou Abrir, aparece uma
 * caixa de dialogo semelhante a utilizada pelo Windows, por exemplo, no blobo 
 * de notas. Com isso, torna-se possivel realizar a escolha do arquivo que sera 
 * lido ou gravado pela aplicacao. Esta aplicacao apresenta outras duas classes
 * (FileWrite e FileReader) que podem ser usadas para a manipulacao de arquivos
 * texto.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class CadLivros extends JFrame implements ActionListener 
{
    private JLabel l1,l2,l3,l4;
    private JButton b1,b2,b3,b4,b5;
    private JTextField tf1,tf2,tf3,tf4;
    private JPanel p1;
    private JScrollPane sb;
    private FileDialog Fabrir,Fcadastrar;
    
       
    public static void main(String args[])
    {
        JFrame Janela = new CadLivros();
        WindowListener x = new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        };
        Janela.addWindowListener(x);
        Janela.show();
    }

    public void actionPerformed (java.awt.event.ActionEvent actionEvent)
    {
    }    
    
    CadLivros()
    {
        setTitle("Biblioteca de Livros");
        setSize(1024,800);
        setResizable(true);
        getContentPane().setBackground(new Color(150,150,150));
        getContentPane().setLayout(new FlowLayout());
        
        l1 = new JLabel("Nome do Livro");
        l1.setForeground(Color.blue);
        l2 = new JLabel("Autor");
        l2.setForeground(Color.blue);
        l3 = new JLabel("Editora");
        l3.setForeground(Color.blue);
        l4 = new JLabel("Área");
        l4.setForeground(Color.blue);
             
        
        b1 = new JButton("Pesquisar");
        b1.addActionListener(this);
        b1.setMnemonic(KeyEvent.VK_P);
        b2 = new JButton("Sair");
        b2.setMnemonic(KeyEvent.VK_R);
        b2.addActionListener(this);
        b3 = new JButton("Limpar");
        b3.setMnemonic (KeyEvent.VK_L);
        b3.addActionListener(this);
        b4 = new JButton("Cancelar");
        b4.setMnemonic(KeyEvent.VK_A);
        b4.addActionListener(this);
        b5 = new JButton("Cadastrar");
        b5.setMnemonic(KeyEvent.VK_C);
        b5.addActionListener(this);
        
           
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(l1); p1.add(l2);
        p1.add(l3); p1.add(l4);
        p1.add(b1); p1.add(b2);
        p1.add(b3); p1.add(b4);
        p1.add(b5);  
        
        
        
        Fabrir = new FileDialog(this,"Abrir arquivo",FileDialog.LOAD);
        Fcadastrar = new FileDialog(this,"Salvar arquivo",FileDialog.SAVE);
        
        getContentPane().add(l1);    getContentPane().add(l2);
        getContentPane().add(l3);    getContentPane().add(l4);
        getContentPane().add(b1);    getContentPane().add(b2);
        getContentPane().add(b3);    getContentPane().add(b4);
        getContentPane().add(p1);    getContentPane().add(b5);
    }
 }
    
    