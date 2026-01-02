/**----------------------------------------------------------------------*/
/** Lê um número inteiro, positivo, menor que 4000 e escreve-o usando    */
/** algarismos romanos.                                                  */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
import javax.swing.JOptionPane;
public class DparaR {

  public static void main(String argumentos[]) {
    int numero,quociente,resto,i,j,k,base;
    final char[] digitos = {'C','M','D','X','C','L','I','X','V'};
	String romano = "", snumero;
    
	snumero = JOptionPane.showInputDialog(null,
       "Entre um número inteiro, positivo, menor que 4000: ",
       "Conversão de decimais para romanos",
	    JOptionPane.QUESTION_MESSAGE);
    numero = Integer.parseInt(snumero);
	
	while (numero > 0 && numero < 4000) {

      base = 1000;
      quociente = numero / base;
      resto = numero % base;
  
      for (i=1; i <= quociente; i++) romano = romano + "M";

      for (k=0; k<9; k+=3) {
   
        base /= 10; 
        quociente = resto / base; 
        resto = resto % base;    

        switch (quociente) {
         case 9: romano = romano + digitos[k] + digitos[k+1]; break;
         case 4: romano = romano + digitos[k] + digitos[k+2]; break;
         case 8: case 7: case 6: case 5: romano = romano + digitos[k+2];
         case 3: case 2: case 1: case 0:
	       for (i=1; i <= quociente%5; i++)
           romano = romano + digitos[k];
           break;
        }
      }
      JOptionPane.showMessageDialog(null,
		 "Número romano = " + romano,
		 "Número decimal = "+ snumero,
		  JOptionPane.INFORMATION_MESSAGE);
   
      snumero = JOptionPane.showInputDialog(null,
         "Entre um número inteiro, positivo, menor que 4000: ",
         "Conversão de decimais para romanos",
		  JOptionPane.QUESTION_MESSAGE);
	  numero = Integer.parseInt(snumero);
    }
    System.exit(0);
  }

}