import javax.swing.*;

public class JanelaMinimizada extends JFrame{
  public JanelaMinimizada(){
    super("Como exibir a janela minimizada");
 
    setSize(300, 150);
    
    setVisible(true);
    
    setExtendedState(ICONIFIED);  
  }
  
  public static void main(String args[]){
    JanelaMinimizada app = new JanelaMinimizada();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  } 
}