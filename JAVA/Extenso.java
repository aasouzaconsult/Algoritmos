/**----------------------------------------------------------------------*/
/** Lê um número inteiro e positivo e escreve o seu valor por extenso    */
/** em inglês (para evitar as complicações das preposições em português).*/
/** O valor máximo é 2147483647 (maior inteiro positivo em 32 bits).     */
/**----------------------------------------------------------------------*/
import javax.swing.JOptionPane;
public class Extenso {

  private static final String[] ones =
	{"zero", "one", "two", "three", "four", "five", "six", "seven",
   	  "eight", "nine" };
  private static final String[] teens =
	{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
     "sixteen", "seventeen", "eighteen", "nineteen" };
  private static final String[] tens =
	{"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
	  "eighty", "ninety" };
  private static final String hundred = " hundred";
  private static final String[] thousands =
	{" thousand", " million", " billion", " trillion" };
/*-----------------------------------------------------------------------*/
/* Método recursivo que traduz valor numérico para extenso (em inglês).  */
/* Parâmetro: número inteiro; retorno: string com valor por extenso.     */
/*-----------------------------------------------------------------------*/
  public static String spellout(int x) {
    if (x < 10) return ones[x];
    else if (x < 20) return teens[x - 10];

	else if (x < 100) 
      if (x % 10 == 0) return tens[x / 10];
      else return tens[x / 10] + "-" + ones[x % 10];

	else if (x < 1000) 
       if (x % 100 == 0) return ones[x / 100] + hundred;
       else return ones[x / 100] + hundred + " " + spellout(x % 100);

	 else if (x < 1000000) 
       if (x % 1000 == 0) return spellout(x / 1000) + thousands[0];
       else return spellout(x / 1000) + thousands[0] + " " + 
		            spellout(x % 1000);

	 else if (x < 1000000000) 
       if (x % 1000000 == 0) return spellout(x / 1000000) + thousands[1];
       else return spellout(x / 1000000) + thousands[1] + " " +
		           spellout(x % 1000000);
  	 else return "0"; 
  }
/*-----------------------------------------------------------------------*/
/* Programa principal: lê número, invoca função, escreve por extenso.    */
/*-----------------------------------------------------------------------*/
  public static void main(String arguments[]) {
    String snumero;
	int numero;

	snumero = JOptionPane.showInputDialog(null,
       "Entre um número inteiro (negativo termina)",
       "Valor por Extenso",
	    JOptionPane.QUESTION_MESSAGE);
	    numero = Integer.parseInt(snumero);
	
	while (numero >= 0) {
      System.out.println(spellout(1620));
      JOptionPane.showMessageDialog(null,
		 "Número decimal: "+ numero + "\n" + spellout(numero),
         "Valor por Extenso",
		  JOptionPane.INFORMATION_MESSAGE);
	   snumero = JOptionPane.showInputDialog(null,
         "Entre um número inteiro (negativo termina)",
         "Valor por Extenso",
	      JOptionPane.QUESTION_MESSAGE);
	      numero = Integer.parseInt(snumero);
    }
	System.exit(0);
  }
}