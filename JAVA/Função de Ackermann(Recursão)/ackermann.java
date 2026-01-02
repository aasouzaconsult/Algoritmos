// Função Ackermann com recursividade dupla

public class ackermann {
    public static void main(String[] args) {
	  int num  = Integer.parseInt(args[0]);
	  int num2 = Integer.parseInt(args[1]);
	  System.out.println("Ack("+num+"," + num2 + "): " + Ack(num, num2));
    }
    public static int Ack(int m, int n) {
	   return (m == 0) ? (n + 1) : ((n == 0) ? Ack(m-1, 1) :
				     Ack(m-1, Ack(m, n - 1)));
    }
}