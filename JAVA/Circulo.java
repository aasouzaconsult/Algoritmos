//Classe de implementação de um Quadrado
//incluindo suporte para toString e 
//para desenho em Graphics
//
//Alguns campos com implementacao identica
//a Ponto.java

//usar funções da awt
import java.awt.*;

//a nossa classe...
class Circulo {
	//Campos públicos...
	public Ponto centro;
	public int raio;

	//Campos privados...

	//ver classe Ponto
	private static Color globalColor=Color.black;
	
	//ver classe Ponto
	private Color myColor;

	//Construtores...
	
	//Nesta classe optamos por criar e inicializar 
	//os objectos nos construtores (ao contrário do que 
	//acontece na classe Quadrado), como tal é 
	//necessário criar os objectos nos construtores.
	//
	//Para facilitar a implementação os contrutores
	//Circulo() e Circulo(int,int,int) chamam o 
	//construtor Circulo(Ponto,int);
	public Circulo() {
		this(new Ponto(0,0),0);
	}

	public Circulo(int x, int y, int raio) {
		this(new Ponto(x,y),raio);
	}

	public Circulo(Ponto centro, int raio) {
		this.centro=centro;
		this.raio=raio;
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

	//ver classe Quadrado
	public String toString() {
		return "C:" + centro + " R:" + raio;
	}

	//ver classe Ponto
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(this.getColor());
		g.fillOval(centro.x-raio, centro.y-raio, raio*2, raio*2);
		g.setColor(c);
	}
}