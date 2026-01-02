import javax.swing.*;
import java.awt.*;

public class PosAbsoluto extends JFrame{
  public PosAbsoluto(){
    super("Usando posicionamento absoluto");
 
    Container tela = getContentPane();
    tela.setLayout(null);
    
    JLabel tituloLbl = new JLabel("Informações do Usuário");
    tela.add(tituloLbl); 
    tituloLbl.setBounds(10, 5, 200, 20);
   
    JLabel nomeLbl = new JLabel("Nome:");
    tela.add(nomeLbl); 
    nomeLbl.setBounds(10, 35, 60, 20);
    
    JLabel senhaLbl = new JLabel("Senha:");
    tela.add(senhaLbl); 
    senhaLbl.setBounds(10, 60, 60, 20); 
    
    JTextField nomeTxt = new JTextField();
    tela.add(nomeTxt); 
    nomeTxt.setBounds(75, 35, 150, 20);
    
    JTextField senhaTxt = new JTextField();
    tela.add(senhaTxt); 
    senhaTxt.setBounds(75, 60, 150, 20);
    
    JButton okBtn = new JButton("OK!");
    tela.add(okBtn);
    okBtn.setBounds(65, 95, 100, 20);
    
    JButton cancelarBtn = new JButton("Cancelar");
    tela.add(cancelarBtn);
    cancelarBtn.setBounds(170, 95, 100, 20);
    
    setLocation(280,235);
    setSize(290, 150);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    PosAbsoluto app = new PosAbsoluto();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}