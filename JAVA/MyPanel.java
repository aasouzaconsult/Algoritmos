import java.awt.*;

//
//
// MyPanel.java
//
// Sub classe de java.awt.Panel
//
// Implementamos um painel "inteligente"
// que desenha figuras (ponto, quadrado ou
// círculo) no local onde se clica com o
// rato.
//
// O tipo de figura assim como as suas
// dimensões e cor são definidos através
// de campos públicos.
//
// O painel apresenta as últimas 10
// figuras. Quando é necessário apagar
// uma figura essa pode, opcionalmente,
// ser "passada" para outro objecto da
// classe MyPanel.
//
public class MyPanel extends Panel
{
	//Campos
	public Color color = null;
	public int modo = 1;
	public int arg = 10;
	public MyPanel outropainel=null;
	
	//Array onde são guardas as últimas 10 figuras
	private Ponto figuras[] = new Ponto[10];
	//Posição actual no array
	private int pos = 0;

	// lastx, lasty são utilizados para evitar
	// cliques seguidos na mesma posição
	private int lastx=-1;
	private int lasty=-1;


	//Processamento de cliques no rato
	public boolean mouseDown(Event evt, int x, int y) 
	{
		// verificar se clique no mesmo local
		if ((lastx==x) && (lasty==y)) {
			System.out.println("Ponto Duplicado!");
			return true;
		}
		
		//memorizar a última posição
		lastx=x;
		lasty=y;

		// mensagem de debug
		// (Aparece na Java Console se o browser
		// a suportar)
		System.out.println("MouseDown:"+x+","+y+" modo:"+modo+" pos:"+pos);

		// Se é necessário apagar uma figura do array
		// e existe um painel "secundário" então passamos
		// a figura para o outro painel
		if (figuras[pos]!=null && outropainel!=null) {
			System.out.println("OutroPainel...");
			//Determinar o tipo de figura e 
			// parâmetros da mesma
			outropainel.modo=1;
			if (figuras[pos] instanceof Ponto)
				outropainel.modo = 1;
			if (figuras[pos] instanceof Quadrado)
			{
				outropainel.modo = 2;
				outropainel.arg=((Quadrado)figuras[pos]).getLado();
			}	
			if (figuras[pos] instanceof Circulo)
			{
				outropainel.modo = 3;
				outropainel.arg=((Circulo)figuras[pos]).getRaio();
			}	

			outropainel.color = figuras[pos].getColor();

			//Simular agora um clique com o rato no
			//outro painel
			outropainel.mouseDown(null,figuras[pos].getX(),figuras[pos].getY());
		}
		
		//Criar o objecto para a nova figura
		switch (modo) {
		case 1:
			figuras[pos] = new Ponto(x,y);
			break;
		case 2:
			figuras[pos] = new Quadrado(x,y,arg);
			break;
		case 3:
			figuras[pos] = new Circulo(x,y,arg);
			break;
		}

		//Se o modo é válido podemos desenhar
		//a nova figura
		if (modo!=0) {
			figuras[pos].setColor(color);	
			repaint();
		}

		//actualizar posição no array
		pos++;
		if (pos>=figuras.length)
			pos=0;

		return true;
	}

	//Processamento de paint do painel
	public void paint(Graphics g) 
	{
		//Nota: como as figuras tem diferentes
		//cores tem de ser desenhadas por ordem
		//daí termos dois ciclos for
		for(int i=pos+1; i<figuras.length; i++)
			if (figuras[i]!=null)
				figuras[i].paint(g);
		for(int i=0; i<pos; i++)
			if (figuras[i]!=null)
				figuras[i].paint(g);
	}
}