import javax.swing.*;
import java.awt.*;

public class URLLabelTeste extends JFrame{
  public URLLabelTeste(){
    super("Uso de HTML em um objeto JLabel");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout); 
    
    URLLabel rotulo = new URLLabel("Visite nosso site", "http://www.java.sun.com");
    tela.add(rotulo);
    
    setLocation(280,235);
    setSize(300,200);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    URLLabelTeste app = new URLLabelTeste();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}