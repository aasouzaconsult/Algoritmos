class Newton
{
	public static double EPSILON = 0.00005;
	public final static int MAX_ITER = 500; 	
	
	private double x;
	
	private int cont;
	
	public void asignarDatos(double xi)
	{
		this.x = xi;
	    this.cont = 1;
	}
	
	public int numIteracoes()
	{
		return cont;	
	}	
	
	/*public double raiz(Evaluar funcion , Evaluar derivada)
	{
		double temp;
		
		do
		{
			temp = x;
			
			x -= funcion.f(x) / derivada.f(x);
			
			if (++cont > MAX_ITER ) break;
			
			if(Math.abs(x - temp) <= EPSILON) break;
			
			
		} while(true);	
	
		return x;
    } */	
	
	
	
	
}