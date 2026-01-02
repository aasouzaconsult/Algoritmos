/**----------------------------------------------------------------*/
/** Lê uma frase e inverte a ordem de cada uma de suas palavras.   */
/** Francisco A. S. Grossi                                         */
/**----------------------------------------------------------------*/
import javax.swing.*;
import java.util.*;
public class Inversas {

  public static void main(String arguments[]) {
    int i,j;
    String frase;
    
    do {
      frase = JOptionPane.showInputDialog(null,
        "Entre uma frase qualquer","Inverte palavras",
         JOptionPane.QUESTION_MESSAGE);
      j = frase.length();
    } while (j == 0);

    StringBuffer inversa1 = new StringBuffer(j);
    StringBuffer inversa2 = new StringBuffer(j);

    /* Algoritmo manual */

    /* Pula os eventuais brancos do fim da frase */
    for (--j; j >= 0 && frase.charAt(j) == ' '; --j); 
 
    for (i=0; i <= j;) {              // Percorre a frase
      // Pula brancos iniciais
      String inversa = "";
      while (i <= j && frase.charAt(i) == ' ') ++i;   
      // Inverte uma palavra
      for (;i <= j && frase.charAt(i) != ' '; ++i)
        inversa = frase.charAt(i) + inversa; 
      inversa1.append(inversa + " "); // Acrescenta inversa 
    } 
    
    /* Usando métodos existentes */ 
    StringTokenizer palavras = new StringTokenizer(frase);
    while (palavras.hasMoreTokens()) {
      StringBuffer buf = new StringBuffer(palavras.nextToken());
      inversa2.append(buf.reverse() + " ");  
    }

    JOptionPane.showMessageDialog(null,
       "Frase original\n" + frase + 
       "\n\nFrase com palavras invertidas (1)\n" + inversa1 +
       "\n\nFrase com palavras invertidas (2)\n"+inversa2,
       "Inverte palavras",JOptionPane.INFORMATION_MESSAGE);
    
    System.exit(0);
  }

}