
import javax.swing.JOptionPane;

public class EntradaDialogos{
  public static void main(String args[]){
       String nome; 
       
       nome = JOptionPane.showInputDialog("Digite seu nome:");
       JOptionPane.showMessageDialog(null, "Bom dia, " + nome);
       
       System.exit(0); 
    } 
}