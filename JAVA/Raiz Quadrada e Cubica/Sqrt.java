/**
 * Classe que implementa métodos estáticos para o cálculo de raíz quadrada
 */
public class Sqrt
{
  /* Método que calcula a raíz quadrada utilizando o algoritmo de Newton.
   * 
   * @author Fundão da Computação
   * @param valor - double que representa o número do qual deve ser calculada a raíz   
   * @param erro  - double que representa a margem de erro do cálculo.
   * 
   * @return o valor calculado da raíz
   */
  public static double NewtonMethod( double valor, double erro )
  {
     double result = valor/2;  // valor do resultado, dividimos o valor
                               // inicial por dois para acelerar o cálculo
     double divisor;
     
     if ( valor < 1 )
        throw new NumberFormatException("Número inválido!");
     
     do
     {
       divisor = result;
       result = (valor/divisor + divisor)/2;
     } while( Math.abs(divisor - result) > erro );
     return result;
  }

  public static void main( String [] args )
  {
    System.out.println(Sqrt.NewtonMethod(Double.parseDouble(args[0]), Double.parseDouble(args[1])));
  }  
}