public class Selos1 {
  
  public static void main(String[] s) {
    int centavos, cinco, tres , resto;

    do {
      centavos = Teclado.readInt("Entre o custo da carta em centavos:");
    } while (centavos < 8);      
 
    cinco = centavos / 5;
    resto = centavos % 5;

    while (resto % 3 > 0) {
      resto += 5;
      cinco--;
    }
    
    tres = resto / 3; 
    System.out.println("\nSelagem: " + cinco + " selos de 5 centavos e "
       + tres + " selos de 3 centavos\n");
  }

}