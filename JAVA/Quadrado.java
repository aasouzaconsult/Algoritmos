//Classe de implementação de um Quadrado
//incluindo suporte para toString e 
//para desenho em Graphics
//
//Alguns campos com implementacao identica
//a Ponto.java

//usar funções da awt
import java.awt.*;

//a nossa classe...
class Quadrado {
	//Campos públicos...
	public Ponto centro=new Ponto(0,0);
	public int lado=0;

	//Campos privados...

	//ver classe Ponto
	private static Color globalColor=Color.black;
	
	//ver classe Ponto
	private Color myColor;

	//Construtores...
	
	//Nesta classe optamos por criar e inicializar 
	//os objectos na declaração (ao contrário do que 
	//acontece na classe Circulo), como tal não é 
	//necessário fazer nada no construtor por defeito
	//e nos outros basta alterar os campos
	public Quadrado() {
	}

	public Quadrado(int x, int y, int lado) {
		centro.x=x;
		centro.y=y;
		this.lado=lado;
	}

	public Quadrado(Ponto centro, int lado) {
		this.centro=centro;
		this.lado=lado;
	}

	//Métodos static...

	//ver classe Ponto
	static public void setDefaultColor(Color c) {
		if (c!=null)
			globalColor = c;
	}

	//Restantes Métodos...
	
	
	//ver classe Ponto
	public void setColor(Color c) {
		myColor = c;
	}

	//ver classe Ponto
	public Color getColor() {
		if (myColor==null)
			return globalColor;
		else
			return myColor;
	}

	//neste caso utilizamos o método toString() da
	//classe ponto implicitamente (o objecto centro
	//é da classe Ponto)
	public String toString() {
		return "C:" + centro + " L:" + lado;
	}

	//ver classe ponto
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(this.getColor());
		g.fillRect(centro.x-lado/2, centro.y-lado/2, lado, lado);
		g.setColor(c);
	}
}