/**----------------------------------------------------------------------*/
/** Mostra vários campos do calendário local.                            */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
import javax.swing.*;
import java.util.*;
import java.text.*;

public class Calendario0 {
  static Date hoje = new Date();
  static DateFormat fmt;
  static int[] tipo = {
           DateFormat.DEFAULT,
           DateFormat.SHORT,
           DateFormat.MEDIUM,
           DateFormat.LONG,
           DateFormat.FULL
         };

   public static String simples(Locale currentLocale) {
      fmt = DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);
      return fmt.format(hoje) + "   " + currentLocale.toString() + '\n';
   }

  public static String data(Locale currentLocale) {
      String s = "";
      for (int k = 0; k < tipo.length; k++) {
         fmt = DateFormat.getDateInstance(tipo[k],currentLocale);
         s += fmt.format(hoje) + '\n';
      }
      return s;
   }

   public static String tempo(Locale currentLocale) {
      String s = "";
      for (int k = 0; k < tipo.length; k++) {
         fmt = DateFormat.getTimeInstance(tipo[k],currentLocale);
         s += fmt.format(hoje) + '\n';
      }
      return s;
   }

   public static String ambos(Locale currentLocale) {
      String s = "";
      for (int k = 0; k < tipo.length; k++) {
         fmt = DateFormat.getDateTimeInstance(tipo[k],tipo[k],currentLocale);
         s += fmt.format(hoje) + '\n';
      }
      return s;
   }

   public static void main(String[] args) {
     String msg = "\n"; 
     Locale local = new Locale("pt","BR");
     msg += simples(local) + '\n'; 
     msg += data(local) + '\n';    
     msg += tempo(local) + '\n';   
     msg += ambos(local);

     JOptionPane.showMessageDialog(null,
        msg,"Formatos locais",
       JOptionPane.INFORMATION_MESSAGE);
    
     System.exit(0);
   }

}
