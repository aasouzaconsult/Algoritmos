public abstract class Progressao {
    protected int valCor; // valor corrente da progressao

    Progressao() {
	valCor = 0;
    }

    protected int valorCorrente() {
	return valCor;
    }

    protected int inicia() { // inicia a progressao
	valCor = 0;
	return valCor;
    }

    protected int proxTermo() { // deve retornar o proximo valor da progressao
	return valCor;          // a implementacao desta classe abstrata simplesmente
    }                           // retorna o valor corrente.

    protected int iesimoTermo(int i) { // deve retornar o i-esimo termo da progressao
	inicia();
	for (int j=1; j<i; j++) proxTermo();
	return valorCorrente();
    }

    public void imprimeProgressao(int n) { // imprime os n primeiros termos da progressao
	System.out.print(inicia() + " ");
	for (int i=1; i<n; i++)
	    System.out.print(proxTermo() + " ");
	System.out.println();
    }
}

	
