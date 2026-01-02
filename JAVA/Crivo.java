/*-----------------------------------------------------------------------*/
/* Constrói um vetor booleano cujos elementos contidos em índices primos */
/* contêm TRUE. Este algoritmo chama-se como Crivo de Eratosthenes por   */
/* ter sido idealizado pelo astrônomo grego Eratosthenes (276-195 A.C).  */
/* Parâmetros: vetor e seu índice superior                               */
/* Francisco A. S. Grossi                                                */
/*-----------------------------------------------------------------------*/
public class Crivo {
  
  public static boolean[] crivo(int lim) {
    int raiz = (int) Math.sqrt(lim);   
    boolean[] primos = new boolean[lim+1];

    for (int i = 2; i <= lim; i++) 
      primos[i] = true;                    // Assume todos primos
 
    for (int i = 2; i <= raiz; i++)        // Após raiz, fatores repetem
      if (primos[i])                       // Se for primo então marca
        for (int j = i; j <= lim / i; j++) // todos os seus múltiplos
          primos[i*j] = false;             // como não primos
    
    return primos;
  }
/*-----------------------------------------------------------------------*/
/* Exemplo de invocação do Crivo para determinar se números são primos.  */
/*-----------------------------------------------------------------------*/
  public static void main(String[] s) {
    final int limite = 1000;
    boolean[] primos = crivo(limite);
    int n = Teclado.readInt("Entre um número inteiro (<2 termina):");

    while (n > 1) {
      if (primos[n]) System.out.println(n + " é primo");
      else System.out.println(n + " é composto");
      n = Teclado.readInt("Entre um número inteiro (<2 termina):");
    }

  }

}