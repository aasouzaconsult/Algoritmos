import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SetTextAppend extends JFrame{
  JTextArea areaTexto;
  JTextField texto;
  JButton setTextBtn, appendBtn;
  
  public SetTextAppend(){
    super("Uso da classe JTextArea");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout);
    
    Tratador trat = new Tratador();
    
    texto = new JTextField(10);
    JButton setTextBtn = new JButton("setText");
    setTextBtn.addActionListener(trat);
    JButton appendBtn = new JButton("append");
    appendBtn.addActionListener(trat);
    
    areaTexto = new JTextArea(10, 25);
    JScrollPane painelRolagem = new JScrollPane(areaTexto);
    
    tela.add(texto);
    tela.add(setTextBtn);
    tela.add(appendBtn);
    tela.add(painelRolagem);
    
    setLocation(280,235);
    setSize(300,240);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    SetTextAppend app = new SetTextAppend();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
  	public void actionPerformed(ActionEvent e){
  	  if(e.getActionCommand() == "setText")
  	    areaTexto.setText(texto.getText());
  	  else
        areaTexto.append(texto.getText());
  	}
  }
}