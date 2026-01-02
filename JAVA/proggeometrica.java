class ProgressaoGeom extends Progressao { // progressao geometrica
    protected int base;

    ProgressaoGeom() { base = 2; } /* base default */
    
    ProgressaoGeom(int a_base) { base = a_base; }

    protected int inicia() {
	valCor = base;
	return valCor;
    }
    
    protected int proxTermo() {
	valCor = valCor * base;
	return valCor;
    }

    // herda valorCorrente(), iesimoTermo(int) e imprimeProgressao da
    // classe base Progressao
}
