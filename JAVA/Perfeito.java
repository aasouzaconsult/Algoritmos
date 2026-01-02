/*-----------------------------------------------------------------------*/
/* Verifica se um número inteiro e positivo é perfeito usando dois       */
/* algoritmos com diferentes eficiências.                                */
/* Um número é perfeito quando ele é igual à soma de seus divisores.     */
/* Francisco A. S. Grossi                                                */
/*-----------------------------------------------------------------------*/
import Teclado;
public class Perfeito {
/*-----------------------------------------------------------------------*/
/* Verifica se número é perfeito - algoritmo ineficiente.                */
/*-----------------------------------------------------------------------*/
  public static boolean perfeito1(long numero) {
    long soma,i;
    soma = 1;                            /* 1 divide qualquer número   */
    for (i=2; i <= numero/2; ++i)        /* Até metade do número       */
      if (numero % i == 0) soma += i;    /* Acumula, se divide número  */
    return numero == soma;               /* True ou false              */
   }
/*-----------------------------------------------------------------------*/
/* Verifica se número é perfeito - algoritmo eficiente.                  */
/*-----------------------------------------------------------------------*/
   public static boolean perfeito2(long numero) {
     long soma,i;
     double raiz = Math.sqrt(numero);    /* Limite para o divisor      */
     soma = 1;                           /* 1 divide qualquer número   */
     for (i=2; i < raiz; ++i)            /* Até antes da raiz quadrada */
       if (numero % i == 0)              /* Se divide número           */
         soma += i + numero/i;           /* Soma divisor e quociente   */
     if (raiz == (int) raiz)             /* Se raiz for inteira, ela   */
       soma += (int) raiz;               /* precisa ser somada         */
     return numero == soma;              /* True ou false              */
   }
/*-----------------------------------------------------------------------*/
/* Programa principal.                                                   */
/* Lê um número e verifica se é inteiro e positivo.                      */
/* Invoca as duas funções e diz se o número é ou não perfeito.           */
/*-----------------------------------------------------------------------*/
  public static void main(String argumentos[]) {
    long numero;

    do {
      numero = Teclado.readLong("Entre um número não negativo: ");
    } while (numero < 0);

    if (perfeito1(numero))                   
      System.out.println(numero + " é perfeito");
    else System.out.println(numero + " não é perfeito\n");

   if (perfeito2(numero))                    
      System.out.println(numero + " é perfeito");
   else System.out.println(numero + " não é perfeito\n");
  }

}