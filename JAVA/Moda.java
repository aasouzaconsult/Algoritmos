/**----------------------------------------------------------------------*/
/** Lê vários números inteiros entre 1 e 50 e escreve sua moda. Se houver*/
/** mais de uma moda, informa a de maior valor. O fim de dados é indicado*/
/** pela leitura de qualquer número fora do intervalo.                   */
/** Algoritmo: cada número lido é usado como índice de um vetor (1 a 50) */
/** cujos elementos são usados para contar as freqüências correspondentes*/
/** Para cada número lido, soma-se 1 ao elemento cujo índice é o número. */
/** Declara-se o vetor com 51 elementos e usam-se os elementos 1 a 50    */
/** para que a correlação entre índice e número seja direta.             */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/

public class Moda {

  public static void main(String[] args) {
    final int n = 51;              // Tamanho do vetor de freqüências 
    int[] frequencia = new int[n];
    int i, x, moda;

    System.out.println("Entre vários números entre 1 " + (n-1));
    System.out.println("Número fora do intervalo indica fim de dados");

    x = Teclado.readInt("");       // Lê o primeiro
    while (x > 0 && x < n) {       // Enquanto for válido 
      ++frequencia[x];             // Soma 1 à freqüência de x
      x = Teclado.readInt("");     // Lê o seguinte 
    }

    for (moda = 1, i = 2; i < n; ++i)
      if (frequencia[i] >= frequencia[moda]) moda = i;

    if (frequencia[moda] > 0)
       System.out.println("\nA moda é " + moda + " e ocorre " +
          frequencia[moda] + "vezes");
    else System.out.println("\nSeqüência vazia");
  }

}