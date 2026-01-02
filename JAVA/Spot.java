//Exemplo de classe com herança: um Applet.
//Pequeno Applet que desenha um círculo no local onde se clica com o rato.

//Utilizar "packages" de suporte a Applets (java.applet.Applet)
//e Elementos Gráficos (java.awt.*)
import java.applet.Applet;
import java.awt.*;

// A nossa classe é sub-classe de Applet
// O browser (Microsoft Internet Explorer
// ou Netscape Navigator) criar uma instância
// da nossa classe como se fosse da classe Applet
// e chama determinados métodos conforme as
// circunstâncias.
public class Spot extends Applet {
//Nota: como a classe Spot é pública este ficheiro
// *tem* de se chamar "Spot.java" (atenção às
// maiúsculas).

	// Campos
	
	// Um ponto (mais correctamente: as
	// cordenadas x e y de um ponto) utilizado
	// pela AWT (Advanced Windows Toolkit)
	// No nosso caso indica o último local
	// onde foi premido o rato
	private java.awt.Point clickPoint=null;

	// Uma "constante" privada em Java,
	// como é static é comum a todos os
	// objectos desta classe e é referenciada
	// utilizando Spot.RADIUS.
	//
	// O modificador "final" indica que não
	// pode ser alterada por sub-classes da
	// nossa.
	//
	// Por conveniência as constantes são 
	// representadas todas em maiúsculas.
	private static final int RADIUS = 7;

	// o método mouseDown do Applet é chamado quando se
	// prime o botão do rato sobre a área do Applet.
	//
	//No nosso caso guardamos as coordenadas x e y para
	//depois desenharmos um círculo no local do clique.
	public boolean mouseDown(java.awt.Event evt, int x, int y) {

		//Se não existe um Ponto em clickPoint criamos
		//um novo senão alteramos os campos do anterior
		if (clickPoint == null)
			clickPoint = new java.awt.Point(x,y);
		else {
			clickPoint.x = x;
			clickPoint.y = y;
		}

		//Indicar que é necessário redesenhar a área
		//do Applet (na prática significa que o método
		//paint() vai ser chamado assim que possível).
		repaint();

		//Como processamos o clique do rato devolvemos
		//true. Se utilizasse-mos false o evento também
		//seria passado ao componente onde está colocado
		//o Applet (seria como que "transparente" aos
		//cliques do rato).
		return true;
	}

	// o método paint do Applet é chamado quando é
	// necessário redesenhar a área do mesmo.
	//
	//No nosso caso desenhamos uma borda á volta do
	//Applet e um círculo na posição do último clique
	//(se existir)
	public void paint(Graphics g) {
		//Graphics é uma classe que nos permite trabalhar
		//na área visível do Applet

		//desenhar rectângulo...
		g.drawRect(0, 0, size().width-1, size().height-1);
		// size() é um método herdado da classe Applet
		// que nos dá as dimensões do mesmo.

		//desenhar o círculo...
		if (clickPoint != null)
			g.fillOval(clickPoint.x - RADIUS, clickPoint.y - RADIUS, RADIUS * 2, RADIUS * 2);
	}
}



