class ProgressaoArit extends Progressao { // progressao aritmetica
    protected int incremento;

    ProgressaoArit() { incremento = 1; } /* incremento default */

    ProgressaoArit(int incr) { incremento = incr; } /* determina o incremento */
    
    protected int inicia() {
	valCor = 0;
	return valCor;
    }

    protected int proxTermo() {
	valCor = valCor + incremento;
	return valCor;
    }

    // herda valorCorrente(), iesimoTermo(int) e imprimeProgressao da
    // classe base Progressao
}
