/* Newton_b.java
 * Created on 12 de Outubro de 2004, 17:53
 * @Author: Antonio Alex (Faculdade Lourenço Filho)
 *          Dennys Muller (Faculdade Lourenço Filho)
 *          Claudemir     (Faculdade Lourenço Filho)
 * Feito o Algoritmo do Método de Newton, conforme exercicio que o Prof.André 
 *(PO II), deu como Trabalho. Item B.
 */
import java.io.*;

public class Newton_b {
    
    public static void main (String args[])
    {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int n;
	  	double v1;
	  	
	  	try
        {
            System.out.print("Metodo de Newton\n\n");
            System.out.print("Digite o Valor de x0: ");
            v1 = Double.parseDouble(br.readLine());
            System.out.print("Digite o Numero de Iteracoes: ");
            n = Integer.parseInt(br.readLine());  
          	
          	// Iniciando a contagem do Tempo
            long tempo = System.currentTimeMillis();
            
          	// Minimizar x^3 - 6x^2 + 9x -4
           
        	// Derivada 1º
        	// 3x^2 - 12x + 9 = 0
        	double a,b,c,delta,d1,d2;
        	a=3;
        	b=-12;	
        	c=9;
        	delta = (b*b)-(4*a*c);
        	d1=(-b + Math.sqrt(delta))/(2*a);
        	d2=(-b - Math.sqrt(delta))/(2*a);
        	// Derivada 2º
        	// 6x - 12 = 0
        	// Substituindo na Derivada 2º(Para achar o mínimo)
        	double y1,y2;
        	y1=6*d1-12;  // Substituindo x por d1 
        	y2=6*d2-12;  // Substituindo x por d2
                
        	double x[] = new double [100];
        	double f1x[] = new double [100];
        	double f2x[] = new double [100];
        
        	System.out.println("* Valores de X tendendo ao Otimo *"); 
        	for ( int k = 1 ; k <= n ; k++ )
	    	{
            	x[0]=v1;  // Entrada do Algoritmo
                    
            	// Calculo das funções para Derivada 1º ( 3x^2 - 6x - 9) para x0
            	f1x[0]= 3*(x[0]*x[0])- 12*x[0] + 9;
            
            	// Calculo das funções para Derivada 2º ( 6x - 6 ) para x0
            	f2x[0]= 6*x[0]- 12;
                
                // Calculo do Método da Newton
            	x[k] = x[k-1]-((f1x[k-1])/(f2x[k-1]));
            	x[1] = 5;
            	System.out.println("x"+(k)+" = "+x[k]);
                
                // Calculo das funções para Derivada 1º ( 3x^2 - 6x - 9 )
            	f1x[k]= 3*(x[k]*x[k])- 12*x[k] + 9;
            	            	
            	// Calculo das funções para Derivada 2º ( 6x - 6 )
            	f2x[k]= 6*x[k]- 12; 
           	}
           	
           	           	
           	System.out.println("------- Anotacoes ------------");    
           	System.out.println("Delta = "+delta);  
           	System.out.println("D1 = "+d1);
           	System.out.println("D2 = "+d2);
           	System.out.println("y''("+d1+") = "+y1+" -> Minimo(Otimo)");
           	System.out.println("y''("+d2+") = "+y2);
           	System.out.println("---- Derivada das Funcoes -----");
           	System.out.println("f'("+x[0]+")= "+f1x[0]);
           	System.out.println("f''("+x[0]+")= "+f2x[0]);
           
          	for ( int k = 1 ; k <= n ; k++ )
	        {
               f1x[k]= 3*(x[k]*x[k])- 12*x[k] + 9;
               f2x[k]= 6*x[k]- 12;
               System.out.println("f'("+x[k]+")= "+f1x[k]);
               System.out.println("f''("+x[k]+")= "+f2x[k]);
            }
            
            /* Teste dos Milisegundos (Caso alguem solicitar demostração)
           	StringBuffer var = new StringBuffer();
        	for (int i=0; i<100000; i++ ) {
            	var.append(i);
        	}*/
            
            // Mostrando o Tempo na Tela
           	System.out.println("-------------------- Tempo -------------------"); 
           	//System.out.println(" Iniciado em .....:"+ tempo);
           	//System.out.println(" Finalizado em ...:"+ System.currentTimeMillis());
           	System.out.println("\nMetodo executado em " + (System.currentTimeMillis() - tempo) + " milisegundos.");

        }
        
        catch (IOException e)
        {
            System.out.println("Erro de entrada: " + e);
        }
    }
}
