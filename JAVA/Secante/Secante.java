/* Secante.java
 * Created on 12 de Outubro de 2004, 13:00
 * @Author: Antonio Alex  (Faculdade Lourenço Filho)
 *          
 * Feito o Algoritmo do Método da Secante, conforme exercicio que o Prof.André 
 *(PO II),deu em sala.
 */
import java.io.*; 
 
public class Secante {
    
    public static void main(String args[]) 
    {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int n;
	  	double v1,v2;
        try
        {
            System.out.println("------ Metodo da Secante --------\n");
            System.out.print("Digite o Valor de x0: ");
            v1 = Double.parseDouble(br.readLine());
            System.out.print("Digite o Valor de x1: ");
            v2 = Double.parseDouble(br.readLine());
            System.out.print("Digite o Numero de Iteracoes apos o x1: ");
            n = Integer.parseInt(br.readLine());  
            
            // Iniciando a contagem do Tempo
            long tempo = System.currentTimeMillis();
          
           	double x[] = new double [100];
        	double f1x[] = new double [100];
        	
        	System.out.println("x0= "+v1+" -> Dado no Algoritmo");
           	System.out.println("x1= "+v2+" -> Dado no Algoritmo");
           	
        	for ( int k = 2 ; k <= n+1 ; k++ )
	  		{
            	// Minimizar f(x)= x^3 - 3x^2 - 9x - 4
       
      	        x[0]=v1;  // Entrada do Algoritmo
            	x[1]=v2;  // Entrada do Algoritmo
                        
            	// f1(x) = 3x^2 -6x -9 
            	// Calculo das funções (x0 e x1)
            	f1x[0]= 3*(x[0]*x[0])- 6*x[0] - 9;
            	f1x[1]= 3*(x[1]*x[1])- 6*x[1] - 9;  
                                
            	// Calculo do Método da Secante
            	x[k]= x[k-1]-(f1x[k-1]*(x[k-2]-x[k-1])/(f1x[k-2]-f1x[k-1]));
            	// Mostra na tela o calculo dos x[k]
    			System.out.println("x"+k+"= "+x[k]+" -> Calculado no Alg.");        	
            
            	// Calculo das funções
            	f1x[k]= 3*(x[k]*x[k])- 6*x[k] - 9;  // Funcao de x2 = 2.6
            	
          	}
            
            System.out.println("\n---------- Anotacoes ------------\n"); 
           	System.out.println("------ Derivada das Funcoes -----");
           	System.out.println("f'(0)= "+f1x[0]);
           	System.out.println("f'(1)= "+f1x[1]);
           
           	for ( int k = 2 ; k <= n+1 ; k++ )
	  		{
            	System.out.println("f'("+x[k]+")= "+f1x[k]);
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
