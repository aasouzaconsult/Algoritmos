/**----------------------------------------------------------------------*/
/** Programa de teste para a classe de racionais.                        */
/** Usa classe CONSOLE (incluída nesta página) para leitura direta.      */
/** Como descende de Object, pode usar o método equals()                 */
/** Como o método toString foi substituído, um racional pode ser usado   */
/** diretamente no PRINTLN, pois ele é convertido por este método.       */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
public class TestaComplexo {

  public static void main(String argumentos[]) {

    int r = Teclado.readInt("Parte real do primeiro:");
    int i = Teclado.readInt("Parte imaginária do primeiro:");
    Complexo a = new Complexo(r,i);

    r = Teclado.readInt("Parte real do segundo:");
    i = Teclado.readInt("Parte imaginária do segundo:");
    Complexo b = new Complexo(r,i);

    if(a.equals(b))
      System.out.println("\nOs dois são iguais");
    else System.out.println("\nOs dois são diferentes");

    System.out.println("Adição       = " + a.soma(b));
    System.out.println("Subtração    = " + a.subtrai(b));
    System.out.println("Produto      = " + a.multiplica(b));
    System.out.println("Quociente    = " + a.divide(b));
  }

}