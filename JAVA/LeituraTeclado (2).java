/**----------------------------------------------------------------------*/
/** Exemplo de uso dos métodos de leitura direta do teclado.             */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
public class LeituraTeclado {

  public static void main(String args[]) {
    char c = Teclado.readChar("Entre um caractere:");
    System.out.println(c);
    byte b = Teclado.readByte("Entre um número inteiro (8 bits):");
    System.out.println(b);
    short h = Teclado.readShort("Entre um número inteiro (16 bits):");
    System.out.println(h);
    int i = Teclado.readInt("Entre um número inteiro (32 bits):");
    System.out.println(i);
    long l = Teclado.readLong("Entre um número inteiro (64 bits):");
    System.out.println(l);
    float f = Teclado.readFloat("Entre um número real (32 bits):");
    System.out.println(f);
    double d = Teclado.readDouble("Entre um número real (64 bits):");
    System.out.println(d);
    String s = Teclado.readLine("Entre um string:");
    System.out.println(s);

  }
}