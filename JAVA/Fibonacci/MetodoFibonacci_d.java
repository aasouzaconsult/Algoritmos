/* MetodoFibonacci_d.java
 * Created on 19 de Outubro de 2004, 23:57
 * @Author: Antonio Alex  (Faculdade Lourenço Filho)
 *          Dennys Muller (Faculdade Lourenço Filho)
 *          Claudemir     (Faculdade Lourenço Filho)
 * Feito o Algoritmo do Método de Fibonacci, conforme exercicio que o Prof.André 
 *(PO II), deu como Trabalho. Item D.
 */
import java.io.*;
import java.util.Date;
import java.text.DecimalFormat;
import java.awt.Container;
import javax.swing.*;
import java.text.*;

public class MetodoFibonacci_d extends JApplet {

   public void init()
   {
      String s1 = JOptionPane.showInputDialog(
         "Intervalo : Entre com o Valor Inicial" );
      String s2 = JOptionPane.showInputDialog(
         "Intervalo : Entre com o Valor Final" );
      String s3 = JOptionPane.showInputDialog(
         "Iterações : Entre com a Quantidade" );
         
      // Iniciando a contagem do Tempo
      long tempo = System.currentTimeMillis();   
      
      double i1 = Double.parseDouble( s1 );
      double i2 = Double.parseDouble( s2 );
      double n = Double.parseDouble( s3 );

      double fibo = fibonacci(n);
      
      //Método
      double d1=i2-i1;
            
      double d[] = new double [100];
      double f_d[] = new double [100];
        
      for ( int k = 1 ; k <= n ; k ++ )
	  {
	     double ind=n-k+1;
      	 double f_ind=fibonacci(ind);
      	 double dk=f_ind*d1/fibo;
      	 d[k]=dk;
      	 System.out.print("D"+k+" = "+dk+"  ");
      	 //Calculo da Função
      	 f_d[k]=Math.sin(d[k]) - 1;
      	 System.out.print("F("+dk+") e igual "+f_d[k]+"\n\n");
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
      	  
	    
      // Criando JTextArea para Mostrar resultados na tela
      JTextArea outputArea = new JTextArea();

      // Mostra na Tela
      outputArea.setText( "Valor de Intervalo 1 -> " + i1 +
         "\nValor de Intervalo 2 -> " + i2 + "\nIteracoes : "+n+ "\nFibonacci " + fibo+
         "\n\nTrabalho de PO II");

      
      Container tela = getContentPane();

      tela.add( outputArea );

   }  
   
   public double fibonacci( double fb) // Função para Calculo do Fibonacci
   {
   	  if (fb < 2) return 1;
      return fibonacci(fb - 1) + fibonacci(fb - 2);
   } 

} 
/**************************************************************************
 * (C) Copyright 2004 by Antonio Alex, Dennys Muller, Claudemir           *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * Pesquisa Operacional II                                                *
 *                                                                        *
 *************************************************************************/
