class Polinomio
{

  private double arr[];

  public Polinomio(int grado)
  {
     arr = new double[grado + 1];
  }

  public Polinomio(double coef[])
  {
     this(coef.length - 1);
     for(int i = 0; i < coef.length; i++)
        arr[i] = coef[i];
  }

  public void asignarCoeficientes(double coef[])
  {
     for(int i = 0; i < coef.length; i++)
       arr[i] = coef[i];
  }

  public double []obtenerCoeficientes()
  {
      return arr;
  }

  public double obtenerCoef(int posicion)
  {
     return arr[posicion];
  }

  public void asignarCoef(int posicion, double valor)
  {
     arr[posicion] = valor;
  }
  
  public double evaluar(double t)
  {
     double s = 0.0;
     for(int i = 0; i < arr.length; i++)
        s += arr[i] * Math.pow(t,i);
   
     return s;
  }

  public int obtenerGrado()
  {
     return arr.length - 1;
  }

  public static Polinomio integrar(Polinomio c, double cte)
  {
     Polinomio tmp = new Polinomio(c.obtenerGrado() + 1);   
     tmp.asignarCoef(0,cte);     
     for(int i = 1; i <= tmp.obtenerGrado() ; i++)
        tmp.asignarCoef(i , c.obtenerCoef(i-1) / i );        

     return tmp;
  }

  public static Polinomio derivar(Polinomio c)
  {
     Polinomio tmp = new Polinomio(c.obtenerGrado() - 1);   
     for(int i = 0; i <= tmp.obtenerGrado() ; i++)
        tmp.asignarCoef(i , c.obtenerCoef(i+1) * (i+1) );        

     return tmp;
  }

public String toString(String var)
  {
     String s = Double.toString(arr[0]);

     for(int i = 1; i <= obtenerGrado( ); i++)
        if (arr[i] != 0.0)    
        {       
           if (arr[i] < 0.0 ) s += " - ";
           else s += " + ";
       
           s += Double.toString( Math.abs(arr[i]));
           s += var;
           
           if (i > 1) 
           {
              s += "^";
              s += Integer.toString(i);
           }    
        }
  
     return s; 
  }


}