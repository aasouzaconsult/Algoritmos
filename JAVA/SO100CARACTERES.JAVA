import javax.swing.*;
import java.awt.*;

public class So100Caracteres extends JFrame{
  JTextArea areaTexto;
  JLabel rotulo1;
  
  public So100Caracteres(){
    super("Uso da classe JTextArea");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout);
    
    areaTexto = new JTextArea(10, 25);
    areaTexto.setDocument(new TamanhoMaximo());
    areaTexto.setLineWrap(true);
    areaTexto.setWrapStyleWord(true);
    
    JScrollPane painelRolagem = new JScrollPane(areaTexto);
    
    rotulo1 = new JLabel("Comentário (Máximo de 100 Caracteres):");
    
    tela.add(rotulo1);
    tela.add(painelRolagem);
    
    setSize(300, 225);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    So100Caracteres app = new So100Caracteres();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}