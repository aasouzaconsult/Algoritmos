/**----------------------------------------------------------------------*/
/** Testa classe Data.                                                   */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
public class TestaData {

  public static void main(String[] p) {
    Data d1 = new Data(31,12,1998);
    Data d2 = new Data(1,1,1999);
    
    System.out.println("Uma data = " + d1);
    System.out.println("Outra data = " + d2);
    
    if (d1.equals(d2))
      System.out.println("As datas são iguais");
    else System.out.println("As datas são diferentes\n");
    
    if (d1.anterior(d2))
      System.out.println(d1 + " é anterior a " + d2 + "\n");
    if (d1.posterior(d2))
      System.out.println(d1 + " é posterior a " + d2 + "\n");
    
    d1.diaSeguinte();
    System.out.println("Outra data = " + d1);

    if (d1.equals(d2))
      System.out.println(d1 + " é igual a " + d2 + "\n");
    else System.out.println(d1 + " é diferente de " + d2 + "\n");

    d1.setData(28,2,1980);
    System.out.println("Ano de " + d1 + " é bissexto = " + d1.bissexto());
    d2.setData(d1);
    d2.diaSeguinte();
    System.out.println("Seguinte a " + d1 + " = " +  d2);  
    d2.diaSeguinte();
    System.out.println("Mais um dia " + " = " + d2 + "\n");  

    d1.setData(28,2,1900);
    System.out.println("Ano de " + d1 + " é bissexto = " + d1.bissexto());
    d2.setData(d1);
    d2.diaSeguinte();
    System.out.println("Seguinte a " + d1 + " = " +  d2);  
    d2.diaAnterior();
    System.out.println("Menos um dia " + " = " +  d2);  
  }

}
