/* Newton_a.java
 * Created on 12 de Outubro de 2004, 17:53
 * @Author: Antonio Alex  (Faculdade Lourenço Filho)
 *          Dennys Muller (Faculdade Lourenço Filho)
 *          Claudemir     (Faculdade Lourenço Filho)
 * Feito o Algoritmo do Método de Newton, conforme exercicio que o Prof.André 
 *(PO II), deu como Trabalho. Item A.
 */
import java.io.*;
import java.util.Date;
import java.text.DecimalFormat;


public class Newton_a {
    
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
            
            // Minimo y = x^2 - 9x + 20    Intervalo [0,10]
            // Derivada 1º
        	// 2x - 9 = 0
        	// Derivada 2º
        	// 2 
        	// Substituindo na Derivada 2º(Para achar o mínimo)
                    
        	double x[] = new double [100];
        	double f1x[] = new double [100];
        	double f2x[] = new double [100];
        
        	for ( int k = 1 ; k <= n ; k++ )
	    	{
            	x[0]=v1;  // Entrada do Algoritmo
                    
            	// Calculo das funções para Derivada 1º ( 2x - 9 = 0 )
            	f1x[0]= 2*(x[0]) - 9;
            	f2x[0]= 2;
                                                             
	        	// Calculo do Método da Newton
            	x[k] = x[k-1]-(f1x[k-1]/f2x[k-1]);
            	System.out.println("x"+(k)+" = "+x[k]);
            
            	// Calculo das funções para Derivada 1º ( 2x - 9 = 0 )
            	f1x[k]= 2*(x[k]) - 9;
            
            	// Calculo das funções para Derivada 2º ( 2 )
            	f2x[k]= 2;
                  
          	}
          	          	
           	System.out.println("-------------------- Anotacoes ----------------");    
           	System.out.println("/n-------------- Derivada das Funcoes -----------");
           	System.out.println("f'("+x[0]+")= "+f1x[0]);
           	System.out.println("f''("+x[0]+")= "+f2x[0]);
           
           	for ( int k = 1 ; k <= n ; k++ )
	       	{
                    f1x[k]= 2*(x[k]) - 9;
                    f2x[k]= 2; 
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
           	long total = System.currentTimeMillis() - tempo;
           	DecimalFormat  formatador  = new DecimalFormat();
           	formatador.applyPattern("###########;(###########)");
           	System.out.println("\nMetodo executado em "+formatador.format(total)+" milisegundos.");
        }
        
        catch (IOException e)
        {
            System.out.println("Erro de entrada: " + e);
        }
        
     }
}
