/* MetodoFibonacci_a.java
 * Created on 17 de Outubro de 2004, 23:59
 * @Author: Antonio Alex  (Faculdade Lourenço Filho)
 *          Dennys Muller (Faculdade Lourenço Filho)
 *          Claudemir     (Faculdade Lourenço Filho)
 * Feito o Algoritmo do Método de Fibonacci, conforme exercicio que o Prof.André 
 *(PO II), deu como Trabalho. Item A.
 */

import java.awt.Container;
import javax.swing.*;
import java.text.*;

public class MetodoFibonacci_a extends JApplet {

   public void init()
   {
      String s1 = JOptionPane.showInputDialog(
         "Intervalo : Entre com o Valor Inicial" );
      String s2 = JOptionPane.showInputDialog(
         "Intervalo : Entre com o Valor Final" );
      String s3 = JOptionPane.showInputDialog(
         "Iterações : Entre com a Quantidade" );

      
      double i1 = Double.parseDouble( s1 );
      double i2 = Double.parseDouble( s2 );
      double n = Double.parseDouble( s3 );

      double fibo = fibonacci(n);
      
      //Método
      double d1=i2-i1;
            
      double d[] = new double [100];
      double f_dk[] = new double [100];
        
      for ( int k = 1 ; k <= n ; k ++ )
	  {
	     double ind=n-k+1;
      	 double f_ind=fibonacci(ind);
      	 double dk=f_ind*d1/fibo;
      	 d[k]=dk;
      	 System.out.print("D"+k+" = "+dk+"  ");
      	 //double p1,p2,Lado;
      	 //d[1]=10;
      	 //d[2]=6.25;
      	 
      	 //Calculo da Função
      	 f_dk[k]=dk*dk-9*dk+20;
      	 System.out.print("F("+dk+") e igual "+f_dk[k]+"\n\n");
      	 
      	 //f_dk[3]=Ini_Interv + d[4];
      	   
	  }
	  
	  	 /*double aux;
      	       	       	 
      	 if (f_dk[1] > f_dk[2])
      	 {
      	 	double Ini_Interv = i1;
      	 	double Fim_Interv = f_dk[1];
	 		int d=1;
      	 } 
      	 else
      	 {
      	 	double Ini_Interv = f_dk[2];
      	 	double Fim_Interv = i2;
      	 	int d=2;
      	 }
      	 
      	 if (d=1)
      	 {
      	 	f_dk[3]=Ini_Interv + d[4]; 
      	 } 
      	 else
      	 {
      	 	f_dk[3]=Fim_Interv - d[4];
      	 }
      	 */
	  
	    
      // Criando JTextArea para Mostrar resultados na tela
      JTextArea outputArea = new JTextArea();

      // Mostra na Tela
      outputArea.setText( "Valor de Intervalo 1 -> " + i1 +
         "\nValor de Intervalo 2 -> " + i2 + "\nFibonacci " + fibo+
         "\nd1 = "+d[1]+"\nd2 = "+d[2]+"\nd3 = "+d[3]+"\nd4 = "+d[4]+"\nd5 = "+d[5]);

      
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
