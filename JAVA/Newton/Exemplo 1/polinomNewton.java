class PolinomioNewton extends Polinomio implements Evaluar
{
	
	public PolinomioNewton(double coef[])
	{
		super(coef);
	}
	
	public double f(double x)
	{
		return evaluar(x); 	
	}	
	
	public PolinomioNewton derivar(PolinomioNewton p)
	{
		double coef[] = p.obtenerCoeficientes();
		Polinomio tmp = new Polinomio(coef);
		tmp = tmp.derivar(tmp);
		coef = tmp.obtenerCoeficientes();
		return new PolinomioNewton(coef); 
	}
	
}