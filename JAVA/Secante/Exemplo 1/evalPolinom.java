class EvalPolinomio extends Polinomio implements Evaluar
{
	public EvalPolinomio(double coef[])
	{
		super(coef);
	}
	
	public double f(double x)
	{
		return evaluar(x); 	
	}
}
