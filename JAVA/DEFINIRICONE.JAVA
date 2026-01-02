import javax.swing.*;

public class DefinirIcone extends JFrame{
  public DefinirIcone(){
    super("Como definir o ícone para a janela");
    
    ImageIcon icone = new ImageIcon("java_exemplos/imagens/box.gif");
    setIconImage(icone.getImage());
    
    setLocation(280,235);
    setSize(300,150);
    setVisible(true);  
  }
  
  public static void main(String args[]){
    DefinirIcone app = new DefinirIcone();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  } 
}