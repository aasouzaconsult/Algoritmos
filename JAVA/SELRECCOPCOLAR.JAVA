import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelRecCopColar extends JFrame{
  JTextArea areaTexto;
  JButton selecionar, recortar, copiar, colar;
  
  public SelRecCopColar(){
    super("Uso da classe JTextArea");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout);
    
    Tratador trat = new Tratador();
    
    JButton selecionar = new JButton("Selecionar");
    selecionar.addActionListener(trat);
    
    JButton recortar = new JButton("Recortar");
    recortar.addActionListener(trat);
    
    JButton copiar = new JButton("Copiar");
    copiar.addActionListener(trat);
    
    JButton colar = new JButton("Colar");
    colar.addActionListener(trat);
        
    areaTexto = new JTextArea(10, 30);
    areaTexto.setLineWrap(true);
    areaTexto.setWrapStyleWord(true);
    JScrollPane painelRolagem = new JScrollPane(areaTexto);
    
    tela.add(painelRolagem);
    tela.add(selecionar);
    tela.add(recortar);
    tela.add(copiar);
    tela.add(colar);
    
    setSize(350, 230);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    SelRecCopColar app = new SelRecCopColar();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
  	public void actionPerformed(ActionEvent e){
      if(e.getActionCommand() == "Selecionar"){
  	    areaTexto.selectAll();
  	    areaTexto.requestFocus();
  	  }
      else if(e.getActionCommand() == "Recortar")
        areaTexto.cut();
      else if(e.getActionCommand() == "Copiar")
        areaTexto.copy();
  	  else
        areaTexto.paste();
  	}
  }
}