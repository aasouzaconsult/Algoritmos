/**----------------------------------------------------------------------*/
/** Verifica se uma frase qualquer (inclusive vazia) é palíndromo, isto  */
/** é, se têm a mesma leitura tanto da esquerda para a direita quanto da */
/** direita para a esquerda, inclusive brancos.                          */
/** Soluções iterativa e recursiva.                                      */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
import Teclado;             
public class Palindromo {
/*-----------------------------------------------------------------------*/
/* Solução recursiva.                                                    */
/*-----------------------------------------------------------------------*/
  public static boolean palindromo1(String x, int i) {
    int f = x.length() - 1 - i;
    if (i < f) return x.charAt(i) == x.charAt(f) && palindromo1(x,i+1);
    else return true;
  }
/*-----------------------------------------------------------------------*/
/* Solução iterativa (inverte e compara os dois).                        */
/*-----------------------------------------------------------------------*/
  public static boolean palindromo2(String x) {
    int i;
    String y = "";
    for (i=0; i < x.length(); ++i) y = x.charAt(i) + y;
    return x.equals(y);
  }  
/*-----------------------------------------------------------------------*/
/* Solução não recursiva (inverte e compara os dois).                    */
/*-----------------------------------------------------------------------*/
  public static boolean palindromo3(String x) {
    int i;
    StringBuffer y = new StringBuffer(x);
    return x.equals(y.reverse().toString());
  }  
/*-----------------------------------------------------------------------*/
/* Solução iterativa (compara caracteres simétricos até a metade).       */
/*-----------------------------------------------------------------------*/
  public static boolean palindromo4(String x) {
    int i,j;
    for (i=0,j=x.length()-1; i < j && x.charAt(i) == x.charAt(j); ++i,--j);
    return i >= j;
  }  
/*-----------------------------------------------------------------------*/
/* Programa principal.                                                   */
/*-----------------------------------------------------------------------*/
  public static void main(String args[]) {
    String frase;
    frase = Teclado.readLine("Entre uma frase qualquer: ");
    System.out.println("Solucão 1 = " + palindromo1(frase,0));
    System.out.println("Solução 2 = " + palindromo2(frase));
    System.out.println("Solução 3 = " + palindromo3(frase));
    System.out.println("Solução 4 = " + palindromo4(frase));
  }	  

}