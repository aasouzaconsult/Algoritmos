//Applet que implementa uma lista ligada
//simples de pontos
//
import java.applet.Applet;
import java.awt.*;

//O Applet...
public class DotListApplet extends Applet
{

	//Primeiro elemento da lista
	DotList dots=new DotList();

	//o método paint é chamado sempre que
	//é necessário redesenhar a área do Applet
	//ou após uma chamada a repaint()
	public void paint(Graphics g) {
		dots.paint(g);
	}

	//o método mouseDown é chamado quando
	//se pressiona um dos botões do rato
	public boolean mouseDown(Event e, int x, int y) {
		dots.addNew(x,y);
		repaint();
		return true;
	}
}


//A classe com a lista de pontos
//Nota: como a classe não é public pode ser
//incluída neste ficheiro .java
class DotList {
	DotItem first = null;

	public void paint(Graphics g) {
		if (first!=null)
			first.paintAll(g);
	}

	public void addNew(int x, int y) {
		if (first==null)
			first = new DotItem(x,y);
		else 
			first.addNew(new DotItem(x,y));
	}

}
//A classe para a os pontos da lista
//Nota: como a classe não é public pode ser
//incluída neste ficheiro .java
class DotItem {

	//coordenadas x,y
	int x;
	int y;
	//elemento seguinte
	DotItem next=null;

	//construtor
	public DotItem(int x, int y) {
		this.x = x;
		this.y = y;
	}

	//devolver último elemento da lista
	public DotItem findLast() {
		DotItem d=this;
		while (d.next!=null)
			d=d.next;
		return d;
	}

	//adicionar novo elemento ao fim da lista
	public void addNew(DotItem d2) {
		DotItem d=this;
		while (d.next!=null)
			d=d.next;
		d.next = d2;
	}

	//inserir novo elemento à lista depois 
	//do elemento actual
	public void insertNew(DotItem d) {
		if (next!=null) {
			d.next = next;
			next = d;
		} else {
			next = d;
		}
	}

	public void paint(Graphics g) {
		g.fillOval(x-3,y-3,6,6);
		if (next!=null)
			g.drawLine(x,y,next.x,next.y);
	}

	public void paintAll(Graphics g) {
		DotItem d=this;
		while (d!=null) {
			d.paint(g);
			d=d.next;
		}
	}
}