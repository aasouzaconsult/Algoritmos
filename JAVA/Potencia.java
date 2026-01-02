/**----------------------------------------------------------------------*/
/** Calcula potência de uma base real a um expoente inteiro.             */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
import Teclado;
public class Potencia {
/*-----------------------------------------------------------------------*/
/* Solução iterativa ineficiente.                                        */
/*-----------------------------------------------------------------------*/
  public static double potencia1(double x, int n) {
    double y;
    boolean negativo = (n < 0);
    if (negativo) n = -n;
    for (y=1; n > 0; --n) y *= x;
    return negativo ? 1/y : y;
  }
/*-----------------------------------------------------------------------*/
/* Solução iterativa eficiente.                                          */
/*-----------------------------------------------------------------------*/
  public static double potencia2(double x, int n) {
    double y;
    boolean negativo = (n < 0);
    if (negativo) n = -n;
    for (y=1; n > 0; n >>= 1) {
      if ((n&1) == 1) y *= x;
      x *= x;
    }
    return negativo ? 1/y : y;
  }
/*-----------------------------------------------------------------------*/
/* Solução recursiva ineficiente.                                        */
/*-----------------------------------------------------------------------*/
  public static double potencia3(double x,int n) {
    if (n < 0) return 1/potencia3(x,-n);
    else if (n == 0) return 1;
    else return potencia3(x,n-1) * x;
  }	
/*-----------------------------------------------------------------------*/
/* Solução recursiva eficiente.                                          */
/*-----------------------------------------------------------------------*/
  public static double potencia4(double x,int n) {
    if (n == 0) return 1;
    else if (n < 0) return 1/potencia4(x,-n);
    else if ((n&1) == 1) return potencia4(x*x,n>>1)*x;
    else return potencia4(x*x,n>>1);
  }		
/*-----------------------------------------------------------------------*/
/* Programa principal.                                                   */
/*-----------------------------------------------------------------------*/
  public static void main(String argumentos[]) {
    double x;
    int n;
    x = Teclado.readDouble("Entre a base (real): ");
    n = Teclado.readInt("Entre o expoente (inteiro): ");	

    System.out.println("Método implementado em Java  = " + Math.pow(x,n));
    System.out.println("Método iterativo ineficiente = " + potencia1(x,n));
    System.out.println("Método iterativo eficiente   = " + potencia2(x,n));
    System.out.println("Método recursivo ineficiente = " + potencia3(x,n));
    System.out.println("Método recursivo eficiente   = " + potencia4(x,n));
  }

}
