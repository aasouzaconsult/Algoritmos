
class pruebaNewton
{
	
	public static void impResult(double xo, Newton n, Evaluar funcion, Evaluar derivada)
	{
		n.asignarDatos(xo);
		System.out.println("\n\tPonto inicial : " + xo);
		System.out.println("\tf''(" + xo + ") : " + funcion.f(xo));
	}
	
	public static void main(String arg[])
	{
		Newton n = new Newton();	
		
		/*  Funcao = 4 - 9x - 3x^2 + x^3 */
		
		double coef[] = { 4.0 , -9.0 , -3.0 , 1.0  };
		
		PolinomioNewton fx = new PolinomioNewton(coef);
		
		PolinomioNewton dxa = fx.derivar(fx);
		PolinomioNewton dx = dxa.derivar(dxa); // Derivada 2º
		
		System.out.println("\n\tMetodo de Newton");
          System.out.println("\t----------------");
		
		System.out.println("\n\tFuncao : " + fx.toString("x"));
		System.out.println("\n\tDerivada 1 : " + dxa.toString("x"));
		System.out.println("\n\tDerivada 2 : " + dx.toString("x"));
		
		impResult(  2 , n , dx,dxa);
		impResult(3.5 , n , dx,dxa);
		impResult(3.05, n , dx,dxa);
		
		//impResult(  2 , n , dxa,dx);
		//impResult(3.5 , n , dxa,dx);
		//impResult(3.05, n , dxa,dx);
			    
		System.out.println();
	}		
}