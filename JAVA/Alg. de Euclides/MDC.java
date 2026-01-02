/**
 * Classe que implementa o algoritmo de Euclides para cálculo do MDC
 */
class MDC
{
  /* Método que realiza a troca dos valores de duas variáveis.
   * 
   * @author Fundão da Computação
   * @param  a - Primeiro valor
   * @param  b - Segundo Valor
   * 
   */
  static public void troca(int a, int b)
  {
    int aux = a;
    a = b;
    b = aux;
  }

  /* Método que calcula o MDC de a e b utilizando o algoritmo euclidiano.
   * 
   * @author Fundão da Computação
   * @param  a - Primeiro valor
   * @param  b - Segundo valor
   * 
   * @return o valor do MDC de A e B
   */
  static public int mdc(int a, int b)
  {
    int r;
    if( a < b )
       troca( a, b );
    while( b != 0 )
    {
      r = a % b;
      a = b;
      b = r;
    }
    return a;
  }

  public static void main( String [] str )
  {
     if( str.length > 1 )
        System.out.println(mdc(Integer.parseInt(str[0]),Integer.parseInt(str[1])));
     else
     {
        System.out.println("Número de parâmetros inválidos");
     }
  }
}
