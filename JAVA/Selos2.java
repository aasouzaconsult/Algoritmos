public class Selos2 {
  
  public static void main(String[] s) {
    int centavos, cinco, tres = 0;

    do {
      centavos = Teclado.readInt("Entre o custo da carta em centavos:");
    } while (centavos < 8);      
 
    while (centavos % 5 > 0) {
      centavos -= 3;
      tres++;
    }
    
    cinco = centavos / 5; 

    System.out.println("\nSelagem: " + cinco + " selos de 5 centavos e "
       + tres + " selos de 3 centavos\n");
  }

}
