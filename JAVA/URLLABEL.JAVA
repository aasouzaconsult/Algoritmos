import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class URLLabel extends JLabel{
  String site;
  
  public URLLabel(String texto, String url){
    super(texto);
    this.site = url;
    
    this.addMouseListener(
      new MouseAdapter(){
        public void mouseClicked(MouseEvent evento){
          try{
            Runtime.getRuntime().exec("start " + site);
          }
          catch(IOException exc){
            System.out.println("Erro");
          }
        }
      }
    );
    
    setCursor(new Cursor(Cursor.HAND_CURSOR));
  }
}