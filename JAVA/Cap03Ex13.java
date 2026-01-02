//SWITCH... CASE

import java.util.Date;

public class Cap03Ex13 {
	public static void main (String args[])
	{
		int dia_da_semana;
		
		Date dt = new Date();
		dia_da_semana = dt.getDay();
		
		switch(dia_da_semana) {
			
			case 0: System.out.println("Hoje é Domingo.");
			break;
			case 1: System.out.println("Hoje é Segunda-feira.");
			break;
			case 2: System.out.println("Hoje é Terça-feira.");
			break;
			case 3: System.out.println("Hoje é Quarta-feira.");
			break;
			case 4: System.out.println("Hoje é Quinta-feira.");
			break;
			case 5: System.out.println("Hoje é Sexta-feira.");
			break;
			case 6: System.out.println("Hoje é Sábado.");
			break;
		}
	}
}
