import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

public class UmaLinhaPorVez extends JFrame{
  JTextArea areaTexto;
  JButton exibirBtn;
  
  public UmaLinhaPorVez(){
    super("Uso da classe JTextArea");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout);
    
    areaTexto = new JTextArea(10, 25);
    areaTexto.setLineWrap(true);
    areaTexto.setWrapStyleWord(true);
    JScrollPane painelRolagem = new JScrollPane(areaTexto);
    
    Tratador trat = new Tratador();
    
    exibirBtn = new JButton("Exibir uma linha por vez");
    exibirBtn.addActionListener(trat);
    
    tela.add(painelRolagem);
    tela.add(exibirBtn);
    
    setLocation(280,235);
    setSize(300, 230);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    UmaLinhaPorVez app = new UmaLinhaPorVez();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
    public void actionPerformed(ActionEvent e){
      int inicio = 0, fim = 0;
      String linha = "";
      
      for(int i = 0; i < areaTexto.getLineCount(); i++){
        try{
          inicio = areaTexto.getLineStartOffset(i);
          fim = areaTexto.getLineEndOffset(i);
          linha = areaTexto.getText(inicio, fim - inicio);
          JOptionPane.showMessageDialog(null, "Linha " + (i + 1) + " = " + linha);
        }
        catch(BadLocationException ble){
          JOptionPane.showMessageDialog(null, "Erro. Argumentos inválidos.");  
        }
      }
    }
  }
}