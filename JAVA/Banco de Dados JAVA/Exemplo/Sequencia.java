import java.util.*;
import java.text.DateFormat;


public class Sequencia implements Runnable{
  int i=0;
  public void run(){
    try
	{
	   while(i <= 20){
          System.out.println(Thread.currentThread().getName());
	      Thread.currentThread().sleep((int)(Math.random()*1000));
	      i++;
       }
    }
    catch (InterruptedException  e) {}				
    } 
    
    public static void main (String args[]){
  
  	   Sequencia form = new Sequencia();
  	   new Thread(form, "Primeira Sequencia").start();
       new Thread(form, "Segunda  Sequencia").start();
    }	
 
}
