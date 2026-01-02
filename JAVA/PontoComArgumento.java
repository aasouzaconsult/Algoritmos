import java.awt.*;

class PontoComArgumento extends Ponto{
	//Campos privados...
	private int arg;
	protected String toStringText = "A:";

	//Construtores...
	public PontoComArgumento() {
		this(new Ponto(0,0),0);
	}

	public PontoComArgumento(int x, int y, int arg) {
		this(new Ponto(x,y),arg);
	}

	public PontoComArgumento(Ponto centro, int arg) {
		setX(centro.getX());
		setY(centro.getY());
		setArg(arg);
	}

	protected void setArg(int arg) {
		this.arg = arg;
	}

	protected int getArg() {
		return arg;
	}

	public String toString() {
		return "C:" + super.toString() + " " + toStringText + getArg();
	}

}