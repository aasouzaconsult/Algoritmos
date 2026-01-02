import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Teclado extends JFrame{
  JLabel rotulo;
  
  public Teclado(){
    super("Detectando eventos do teclado");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    tela.setLayout(layout);
    
    Tratador trat = new Tratador();
    
    addKeyListener(trat);
    
    rotulo = new JLabel("Informações do evento");
    tela.add(rotulo);
    
    setSize(300, 150);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    Teclado app = new Teclado();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private class Tratador implements KeyListener{
  	public void keyPressed(KeyEvent e){
  	  rotulo.setText("Tecla pressionada");
    }
    
    public void keyReleased(KeyEvent e){
  	  rotulo.setText("Tecla liberada");
    }
    
    public void keyTyped(KeyEvent e){
  	  rotulo.setText("Tecla pressionada é liberada");
    }
  }
}