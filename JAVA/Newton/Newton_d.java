/* Newton_d.java
 * Created on 17 de Outubro de 2004, 23:50
 * @Author: Antonio Alex (Faculdade Lourenço Filho)
 *          Dennys Muller (Faculdade Lourenço Filho)
 *          Claudemir     (Faculdade Lourenço Filho)
 * Feito o Algoritmo do Método de Newton, conforme exercicio que o Prof.André 
 *(PO II),deu como Trabalho. Item D.
 */
import java.io.*;

public class Newton_d {
    
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
            
            // Minimizar sen x -1
           
        	double x[] = new double [100];
        	double f1x[] = new double [100];
        	double f2x[] = new double [100];
        
        	System.out.println("* Valores de X tendendo ao Otimo *"); 
        	for ( int k = 1 ; k <= n ; k++ )
	    	{
            	x[0]=v1;  // Entrada do Algoritmo
                    
            	// Calculo das funções para Derivada 1º ( cos x)
            	f1x[0]= Math.cos(x[0]);
            	                        
            	// Calculo das funções para Derivada 2º ( - sen x)
            	f2x[0]= - (Math.sin(x[0]));
             
                                               
	        	// Calculo do Método da Newton
            	x[k] = x[k-1]-(f1x[k-1]/f2x[k-1]);
            
            	System.out.println("x"+(k)+" = "+x[k]);
            
            	f1x[k]= Math.cos(x[k]); 
            	f2x[k]= - (Math.sin(x[k]));
            
          	}
           
           	System.out.println("---- Derivada das Funcoes -----");
           	System.out.println("f'("+x[0]+")= "+f1x[0]);
           	System.out.println("f''("+x[0]+")= "+f2x[0]);
           
           	for ( int k = 1 ; k <= n ; k++ )
	    	{
              f1x[k]= Math.cos(x[k]);
              f2x[k]= - (Math.sin(x[k]));
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
