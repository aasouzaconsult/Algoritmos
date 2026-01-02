/**----------------------------------------------------------------------*/
/** Calcula a data da Páscoa no ano entrado como argumento.              */
/** Se o argumento for omitido, considera o ano atual.                   */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
import java.util.*;
import java.text.DecimalFormat;
public class Pascoa {

  public static void main(String[] args) {
    int dia,mes,ano;
    int i,j,k,m,c,n;
    Calendar agora = new GregorianCalendar();
  
    if (args.length > 0) ano = Integer.parseInt(args[0]); 
    else ano =  agora.get(Calendar.YEAR);
    
    if (ano < 1582) ano =  agora.get(Calendar.YEAR);
   
    c = ano / 100;
    n = ano - 19 * (ano / 19);
    k = (c - 17) / 25;
    i = c - c / 4 - (c - k) / 3 + 19 * n + 15;
    i = i - 30 * (i / 30);
    i = i - (i / 28) * (1 - (i / 28) * (29 / (i + 1)) * ((21 - n) / 11));
    j = ano + ano / 4 + i + 2 - c + c / 4;
    j = j - 7 * (j / 7);
    m = i - j;
    mes = 3 + (m + 40) / 44 ;
    dia = m + 28 - 31 * (mes / 4);
  
    DecimalFormat casas = new DecimalFormat("00");
    System.out.println("A Páscoa cai no dia " + casas.format(dia) +
        "/" + casas.format(mes) + "/" + casas.format(ano));
  }

}