/*
*
* Ensina a criar uma caixa de senha
*
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Senha extends JFrame{
  JPasswordField caixaSenha;
  JLabel rotulo;
  JButton ok;
  
  public Senha(){
    super("Uso da classe JPasswordField");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    Tratador trat = new Tratador();
    
    rotulo = new JLabel("Senha:"); 
    caixaSenha = new JPasswordField(10);
    
    ok = new JButton("OK!");
    ok.addActionListener(trat);
    
    tela.add(rotulo);
    tela.add(caixaSenha);
    tela.add(ok);
   
    setLocation(280,235);
    setSize(350, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Senha app = new Senha();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements ActionListener{
    public void actionPerformed(ActionEvent evento){
      String senha = new String(caixaSenha.getPassword());
      JOptionPane.showMessageDialog(null, "Senha: " + senha);
    }
  }
}