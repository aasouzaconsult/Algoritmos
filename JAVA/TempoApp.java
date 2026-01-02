// Aplicação de teste de
// Tempo.java
class TempoApp {

	public static void main(String args[]) throws java.io.IOException {

		//Testar construtores
		Tempo t1 = new Tempo(10,2,3);
		Tempo t2 = new Tempo("10:34");
		Tempo t3 = new Tempo("1:15:30");
		Tempo t4 = new Tempo("1:500");
		Tempo t5 = new Tempo(4500); //1:15:00

		//Testar toString
		System.out.println("t1=" + t1);
		System.out.println("t2=" + t2);
		System.out.println("t3=" + t3);
		System.out.println("t4=" + t4);
		System.out.println("t5=" + t5);
		
		//Testar somar
		System.out.println("t1+t2=" + t1.somar(t2));
		System.out.println("t1+t3=" + t1.somar(t3));
		System.out.println("t1+t4=" + t1.somar(t4));
		System.out.println("t1+t5=" + t1.somar(t5));

		//Testar equals
		System.out.println("t3==t5? " + t3.equals(t5));
		System.out.println("t3==t5+30 seg? " + t3.equals(t5.somar(new Tempo(30))));

		//Testar getFloat*
		System.out.println("t5 em Segundos= " + t3.getFloatSegundos());
		System.out.println("t5 em Minutos= " + t3.getFloatMinutos());
		System.out.println("t5 em Horas= " + t3.getFloatHoras());

		System.in.read();
	}

}