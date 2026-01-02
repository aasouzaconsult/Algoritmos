/**----------------------------------------------------------------------*/
/** Calcula raiz quadrada pelo método de Newton: se x1 é uma aproximação */
/** da raiz de n, então x2 = (x1+n/x1)/2 é uma aproximação melhor.       */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
import Teclado;
import java.text.DecimalFormat;
public class Raiz {
/*-----------------------------------------------------------------------*/
/* Solução iterativa.                                                    */
/*-----------------------------------------------------------------------*/
  public static double raizi(double n) {
    double x1,x2;
    if (n==0 || n==1) return n;
    else for (x1 = n/2; (x2 = 0.5*(x1 + n/x1)) != x1; x1 = x2);
    return x2;
  }
/*-----------------------------------------------------------------------*/
/* Solução recursiva. Parâmetros: número e aproximação da raiz.          */
/*-----------------------------------------------------------------------*/
  public static double raizr(double n,double x1) {
    double x2 = 0.5*(x1 + n/x1);
    if (n == 0 || n == 1) return n;
    else if (x2 != x1) return raizr(n,x2);
    else return x2;
  }
/*-----------------------------------------------------------------------*/
/* Programa principal.                                                   */
/*-----------------------------------------------------------------------*/
  public static void main(String argumentos[]) {
	double n;

    do {
      n = Teclado.readDouble("Entre um número não negativo: ");
    } while (n < 0);

    DecimalFormat casas = new DecimalFormat("0.000000000000000");
    System.out.println("Compilador Java  = " + casas.format(Math.sqrt(n)));
    System.out.println("Método iterativo = " + casas.format(raizi(n)));
    System.out.println("Método recursivo = " + casas.format(raizr(n,n/2)));
  }

}