import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class DicaFerramenta extends JFrame{
  JTextField caixa;
  JButton clique;
  JLabel rotulo;
  
  public DicaFerramenta(){
    super("Definindo dicas de ferramenta para os controles");
 
    Container tela = getContentPane();
    
    setLocation(190,235);
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    rotulo = new JLabel("Texto:");
    
    caixa = new JTextField(10);
    caixa.setToolTipText("Digite uma frase aqui");
    caixa.getDocument().addDocumentListener(
      new DocumentListener(){
        public void insertUpdate(DocumentEvent evento){
          clique.setToolTipText(caixa.getText());
        }
        
        public void removeUpdate(DocumentEvent evento){
          clique.setToolTipText(caixa.getText());
        }
        
        public void changedUpdate(DocumentEvent evento){}
      }
    );
    
    clique = new JButton("Enviar!");
    clique.setToolTipText("Clique para enviar os dados");
    
    tela.add(rotulo);
    tela.add(caixa);
    tela.add(clique);
    
    setSize(350, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    DicaFerramenta app = new DicaFerramenta();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}