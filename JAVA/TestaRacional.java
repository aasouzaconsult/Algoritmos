/**----------------------------------------------------------------------*/
/** Programa de teste para a classe de racionais.                        */
/** Usa classe CONSOLE (incluída nesta página) para leitura direta.      */
/** Como descende de Object, pode usar o método equals()                 */
/** Como o método toString foi substituído, um racional pode ser usado   */
/** diretamente no PRINTLN, pois ele é convertido por este método.       */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
import Racional;
public class TestaRacional {

  public static void main(String argumentos[]) {
    Racional a = new Racional();
    Racional b = new Racional();
    Racional c = new Racional(); 

    a.setRacional(Teclado.readInt("Entre o numerador do primeiro  : "),
                  Teclado.readInt("Entre o denominador do primeiro: ")
                 );
    b.setRacional(Teclado.readInt("Entre o numerador do segundo   : "),
                  Teclado.readInt("Entre o denominador do segundo : ")
                 );

    if (a.equals(b))
      System.out.println("\nOs dois são iguais");
    else System.out.println("\nOs dois são diferentes");

    c = a.soma(b);
    System.out.println("Adição       = " + c);
    c.inverte();
    System.out.println("Inverso soma = " + c);
    c = a.subtrai(b);
    System.out.println("Subtração    = " + c);
    c = a.multiplica(b);
    System.out.println("Produto      = " + c);
    c = a.divide(b);
    System.out.println("Quociente    = " + c);
  }

}