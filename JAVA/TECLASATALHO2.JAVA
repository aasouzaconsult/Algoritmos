import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TeclasAtalho2 extends JFrame{
  JTextField nome;
  JPasswordField senha;
  JLabel lbNome, lbSenha;
  
  public TeclasAtalho2(){
    super("Teclas de atalho para caixas de texto");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    nome = new JTextField(8);
    senha = new JPasswordField(8);
    
    lbNome = new JLabel("Nome:");
    lbNome.setDisplayedMnemonic(KeyEvent.VK_N);
    lbNome.setLabelFor(nome);
    
    lbSenha = new JLabel("Senha:");
    lbSenha.setDisplayedMnemonic(KeyEvent.VK_S);
    lbSenha.setLabelFor(senha);
    
    tela.add(lbNome);
    tela.add(nome);
    tela.add(lbSenha);
    tela.add(senha);
    
    setLocation(280,235);
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    TeclasAtalho2 app = new TeclasAtalho2();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}