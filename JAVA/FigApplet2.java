//Pequeno Applet de teste do método paint() das classes 
//com utilização dos métodos de manipulação de cores das classes.
//É uma extensão do FigApplet1

//imports...
import java.applet.Applet;
import java.awt.*;

//a nossa classe principal...
public class FigApplet2 extends Applet {
	
	//Declarar e criar os objectos...
	Ponto p1=new Ponto();
	Ponto p2=new Ponto(20,20);
	Ponto p3=new Ponto(100,100);
	Circulo c1=new Circulo(p2,20);
	Circulo c2=new Circulo(50,50,15);
	Quadrado q1=new Quadrado(new Ponto(190,190),20);
	Quadrado q2=new Quadrado(80,50,20);
	Quadrado q3=new Quadrado(180,20,40);
	//estes são os novos quadrados "coloridos"
	Quadrado q4=new Quadrado(190,10,20);
	Quadrado q5=new Quadrado(20,180,40);
	Quadrado q6=new Quadrado(10,190,20);
	
	//O método paint é chamado para desenhar a
	//àrea do applet.
	public void paint(Graphics g)
	{
		//os objectos normais
		p1.paint(g);
		p2.paint(g);
		p3.paint(g);
		c1.paint(g);
		c2.paint(g);
		q1.paint(g);
		q2.paint(g);

		//os objectos "coloridos"
		q3.paint(g);
		q4.paint(g);
		q5.paint(g);
		q6.paint(g);
	}

	//Este método é chamado apenas quando o Browser
	//carrega o Applet
	public void init() {
		//Definir cores por defeito para cada classe
		Ponto.setDefaultColor(Color.red);
		Circulo.setDefaultColor(Color.green);
		Quadrado.setDefaultColor(Color.blue);

		//Definir cores para os quadrados coloridos
		q3.setColor(Color.gray);
		q4.setColor(Color.yellow);
		q5.setColor(Color.darkGray);
		q6.setColor(Color.yellow);
	}

	//Este método é chamado quando o utilizador pressiona
	//um dos botões do rato
	public boolean mouseDown(Event evt, int x, int y) {
		//Vamos alterar as cores por defeito
		Circulo.setDefaultColor(Color.orange);
		Quadrado.setDefaultColor(Color.orange);
		Ponto.setDefaultColor(Color.orange);
		
		//Não esquecer de redesenhar a área do
		//applet.
		repaint();

		//Como processamos o evento devolvemos true.
		return true;
	}
}