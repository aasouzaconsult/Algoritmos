/**----------------------------------------------------------------------*/
/** Exemplo de programa que executa como applet ou como aplicativo.      */
/** Para executar como applet: appletviewer Circulos.java ou browser.    */
/** Para executar como aplicativo (Sun JDK): java Circulos               */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
import java.awt.*;
import java.applet.*;

// <applet code=Circulos.class width=250 height=250>
// </applet>

public class Circulos extends Applet {

  public void paint(Graphics g) {
    for (int i = 0; i < 10; i++)  
      g.drawOval(10+i*10,10+i*10,50+i*10,50+i*10);
  }

  public static void main(String[] args) {
    Janela1 frame = new Janela1("Círculos");
    Circulos painel = new Circulos();
    frame.add(painel,BorderLayout.CENTER);
    frame.setSize(300,300);
    frame.setLocation(300,300);
    frame.show();
    painel.init();
    painel.start();
  }
}