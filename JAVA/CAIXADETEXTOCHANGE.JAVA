import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class CaixaDeTextoChange extends JFrame{
  JTextField caixa;
  JButton clique;
  JLabel rotulo;
  
  public CaixaDeTextoChange(){
    super("Detectando alteração no texto de um JTextField");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    rotulo = new JLabel("Usuário:");
    
    caixa = new JTextField(10);
    caixa.getDocument().addDocumentListener(
      new DocumentListener(){
        String texto;
        
        public void insertUpdate(DocumentEvent evento){
          clique.setEnabled(true);
        }
        
        public void removeUpdate(DocumentEvent evento){
          texto = caixa.getText();
        	
          if(texto.length() < 1)
            clique.setEnabled(false);
        }
        
        public void changedUpdate(DocumentEvent evento){}
      }
    );
    
    clique = new JButton("Enviar!");
    clique.setEnabled(false);
    
    tela.add(rotulo);
    tela.add(caixa);
    tela.add(clique);
    
    setSize(350, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    CaixaDeTextoChange app = new CaixaDeTextoChange();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}