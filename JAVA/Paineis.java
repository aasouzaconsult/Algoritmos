import java.awt.*;
import java.applet.Applet;

//
//
// Paineis.java
//
// Applet que utiliza a classe MyPanel
//
public class Paineis extends Applet
{

	// Componentes...
	// b1, b2 e b3 selecionam o tipo de objecto
	// t1 indica o raio ou lado para circulos e
	// quadrados respectivamente
	// c1 indica a cor para desenho
	Button b1 = new Button("P");
	Button b2 = new Button("Q");
	Button b3 = new Button("C");
	TextField t1 = new TextField(3);
	Choice c1 = new Choice();

	// Objectos da nossa classe MyPanel
	MyPanel p2 = new MyPanel();
	MyPanel p3 = new MyPanel();

	// Inicialização do Applet...
	public void init() {
		// Criar um Panel para suporte
		// dos componentes (Buttons, 
		// TextField e Choice)
		Panel p1 = new Panel();
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(t1);
		p1.add(c1);
		
		// Indicar a p2 que deve
		// "passar" os objectos gráficos
		// para p3
		p2.outropainel = p3;

		// Inicializar t1
		t1.setText("10");
		
		// Inicializar c1
		c1.addItem("Preto");
		c1.addItem("Vermelho");
		c1.addItem("Azul");
		c1.addItem("Verde");
		c1.addItem("Branco");
		c1.addItem("Amarelo");

		// Colocar p1, p2 e p3 nas posições
		// pretendidas
		setLayout(null);
		p1.reshape(0,0,size().width,60);
		p2.reshape(0,60,size().width/2,size().height-p1.size().height);
		p3.reshape(size().width/2,60,size().width/2,size().height-p1.size().height);

		// Indicar cores de fundo para
		// fácil distinção entre os paineis
		p1.setBackground(Color.red);
		p2.setBackground(Color.yellow);
		p3.setBackground(Color.blue);

		//Adicionar p1, p2 e p3 ao Applet
		add(p1);
		add(p2);
		add(p3);
	}

	// Rotina de tratamento das acções sobre
	// os objectos do Applet
	public boolean action(Event evt, Object obj)
	{
		// b1, b2, b3 selecionam o tipo de objecto
		// a desenhar.
		// Aqui limitamo-nos a passar essa
		// informação a p2 e p3.
		if (evt.target==b1) 
		{
			p2.modo=1;
			p3.modo=p2.modo;
			return true;
		}
		if (evt.target==b2) 
		{
			p2.modo=2;
			p3.modo=p2.modo;
			return true;
		}
		if (evt.target==b3) 
		{
			p2.modo=3;
			p3.modo=p2.modo;
			return true;
		}
		// t1 indica o raio/lado dos gráficos
		// Aqui limitamo-nos a passar essa
		// informação a p2 e p3.
		if (evt.target==t1) 
		{
			p2.arg=Integer.valueOf((String) obj).intValue();
			p3.arg=p2.arg;
			return true;
		}
		// c1 indica a cor dos gráficos
		// Aqui limitamo-nos a passar essa
		// informação a p2 e p3.
		if (evt.target==c1) 
		{
			switch(((Choice)(evt.target)).getSelectedIndex()) {
			case 0:
				p2.color=Color.black;
				p3.color=p2.color;
				break;
			case 1:
				p2.color=Color.red;
				p3.color=p2.color;
				break;
			case 2:
				p2.color=Color.blue;
				p3.color=p2.color;
				break;
			case 3:
				p2.color=Color.green;
				p3.color=p2.color;
				break;
			case 4:
				p2.color=Color.white;
				p3.color=p2.color;
				break;
			case 5:
				p2.color=Color.yellow;
				p3.color=p2.color;
				break;
			}
			return true;
		}
		return false;
	}

}

