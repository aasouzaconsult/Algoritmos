import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SplashScreenTeste extends JFrame{
  Splash splash;
  
  public SplashScreenTeste(){
    super("Esta é a janela principal do aplicativo");
 
    Container tela = getContentPane();
    
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 0, 0);
    tela.setLayout(layout); 
    
    splash = new Splash();
    splash.setVisible(true);
    
    setLocation(280,235);
    setSize(400, 300);
    setLocationRelativeTo(null); 
  }
  
  public static void main(String args[]){
    SplashScreenTeste app = new SplashScreenTeste();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void mostrarPrincipal(){
  	setVisible(true); 
  }
  
  private class Splash extends JWindow{
    public Splash(){
      Container tela = getContentPane();
      tela.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));
      
      ImageIcon imagem = new ImageIcon("java_exemplos/imagens/splash.gif");//coffeJava
      JLabel rotulo = new JLabel(imagem);
    
      tela.add(rotulo);
      
      ActionListener fechar = new ActionListener(){
        public void actionPerformed(ActionEvent e){
          setVisible(false);
          dispose();
          mostrarPrincipal();
        }
      };
      
      javax.swing.Timer timer = new javax.swing.Timer(10000, fechar);
      timer.start();
      
      pack();
      setLocationRelativeTo(null);
  	}
  }
}