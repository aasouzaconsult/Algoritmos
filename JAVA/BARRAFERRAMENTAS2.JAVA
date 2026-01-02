/*
 * Este programa tem como objetivo ensinar como criar uma barra de ferramentas
 * e adicioná-la ao container,sem as funcionalidades de seus botões
 *
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class BarraFerramentas2 extends JFrame{
  public BarraFerramentas2()
    
  {
    super("Usando barras de ferramentas");
 
    JMenuBar barra = new JMenuBar();
    setJMenuBar(barra);
    
    JMenu arquivo = new JMenu("Arquivo");
    arquivo.setMnemonic(KeyEvent.VK_A);
    
    JMenu editar = new JMenu("Editar");
    editar.setMnemonic(KeyEvent.VK_E);
    
    barra.add(arquivo);
    barra.add(editar);
    
    ImageIcon[] imagens = new ImageIcon[7];
    
    String icones[] = {"java_exemplos/imagens/abrir.gif", 
                       "java_exemplos/imagens/salvar.gif", 
                       "java_exemplos/imagens/imprimir.gif",
                       "java_exemplos/imagens/recortar.gif", 
                       "java_exemplos/imagens/copiar.gif",
                       "java_exemplos/imagens/colar.gif"};
    
    for(int i = 0; i < icones.length; i++){
       imagens[i] = new ImageIcon(icones[i]); 
    }
    
    Container tela = getContentPane();
    tela.setLayout(new BorderLayout()); 
   
    Tratador trat = new Tratador(); 
   
    JButton abrir = new JButton(imagens[0]);
    abrir.setToolTipText("Abrir arquivo existente");
    abrir.addActionListener(trat);
    
    JButton salvar = new JButton(imagens[1]);
    JButton imprimir = new JButton(imagens[2]);
    JButton recortar = new JButton(imagens[3]);
    JButton copiar = new JButton(imagens[4]);
    JButton colar = new JButton(imagens[5]);
  
    
    JToolBar bFerramentas = new JToolBar();
    bFerramentas.setRollover(true);// permite que os gifs tornem-se deslizantes
    bFerramentas.add(abrir);
    bFerramentas.add(salvar);
    bFerramentas.add(imprimir);
    bFerramentas.addSeparator();
    bFerramentas.add(recortar);
    bFerramentas.add(copiar);
    bFerramentas.add(colar);
    
    
    for(int i = 0; i < bFerramentas.getComponentCount(); i++){
      Component comp = bFerramentas.getComponent(i);
      if(comp.getClass().getName().equals("javax.swing.JButton")){
        ((JButton)(comp)).setFocusable(false);
      } 
    }
    
    tela.add(bFerramentas, BorderLayout.NORTH);
    
    JTextArea areaTexto = new JTextArea();
    areaTexto.setLineWrap(true);
    areaTexto.setWrapStyleWord(true);
    JScrollPane painelRolagem = new JScrollPane(areaTexto);
    tela.add(painelRolagem, BorderLayout.CENTER);
    
    
    setLocation(280,235);
    setSize(300,200);
    setVisible(true);
  }
  
  public static void main(String args[]){
    BarraFerramentas2 app = new BarraFerramentas2();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  /*
 public void actionPerformed(ActionEvent e)
  {
          int resp = 0;
        String nome_do_arquivo;
        if (e.getSource()==salvar) //este botao salva o seu arquivo digitado
            
        {
            try
            {
                salvar.show();
                if (salvar.getFile()==null) return;
                nome_do_arquivo = salvar.getDirectory()+salvar.getFile();
                FileWriter out = new FileWriter(nome_do_arquivo);
                out.write(ta1.getText());
                out.close();
                areaTexto.setText("Arquivo gravado com sucesso !");
            }
            catch(java.io.IOException exc)
            {
                areaTexto.setText("Erro ao gravar no arquivo !");
            }
        }
  }
 */
  
     
  private class Tratador implements ActionListener{
    public void actionPerformed(ActionEvent e){
      JOptionPane.showMessageDialog(null, "Você clicou no botão Abrir");   
    }
  }
}