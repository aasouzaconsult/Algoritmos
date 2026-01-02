import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menus6 extends JFrame{
  JTextArea areaTexto;
  JCheckBoxMenuItem itemEstilo[];
  String nomesEstilo[] = {"Negrito", "Itálico"};
  int estilo;
  
  public Menus6(){
    super("Usando menus em aplicativos Java");
 
    Container tela = getContentPane();
  
    areaTexto = new JTextArea();
    areaTexto.setLineWrap(true);
    areaTexto.setWrapStyleWord(true);
    JScrollPane painelRolagem = new JScrollPane(areaTexto);
    tela.add(painelRolagem);
    
    Tratador trat = new Tratador();
    
    JMenuBar barra = new JMenuBar();
    setJMenuBar(barra);
    
    JMenu arquivo = new JMenu("Arquivo");
    arquivo.setMnemonic(KeyEvent.VK_A);
    
    JMenu editar = new JMenu("Editar");
    editar.setMnemonic(KeyEvent.VK_E);
    
    JMenu formatar = new JMenu("Formatar");
    formatar.setMnemonic(KeyEvent.VK_F);
    
    JMenu estiloFonte = new JMenu("Estilo da Fonte");
    estiloFonte.setMnemonic(KeyEvent.VK_E);
    
    itemEstilo = new JCheckBoxMenuItem[nomesEstilo.length];
    
    for(int i = 0; i < nomesEstilo.length; i++){
      itemEstilo[i] = new JCheckBoxMenuItem(nomesEstilo[i]);
      estiloFonte.add(itemEstilo[i]);
      itemEstilo[i].addItemListener(trat);	
    }
    
    formatar.add(estiloFonte);
    
    barra.add(arquivo);
    barra.add(editar);
    barra.add(formatar);
    
    setLocation(280,235);
    setSize(350,200);
    setVisible(true);
  }
  
  public static void main(String args[]){
    Menus6 app = new Menus6();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ItemListener{
  	public void itemStateChanged(ItemEvent e){
  	  int tamFonte = areaTexto.getFont().getSize();
  	  String nFonte = areaTexto.getFont().getName();
  	  estilo = 0;
  	  
  	  if(itemEstilo[0].isSelected())
  	    estilo += Font.BOLD;
  	    
  	  if(itemEstilo[1].isSelected())
  	    estilo += Font.ITALIC;
  	    
  	  areaTexto.setFont(new Font(nFonte, estilo, tamFonte));
  	  
  	  repaint();
  	} 
  }
}