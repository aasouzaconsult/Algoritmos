/**----------------------------------------------------------------------*/
/** Lê um número em algarismos romanos e converte para decimal.          */
/** Restrição:  Assume que o número lido está correto.                   */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
import javax.swing.JOptionPane;
import Console;
public class RparaD {
  
  public static int romanoParaDecimal(char[] romano, int t) { 
    char digito[] = new char[100];
    int decimal = 0;

	  digito['I'] = 1;
    digito['V'] = 5;
    digito['X'] = 10;
    digito['L'] = 50; 
    digito['C'] = 100;
    digito['D'] = 500;
    digito['M'] = 1000; 

    char rdigito = romano[0];
    int ddigito = digito[rdigito]; 
    int seguinte;

    for (int j=1; j < t; ++j) {
      rdigito = romano[j];
      seguinte = digito[rdigito]; 
      if (seguinte > ddigito) 
        decimal -= ddigito; 
      else decimal += ddigito; 
      ddigito = seguinte; 
    } 
    return decimal + ddigito; 
  }
  public static void main(String[] arg) {
    String linha = JOptionPane.showInputDialog(null,
       "Entre um número em algarismos romanos",
       "Conversão de romano para decimal",
       JOptionPane.QUESTION_MESSAGE);
    linha = linha.toUpperCase(); 
    int tamanho = linha.length();
    char romano[] = new char[tamanho];
    linha.getChars(0,tamanho,romano,0);
    JOptionPane.showMessageDialog(null,
      "Número romano = " + linha +"\n" +
      "Número decimal = " +  romanoParaDecimal(romano,tamanho),
      "Conversão de romano para decimal",
       JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);
  }

}