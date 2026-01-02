//Pequeno Applet de teste do método paint() das classes.

//imports...
import java.applet.Applet;
import java.awt.Graphics;

//a nossa classe principal...
public class FigApplet1 extends Applet {
	
	//Declarar e criar os objectos...
	Ponto p1=new Ponto();
	Ponto p2=new Ponto(20,20);
	Ponto p3=new Ponto(100,100);
	Circulo c1=new Circulo(p2,20);
	Circulo c2=new Circulo(50,50,15);
	Quadrado q1=new Quadrado(new Ponto(190,190),20);
	Quadrado q2=new Quadrado(80,50,20);
	
	//O método paint é chamado para desenhar a
	//àrea do applet.
	public void paint(Graphics g)
	{
		p1.paint(g);
		p2.paint(g);
		p3.paint(g);
		c1.paint(g);
		c2.paint(g);
		q1.paint(g);
		q2.paint(g);
	}

	//Se fosse necessário poderíamos ter inicializado
	//os objectos na método, como por exemplo:
	//public void init() {
	//	p1.x=20;
	//  p1.y=40;
	//}
	//Este método é chamado apenas quando o Browser
	//carrega o Applet
}