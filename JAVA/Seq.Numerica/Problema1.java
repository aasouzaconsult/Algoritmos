/**
 * Classe Problema1
 * - Implementa uma solução para, dado um valor n passado como parâmetro para o programa,
 * será calculado o valor de 1+1.2/1.3+1.2.3/1.3.5+.......+1.2.3.....N/1.3.5.........(2N-1)
 *
 * - Exemplo de utilização
 * c:\>java Problema1 3
 *
 * Por Fundão da Computação (http://www.fundao.pro.br)
 **/
class Problema1
{
  public static void main( String [] str )
  {
     double soma;
     int divisor, dividendo, n;
   
     soma    = 0.0;

     // Valor passado como parâmetro, convertendo-o de String para int
     n       = Integer.parseInt(str[0]); 

     // Laço responsável pela soma de todas as divisões
     for( int i = 1; i <= n; i++ )
     {
        divisor = dividendo = 1;
        
        // Laço que calcula cada um dos termos da soma 1.2/1.3 por exemplo
        for( int j = 1; j <= i; j++ )
        {
           divisor   = divisor * j;
           dividendo = dividendo * (2*j-1);
        }

        // Vai mostrando os resultados a cada iteração
        System.out.println(divisor);
        System.out.println(dividendo);
        System.out.println((double)divisor/dividendo + "\n");

        // Vai fazendo o somatório
        soma = soma + ((double)divisor/dividendo);
     }
     
     // Imprime o resultado
     System.out.println("Resultado: " + soma);
  }
}