import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class LinhaPalavraCarac extends JFrame{
  JTextArea areaTexto;
  JLabel rotulo1, linhasLbl, palavrasLbl, caracLbl;
  
  public LinhaPalavraCarac(){
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
          contar();
        }
        
        public void removeUpdate(DocumentEvent evento){
          contar();
        }
        
        public void changedUpdate(DocumentEvent evento){}
      }
    );
    
    
    JScrollPane painelRolagem = new JScrollPane(areaTexto);
    
    rotulo1 = new JLabel("Digite seu comentário:");
    linhasLbl = new JLabel("Linhas: 0");
    palavrasLbl = new JLabel("- Palavras: 0");
    caracLbl = new JLabel("- Caracteres: 0");
    
    tela.add(rotulo1);
    tela.add(painelRolagem);
    tela.add(linhasLbl);
    tela.add(palavrasLbl);
    tela.add(caracLbl);
    
    setSize(300, 240);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    LinhaPalavraCarac app = new LinhaPalavraCarac();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void contar(){
    int linhas, palavras, caracteres;
    String texto = areaTexto.getText();
    StringTokenizer separador = new StringTokenizer(texto, " \n");
    
    palavras = separador.countTokens();
    
    linhasLbl.setText("Linhas: " + areaTexto.getLineCount());
    palavrasLbl.setText(" - Palavras: " + palavras);
    caracLbl.setText(" - Caracteres: " + texto.length()); 
  }
}