import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class LineCount extends JFrame{
  JTextArea areaTexto;
  JLabel rotulo1, rotulo2;
  
  public LineCount(){
    super("Uso da classe JTextArea");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout);
    
    areaTexto = new JTextArea(10, 25);
    areaTexto.setLineWrap(true);
    areaTexto.setWrapStyleWord(true);
    areaTexto.getDocument().addDocumentListener(
      new DocumentListener(){
        public void insertUpdate(DocumentEvent evento){
          rotulo2.setText("Quantidade de Linhas: " + areaTexto.getLineCount());
        }
        
        public void removeUpdate(DocumentEvent evento){
          rotulo2.setText("Quantidade de Linhas: " + areaTexto.getLineCount());
        }
        
        public void changedUpdate(DocumentEvent evento){}
      }
    );
    
    
    JScrollPane painelRolagem = new JScrollPane(areaTexto);
    
    rotulo1 = new JLabel("Digite seu comentário:");
    rotulo2 = new JLabel("Quantidade de Linhas: 0");
    
    tela.add(rotulo1);
    tela.add(painelRolagem);
    tela.add(rotulo2);
    
    setSize(300, 240);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    LineCount app = new LineCount();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}