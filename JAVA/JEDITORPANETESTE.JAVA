import javax.swing.*;
import java.awt.*;
import java.io.*;

public class JEditorPaneTeste extends JFrame{
  JEditorPane editor;
  
  public JEditorPaneTeste(){
    super("Uso da classe JEditorPane");
 
    Container tela = getContentPane();
    
    try{
      String url = "file:readme.txt";
      editor = new JEditorPane(url); 
    }
    catch(IOException excp){
      editor = new JEditorPane();
      JOptionPane.showMessageDialog(null, "Não foi possível carregar o documento.");  
    }
    
    editor.setEditable(false);
    JScrollPane painelRolagem = new JScrollPane(editor);
    tela.add(painelRolagem);
    
    setSize(300, 150);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    JEditorPaneTeste app = new JEditorPaneTeste();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}