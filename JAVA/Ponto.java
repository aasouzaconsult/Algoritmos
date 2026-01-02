//Classe de implementação de um Ponto
//incluindo suporte para toString e 
//para desenho em Graphics

//usar funções da awt
import java.awt.*;

//a nossa classe...
public class Ponto {
	//Campos públicos...
	public int x=0;
	public int y=0;

	//Campos privados...
	
	//Cor por defeito utilizada por todos os objectos
	//desta classe, como tal definida "static" 
	//Na prática a utilização de "static" implica que
	//o campo ao ser alterado por qualquer objecto a
	//alteraçãó é visível em todos os outros
	private static Color globalColor=Color.black;
	
	//A cor do nosso objecto, se for null é
	//utilizada a cor por defeito global da classe
	private Color myColor;

	//Constante auxiliar utilizada para desenhar
	//os pontos.
	private static final int RAIO = 4;

	//Construtores...

	//Este construtor embora aparentemente sem efeito
	//é necessário. A partir do momento que definimos
	//um construtor qualquer para a classe o construtor
	//por defeito deixa de estar definido.
	public Ponto() {
	}

	//Construtor que permite criar e definir directamente
	//o objecto a criar 
	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	//Métodos static...

	//Este método permite definir a cor por defeito
	//para todos os objectos.
	//Como é uma alteração global não faz sentido
	//utilizá-lo para objectos referenciados (embora
	//seja possível fazê-lo), assim optamos por o 
	//declarar "static" e deve ser utilizado
	//referenciando apenas a classe, por exemplo:
	//Ponto.serDefaultColor(Color.red)
	static public void setDefaultColor(Color c) {
		if (c!=null) //não deixar globalColor ser null
			globalColor = c;
	}

	//Restantes Métodos...

	//Definir a cor do ponto, se c for null entao
	//é utilizada a cor por defeito global.
	public void setColor(Color c) {
		myColor = c;
	}

	//Obter a cor de desenho do ponto
	public Color getColor() {
		if (myColor==null)
			return globalColor;
		else
			return myColor;
	}

	//Obter uma representação em texto do objecto
	public String toString() {
		return "[" + x + ";" + y + "]";
	}

	//Desenhar o objecto
	public void paint(Graphics g) {
		Color c = g.getColor(); //guardar cor actual
		g.setColor(this.getColor());
		g.fillOval(x-RAIO, y-RAIO, RAIO*2, RAIO*2);
		g.setColor(c); //recuperar cor
	}
}