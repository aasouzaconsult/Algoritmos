import javax.swing.*;

public class PrimeiraJanela extends JFrame{
  public PrimeiraJanela(){
    super("Nossa primeira janela");
    
    
    setLocation(280,235);
    setSize(300,150);
    setVisible(true);
    
    
      
  }
  
  public static void main(String args[]){
  	PrimeiraJanela app = new PrimeiraJanela();//app pode ser substituído por outro caractere
  	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//app
  } 	
}


