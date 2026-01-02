import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JLabelClick extends JFrame{
  public JLabelClick(){
    super("Eventos do mouse em um objeto JLabel");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    JLabel rotulo = new JLabel("Clique Aqui!");
    
    rotulo.addMouseListener(
      new MouseAdapter(){
        public void mouseClicked(MouseEvent evento){
          String texto = "Você clicou no rótulo cujo texto é: ";
          texto += ((JLabel)(evento.getSource())).getText();
          JOptionPane.showMessageDialog(null, texto);
        }
      }
    );
    
    tela.add(rotulo);
    
    setLocation(280,235);
    setSize(300, 100);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    JLabelClick app = new JLabelClick();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}