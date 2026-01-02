/**----------------------------------------------------------------*/
/** Escreve dígitos de um número inteiro separadamente (recursivo).*/
/** Francisco A. S. Grossi                                         */
/**----------------------------------------------------------------*/
import Teclado;
public class Separado {

  public static void separa(long n) {
    if (n > 9) separa(n/10);
  	System.out.print(n%10 + " ");
  }	
	
  public static void main(String argumentos[]) {
	long numero;
    numero = Teclado.readLong("Entre um número inteiro: ");
	if (numero < 0) 
	  separa(-numero);
    else separa(numero);
  }

}