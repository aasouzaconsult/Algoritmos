//Applet que implementa uma lista ligada
//um bocadão mais complexa de pontos
//com o extra de double buffering
//
//Quando se arrasta um ponto não há 
//cintilação da imagem
import java.applet.Applet;
import java.awt.*;


//O Applet...
public class DotListApplet4 extends Applet
{
	//Imagem a utilizar no double buffering
	Image m_Image;

	//Graphics a utilizar
	Graphics m_Graphics;

	//Primeiro elemento da lista
	DotList dots=new DotList();

	//Ponto actual para utilizar com
	//mouseDrag e mouseUp
	DotItem curDot=null;

	//Flag que indica se o ponto foi movido
	boolean dotMoved=false;

	//Flag que indica se o ponto foi movido
	boolean dotNew=false;

	public void init() {
		m_Image = createImage(size().width,size().height);
		m_Graphics = m_Image.getGraphics();
	}

	//é necessário substituir o update(...)
	//para evitar que a área de desenho seja
	//limpa antes de um paint(...)
	public void update(Graphics g) {
		paint(g);
	}



	//o método paint é chamado sempre que
	//é necessário redesenhar a área do Applet
	//ou após uma chamada a repaint()
	public void paint(Graphics g) {
		m_Graphics.clearRect(0,0,size().width,size().height);
		dots.paint(m_Graphics);
		g.drawImage(m_Image,0,0,this);
	}

	//o método mouseDown é chamado quando
	//se pressiona um dos botões do rato
	public boolean mouseDown(Event e, int x, int y) {
		//limpar a flag de movimento
		dotMoved = false;
	
		//procurar um ponto próximo
		curDot  = dots.getDotItem(x,y,5);
	
		//criar novo ponto se necessário
		if (curDot ==null) {
			curDot = new DotItem(x,y);
			dots.addNew(curDot);
			dotNew = true;
		} else dotNew = false;

		//colocar o ponto a vermelho
		curDot.setColor(Color.red);

		//actualizar cena
		repaint();
		return true;
	}

	//o método mouseDrag é chamado quando
	//se move o rato com um dos botões premido
	public boolean mouseDrag(Event e, int x, int y) {
		//cerificar se existe ponto actual
		if (curDot!=null) {
			//se ponto ainda não foi movido
			//verificar distência
			if (!dotMoved) {
				if (curDot.distanceTo(x,y)>5)
					dotMoved=true;
			}

			//se ponto está a ser movido
			//alterar coordenadas
			if (dotMoved) {
				curDot.x=x;
				curDot.y=y;
				//actualizar área
				repaint();
			}
		}
		return true;
	}

	//o método mouseUp é chamado quando
	//se liberta um dos botões do rato
	public boolean mouseUp(Event e, int x, int y) {
		//verificar se existe ponto actual
		if (curDot!=null) {
			//recuperar cor original
			curDot.setColor(Color.black);

			//se ponto não foi movido e não
			//é um ponto novo então removê-lo
			if (!dotMoved && !dotNew) dots.remove(curDot);
		}
		//limpar flags e variáveis
		curDot = null;
		dotNew = false;
		dotMoved = false;

		//actualizar área do applet
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
		addNew(new DotItem(x,y));
	}

	public void addNew(DotItem d) {
		if (first==null)
			first = d;
		else 
			first.addNew(d);
	}

	public DotItem getDotItem(int x, int y, int radius) {
		DotItem d = first;
		while (d!=null && d.distanceTo(x,y)>radius)
			d = d.next;
		return d;
	}

	//remover um elemento da lista
	public void remove(DotItem d) {
		DotItem d2=first;
		
		if (d==null || d2==null) return;

		if (d==d2) {
			first = first.next;
			return;
		}

		while (d2.next!=null && d2.next!=d)
			d2=d2.next;

		if (d2.next!=null) {
			if (d.next!=null)
				d2.next = d.next;
			else
				d2.next = null;
		}
	}

}

//A classe para a os pontos da lista
//Nota: como a classe não é public pode ser
//incluída neste ficheiro .java
class DotItem {

	//coordenadas x,y
	int x;
	int y;
	
	//cor do ponto
	private Color c = Color.black;

	//cor das linhas (igual para todos os objectos)
	private static Color lineColor = Color.black;

	//elemento seguinte
	DotItem next=null;

	//construtor
	public DotItem(int x, int y) {
		this.x = x;
		this.y = y;
	}

	//alterar cor do ponto
	public void setColor(Color newc) {
		c = newc;
	}

	//calcular distância para outro ponto
	public float distanceTo(int x2, int y2) {
		return (float) Math.sqrt((x2-x)*(x2-x)+(y2-y)*(y2-y));
	}

	public float distanceTo(DotItem d) {
		return distanceTo(d.x, d.y);
	}

	//devolver último elemento da lista
	public DotItem findLast() {
		DotItem d=this;
		while (d.next!=null)
			d=d.next;
		return d;
	}

	//adicionar novo elemento ao fim da lista
	public void addNew(DotItem d) {
		DotItem d2=this;
		while (d2.next!=null)
			d2=d2.next;
		d2.next = d;
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
		g.setColor(lineColor);
		if (next!=null)
			g.drawLine(x,y,next.x,next.y);
		g.setColor(c);
		g.fillOval(x-3,y-3,6,6);
		
	}

	public void paintAll(Graphics g) {
		DotItem d=this;
		while (d!=null) {
			d.paint(g);
			d=d.next;
		}
	}
}