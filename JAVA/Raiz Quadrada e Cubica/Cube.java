/**
 * Classe que implementa métodos estáticos para o cálculo de raíz cúbica
 */
public class Cube
{
  /* Método que calcula a raíz cúbica utilizando o algoritmo de Newton.
   * 
   * @author Fundão da Computação
   * @param  valor - double que representa o número do qual deve ser calculada a raíz
   * @param  erro  - double que representa a margem de erro do cálculo.
   * 
   * @return o valor calculado da raíz
   */
  public static double NewtonMethod( double valor, double erro )
  {
     double result = 1, palpite;

     do
     {
       palpite = result;
       result  = (valor/(palpite*palpite) + 2*palpite)/3;
     } while( Math.abs(palpite - result) > erro );
     return result;
  }

  public static void main( String [] args )
  {
    System.out.println(Cube.NewtonMethod(Double.parseDouble(args[0]), Double.parseDouble(args[1])));
  }  
}