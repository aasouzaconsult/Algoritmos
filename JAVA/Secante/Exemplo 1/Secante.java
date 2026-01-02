class Secante
{
	
	public static double EPSILON = 0.00005;
	public final static int MAX_ITER = 500; 	
	
	private double xi,xf;
	
	private int cont;
	
	public void asignarDatos(double xi,double xf)
	{
		this.xi = xi;
		this.xf = xf;
	    this.cont = 0;
	}
	
	public int numIteraciones()
	{
		return cont;	
	}
	
	public double raiz(Evaluar e)
	{
		do
		{
			double temp = xf;
			double aux = e.f(xf) - e.f(xi); 
			
			if (aux != 0)
				xf -= (e.f(xf) * (xf - xi)) / aux;
			else
				break;
			
			xi = temp;
			
		
			if (++cont > MAX_ITER ) break;
			
			if(Math.abs(xf - xi) <= EPSILON) break;
			
			
		} while(true);	
	
		return xf;
    } 	
}