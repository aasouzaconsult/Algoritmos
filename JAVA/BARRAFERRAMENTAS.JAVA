import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BarraFerramentas extends JFrame{
  public BarraFerramentas(){
    super("Usando barras de ferramentas");
 
    JMenuBar barra = new JMenuBar();
    setJMenuBar(barra);
    
    JMenu arquivo = new JMenu("Arquivo");
    arquivo.setMnemonic(KeyEvent.VK_A);
    
    JMenu editar = new JMenu("Editar");
    editar.setMnemonic(KeyEvent.VK_E);
    
    barra.add(arquivo);
    barra.add(editar);
    
    ImageIcon[] imagens = new ImageIcon[6];
    
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
   
    JButton abrir = new JButton(imagens[0]);
    JButton salvar = new JButton(imagens[1]);
    JButton imprimir = new JButton(imagens[2]);
    JButton recortar = new JButton(imagens[3]);
    JButton copiar = new JButton(imagens[4]);
    JButton colar = new JButton(imagens[5]);
    
    JToolBar bFerramentas = new JToolBar();
    bFerramentas.add(abrir);
    bFerramentas.add(salvar);
    bFerramentas.add(imprimir);
    bFerramentas.addSeparator();
    bFerramentas.add(recortar);
    bFerramentas.add(copiar);
    bFerramentas.add(colar);
    
    tela.add(bFerramentas, BorderLayout.NORTH);
    
    JTextArea areaTexto = new JTextArea();
    areaTexto.setLineWrap(true);
    areaTexto.setWrapStyleWord(true);
    JScrollPane painelRolagem = new JScrollPane(areaTexto);
    tela.add(painelRolagem, BorderLayout.CENTER);
    
    setSize(300, 200);
    setVisible(true);
  }
  
  public static void main(String args[]){
    BarraFerramentas app = new BarraFerramentas();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}