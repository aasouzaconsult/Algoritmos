class pruebaSecante
{
	
public static void main(String arg[])
	{
		Secante s = new Secante();	
		
		double coef[] = { 9.0 , 6.0 , 3.0 , 0.0 };
		
		EvalPolinomio p = new EvalPolinomio(coef);
		
		s.asignarDatos(5.0,2.0);
		
		System.out.println("\n\tMetodo da Secante");
		System.out.println("  \t-----------------");
		
		System.out.println("\n\tf(x) : " + p.toString("x"));
		
		System.out.println("\n\tf(2.0) : " + p.f(2.0));
		System.out.println("\tf(5.0) : " + p.f(5.0));
		
		System.out.println("\n\traiz : " + s.raiz(p));
	
		System.out.println("\n\tNumero de Iteracoes : " + s.numIteraciones());

		System.out.println();
	}		
	
}