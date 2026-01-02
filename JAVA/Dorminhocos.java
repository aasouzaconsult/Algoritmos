/**----------------------------------------------------------------------*/
/** Exemplo de um applet que dispara 4 threads.                          */
/** Cada um deles dorme por um tempo aleatório entre 0 e 15 segundos,    */
/** escrevendo na tela os vários estágios por onde passam.               */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
import java.text.DecimalFormat;
public class Dorminhocos {
  
  public static void main(String args[]) {
    EscreveThread threadl, thread2, thread3, thread4;
    threadl = new EscreveThread("Dorminhoco1");
    thread2 = new EscreveThread("Dorminhoco2");
    thread3 = new EscreveThread("Dorminhoco3");
    thread4 = new EscreveThread("Dorminhoco4");
    
    System.out.println("\nIniciando os threads.\n");
    
    threadl.start();
    thread2.start();
    thread3.start();
    thread4.start();
    
    System.out.println("Todos os threads iniciaram.\n");
  }
}

final class EscreveThread extends Thread {
  private int tempo;
  DecimalFormat casas = new DecimalFormat("00000");
 
  public EscreveThread(String nome) {  // constructor desta classe
    super(nome);                       // construtor da classe Thread
    tempo = (int) (Math.random() * 15000);
    System.out.println("Nome: " + getName() + "; vai dormir " +
       casas.format(tempo) + " milisegundos.");
  }
   
  public void run () {                 // Executa o thread
    try {
      System.out.println( getName() + " iniciou o sono ("
         + casas.format(tempo) + " milisegundos).");
      sleep(tempo);
    }
    catch (InterruptedException exception) {
      System.out.println(getName() + ": " + exception.toString());
    }
    System.out.println(getName() + " acordou."); 
  }
}
