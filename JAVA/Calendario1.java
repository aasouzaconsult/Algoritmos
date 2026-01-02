/**----------------------------------------------------------------------*/
/** Mostra vários campos do calendário padrão.                           */
/** Francisco A. S. Grossi                                               */
/**----------------------------------------------------------------------*/
import javax.swing.*;
import java.util.*;

public class Calendario1 {

  public static void main(String[] args) {
 	  Calendar agora = new GregorianCalendar();
    String msg = "\nEra: " + agora.get(Calendar.ERA);
    msg += "\nAno: " + agora.get(Calendar.YEAR);
    msg += "\nMês: " + agora.get(Calendar.MONTH);
    msg += "\nSemana do ano: " + agora.get(Calendar.WEEK_OF_YEAR);
    msg += "\nSemana do mês: " + agora.get(Calendar.WEEK_OF_MONTH);
    msg += "\nData: " + agora.get(Calendar.DATE);
    msg += "\nDia do mês: " + agora.get(Calendar.DAY_OF_MONTH);
    msg += "\nDia do ano: " + agora.get(Calendar.DAY_OF_YEAR);
    msg += "\nDia da semana: " + agora.get(Calendar.DAY_OF_WEEK);
    msg += "\nDia da semana no mês: "+
            agora.get(Calendar.DAY_OF_WEEK_IN_MONTH);
    msg += "\nManhã/Tarde: " + agora.get(Calendar.AM_PM);
    msg += "\nHora: " + agora.get(Calendar.HOUR);
    msg += "\nHora do dia: " + agora.get(Calendar.HOUR_OF_DAY);
    msg += "\nMinuto: " + agora.get(Calendar.MINUTE);
    msg += "\nSegundo: " + agora.get(Calendar.SECOND);
    msg += "\nMilisegundo: " + agora.get(Calendar.MILLISECOND);
    msg += "\nDiferença GMT: " +
            (agora.get(Calendar.ZONE_OFFSET)/(60*60*1000));
    msg += "\nHorário de verão: " +
            (agora.get(Calendar.DST_OFFSET)/(60*60*1000));

    JOptionPane.showMessageDialog(null,
       msg,"Campos do Calendário Gregoriano",
       JOptionPane.INFORMATION_MESSAGE);
    
    System.exit(0);
  }
}