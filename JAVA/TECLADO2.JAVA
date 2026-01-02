import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Teclado2 extends JFrame{
  JLabel rotulo;
  
  public Teclado2(){
    super("Detectando eventos do teclado");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout);
    
    Tratador trat = new Tratador();
    
    addKeyListener(trat);
    
    rotulo = new JLabel("Pressione qualquer tecla...");
    tela.add(rotulo);
    
    setLocation(280,235);
    setSize(300,150);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Teclado2 app = new Teclado2();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador extends KeyAdapter{
  	public void keyPressed(KeyEvent e){
  	  rotulo.setText("Código: " + e.getKeyCode() + " - Caractere: " + e.getKeyChar());
    }
  }
}