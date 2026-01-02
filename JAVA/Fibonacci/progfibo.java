class ParametroFibonacciErrado extends Exception {
    public ParametroFibonacciErrado() { super(); }
    public ParametroFibonacciErrado(String s) { super(s); }
}

class ProgressaoFibonacci extends Progressao { // progressao Fibonacci
    int termo1, termo2;
    int valPrev;

    ProgressaoFibonacci() { // valores default
	termo1 = 0;
	termo2 = 1;
    }
    
    ProgressaoFibonacci(int t1, int t2) 
	throws ParametroFibonacciErrado {

	if ((t1 < 0) || (t2 <= 0)) throw new ParametroFibonacciErrado("Parametro com valor errado.");
	termo1 = t1;
	termo2 = t2;
    }

    protected int inicia() {
	valCor  = termo1;
	valPrev = termo2 - valCor;
	return valCor;
    }

    protected int proxTermo() {
	int temp = valPrev;
	valPrev = valCor;
	valCor = valCor + temp;
	return valCor;
    }
}
