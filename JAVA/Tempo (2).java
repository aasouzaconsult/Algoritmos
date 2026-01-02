/**----------------------------------------------------------------------*/
/** Medição de tempo decorrido entre dois eventos.                       */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
public class Tempo {

  public static void main(String[] args) {
    String str = "qualquer coisa para teste";
    long inicio,fim;

    inicio = System.currentTimeMillis();      /* Dispara cronômetro */

    for(long i = 0; i < 1000000; i++)         /* Faz alguma coisa   */
      str.indexOf('@');                       /* para passar tempo  */

    fim = System.currentTimeMillis();         /* Pára o cronômetro  */

    System.out.println("Tempo decorrido: " + (double)(fim-inicio)/1000 +
        " segundos");
  }

}