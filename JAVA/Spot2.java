//Evolução do Applet Spot.
//Pequeno Applet que desenha um círculo por onde 
//passa o rato no Applet e muda de cor quando se clica com o rato.
//Ver exemplo anterior (Spot.java)


import java.applet.Applet;
import java.awt.*;

public class Spot2 extends Applet {
	// Campos
	
	private java.awt.Point clickPoint=null;
	private static final int RADIUS = 7;

	//variável que indica a cor actual
	private boolean corPreta = true;

	//quando se clica com o rato...
	public boolean mouseDown(java.awt.Event evt, int x, int y) {

		if (clickPoint == null)
			clickPoint = new java.awt.Point(x,y);
		else {
			clickPoint.x = x;
			clickPoint.y = y;
		}

		// trocar cor de desenho
		corPreta = !corPreta;

		// redesenhar Applet
		repaint();

		return true;
	}

	//quando se move o rato...
	public boolean mouseMove(java.awt.Event evt, int x, int y) {

		// guardar o ponto
		if (clickPoint == null)
			clickPoint = new java.awt.Point(x,y);
		else {
			clickPoint.x = x;
			clickPoint.y = y;
		}

		// redesenhar Applet
		repaint();

		return true;
	}

	//quando o rato sai da área do Applet...
	public boolean mouseExit(java.awt.Event evt, int x, int y) {

		// eliminar o ponto
		clickPoint = null;
		
		// redesenhar Applet
		repaint();

		return true;
	}

	//redesenhar a área do Applet
	public void paint(Graphics g) {
		
		//desenhar rectângulo...
		g.drawRect(0, 0, size().width-1, size().height-1);
		
		//definir cor...
		if (corPreta)
			g.setColor(Color.black);
		else
			g.setColor(Color.red);

		//desenhar o círculo...
		if (clickPoint != null)
			g.fillOval(clickPoint.x - RADIUS, clickPoint.y - RADIUS, RADIUS * 2, RADIUS * 2);
	}
}



