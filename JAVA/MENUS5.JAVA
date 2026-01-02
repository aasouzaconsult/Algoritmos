import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menus5 extends JFrame{
  JTextArea areaTexto;
  JRadioButtonMenuItem cores[], fontes[];
  ButtonGroup grupoCores, grupoFontes;
  Color valCores[] = {Color.black, Color.red, Color.blue, Color.green};
  String nomeCores[] = {"Preto", "Vermelho", "Azul", "Verde"};
  String nomeFontes[] = {"TimesRoman", "Verdana", "Courier"};
  
  public Menus5(){
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
    
    JMenu corTexto = new JMenu("Cor do Texto");
    corTexto.setMnemonic(KeyEvent.VK_C);
    
    grupoCores = new ButtonGroup();
    cores = new JRadioButtonMenuItem[valCores.length];
    
    for(int i = 0; i < valCores.length; i++){
      cores[i] = new JRadioButtonMenuItem(nomeCores[i]);
      corTexto.add(cores[i]);
      grupoCores.add(cores[i]);
      cores[i].addActionListener(trat);	
    }
    
    cores[0].setSelected(true);
    
    JMenu nomeFonte = new JMenu("Nome da Fonte");
    nomeFonte.setMnemonic(KeyEvent.VK_N);
    
    grupoFontes = new ButtonGroup();
    fontes = new JRadioButtonMenuItem[nomeFontes.length];
    
    for(int i = 0; i < nomeFontes.length; i++){
      fontes[i] = new JRadioButtonMenuItem(nomeFontes[i]);
      nomeFonte.add(fontes[i]);
      grupoFontes.add(fontes[i]);
      fontes[i].addActionListener(trat);	
    }
    
    fontes[0].setSelected(true);
    
    formatar.add(corTexto);
    formatar.add(nomeFonte);
    
    barra.add(arquivo);
    barra.add(editar);
    barra.add(formatar);
    
    setLocation(280,235);
    setSize(350,200);
    setVisible(true);
  }
  
  public static void main(String args[]){
    Menus5 app = new Menus5();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
  	public void actionPerformed(ActionEvent e){
  	  int tamFonte = areaTexto.getFont().getSize();
  	  
  	  for(int i = 0; i < cores.length; i++){
  	  	if(cores[i].isSelected()){
  	  	  areaTexto.setForeground(valCores[i]);
  	  	  break;	
  	  	} 
  	  }
  	  
  	  for(int i = 0; i < fontes.length; i++){
  	  	if(fontes[i].isSelected()){
  	  	  areaTexto.setFont(new Font(nomeFontes[i], Font.PLAIN, tamFonte));
  	  	  break;	
  	  	} 
  	  }
  	  
  	  repaint();
  	} 
  }
}