import java.io.*;

class Fibonacci{

public static void main (String[] args) throws IOException{
 int fib1, fib2,  i, n, r;
 BufferedReader eingabe;

 // Eingabe
 eingabe = new BufferedReader(new InputStreamReader(System.in));
 System.out.print("n: ");
 n = Integer.parseInt(eingabe.readLine()); 

 // Schleife, in der die n. Fibonacci-Zahl berechnet wird
 for (fib1=1,fib2=2,i=3,r=n;i<=n;i++){
   r = fib1 + fib2;
   fib1 = fib2;
   fib2 = r;
 }

 // Ausgabe
 System.out.println ("Die " + n + ".te Fibonacci-Zahl ist " + r);
}

}

