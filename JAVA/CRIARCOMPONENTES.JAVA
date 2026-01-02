import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CriarComponentes extends JFrame{
  Container tela;
  
  public CriarComponentes(){
    super("Criando componentes em tempo de execução");
 
    tela = getContentPane();
    tela.setLayout(null);
    
    addMouseListener(
      new MouseAdapter(){
        public void mouseClicked(MouseClickEvent e){
          tela.add(new JButton("Clique"));
          int quant = tela.getComponentCount();
          (tela.getComponent(quant - 1)).setBounds(e.getX(), e.getY() - 20, 100, 20); 	
        }	
      }	
    );
    
    setSize(300, 200);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    CriarComponentes app = new CriarComponentes();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}