/*-----------------------------------------------------------------------*/
/* Lê um número inteiro e positivo e determina se é primo ou composto.   */
/* Francisco A. S. Grossi                                                */
/*-----------------------------------------------------------------------*/
public class Primo {
  public static void main(String[] s) {
  
   long numero,fator,ultimo;
    boolean primo;

   do 
     numero = Teclado.readLong("Entre um número inteiro maior que 1: ");
   while (numero < 2); 

   primo = numero < 4 || numero % 2 == 1; 
   ultimo = (long) Math.sqrt(numero);
            
   for (fator=3; primo && fator <= ultimo; fator += 2)
     primo = numero % fator != 0;

   if (primo) System.out.println(numero + " é primo");
   else System.out.println(numero + " é composto");
  }

}