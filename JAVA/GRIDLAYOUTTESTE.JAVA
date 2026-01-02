import javax.swing.*;
import java.awt.*;

public class GridLayoutTeste extends JFrame{
  public GridLayoutTeste(){
    super("Uso do gerenciador de layout GridLayout");
 
    Container tela = getContentPane();
    
    GridLayout layout = new GridLayout(2, 3, 5, 5);
    tela.setLayout(layout); 
    
    JButton botoes[] = new JButton[6];
    
    for(int i = 0; i < botoes.length; i++){
      botoes[i] = new JButton("Botão " + (i + 1));
      tela.add(botoes[i]);
    }
   
    setSize(300, 150);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    GridLayoutTeste app = new GridLayoutTeste();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}