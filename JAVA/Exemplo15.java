/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/

import java.awt.*;
import java.awt.event.*;



/** Classe com uma área para desenho */

class AreaDesenho extends Canvas {
	private String texto;
	private Color cor = Color.black;

	public AreaDesenho( String x) {
		super();
		texto = x;
		}

	public void setColor( Color c) {
		cor = c;
		}

	public void paint( Graphics g) {
		Dimension size = this.getSize();
		g.setColor( cor);
		g.drawRect( 0, 0, size.width-2, size.height-2);
		g.drawString( texto, 20, 20);
		}

	}







/** Classe com a interface gráfica de usuário */


class JanelaPrincipal extends Frame {

	private	Label fixoTexto;	 
	private Button botao1;
	private Button botao2;
    private TextArea areaTexto;
    private TextField campoTexto;
    private Choice escolha;
    private List lista;
    private Checkbox caixa;
    private Scrollbar barra;
    private AreaDesenho desenho;


	// Classe interna para receber eventos associados com a janela
	class EscutaJanela extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.out.println("janela foi fechada");
			System.exit(0);            
			}    	
		}


	// Classe interna para receber eventos do botão 1
	class EscutaBotao1 implements ActionListener{
		public void actionPerformed( ActionEvent e) {
			areaTexto.append("Botao <1> acionado\n");
			}
		}	


	// Classe interna para receber eventos do botão 2
	class EscutaBotao2 implements ActionListener{
		public void actionPerformed( ActionEvent e) {
			areaTexto.append("Botao <2> acionado\n");
			areaTexto.append(">>" + campoTexto.getText() + "<<\n");
			}
		}	


	//Classe interna para lidar com return do campo texto
	class EscutaCampoTexto implements ActionListener {
		public void actionPerformed( ActionEvent e) {
			areaTexto.append("TEXTO " + campoTexto.getText() + "\n"); 
			}
		}


	//Classe interna para lidar com uma escolha
	class EscutaEscolha implements ItemListener {

		public void itemStateChanged( ItemEvent e) {
			String item;
			int index;
		 
			item = escolha.getSelectedItem();
			index = escolha.getSelectedIndex();

			areaTexto.append("ESCOLHA " + item + " indice " + index + "\n" );
			}
		}


	//Classe interna para lidar com uma lista
	class EscutaLista implements ItemListener {

		public void itemStateChanged( ItemEvent e) {
			String item;
			int index;
		 
			item = lista.getSelectedItem();
			index = lista.getSelectedIndex();

			areaTexto.append("LISTA " + item + " indice " + index + "\n" );
			}
		}


	//Classe interna para lidar com uma checkbox
	class EscutaCaixa implements ItemListener {

		public void itemStateChanged( ItemEvent e) {
			if( caixa.getState() )
				areaTexto.append("CAIXA LIGOU\n");
			else
				areaTexto.append("CAIXA DESLIGOU\n");
			}
		}


	//Classe interna para lidar com barra de rolagem
	class EscutaBarra implements AdjustmentListener {
		public void adjustmentValueChanged( AdjustmentEvent e) {
			int x = e.getValue();

			switch( e.getAdjustmentType() )
			  {	case AdjustmentEvent.UNIT_INCREMENT:
					areaTexto.append(x + "BARRA +1\n" );
					break;
				case AdjustmentEvent.UNIT_DECREMENT:
			        areaTexto.append(x + "BARRA -1\n" );
					break;
				case AdjustmentEvent.BLOCK_INCREMENT:
					areaTexto.append(x + "BARRA +bloco\n" );
					break;
				case AdjustmentEvent.BLOCK_DECREMENT:
					areaTexto.append(x + "BARRA -bloco\n" );
					break;
				case AdjustmentEvent.TRACK:
        			areaTexto.append(x + "BARRA track\n" );
					break;
				}
			}
		}






	// Inicializa o frame
	public JanelaPrincipal() {

		System.out.println("inicio da janela");

		this.setTitle("Minha Segunda Janela em Java");

		// Define o layout manager
		GridLayout gl = new GridLayout(2,5);
		this.setLayout( gl );

		// Cria uma area para colocar texto
		areaTexto = new TextArea("area para colocar texto\nvarias linhas\n");
		areaTexto.setEditable(false);
		areaTexto.append("\nMais uma linha extra\n");
		this.add( areaTexto );

		// Cria um texto fixo
		fixoTexto = new Label("texto fixo");
		this.add( fixoTexto);
		
		// Cria o botao 1
		botao1 = new Button("Botao <1>");
		this.add( botao1 );
		EscutaBotao1 eb1 = new EscutaBotao1();
		botao1.addActionListener(eb1);
	
		// Cria o botao 2
		botao2 = new Button("Botao <2>");
		this.add( botao2 );
		EscutaBotao2 eb2 = new EscutaBotao2();
		botao2.addActionListener(eb2);
		
		// Cria um campo para texto		
		campoTexto = new TextField("valor inicial");
		this.add( campoTexto );

		EscutaCampoTexto ect = new EscutaCampoTexto();
		campoTexto.addActionListener(ect);

		// Cria uma escolha
		escolha = new Choice();
		escolha.addItem("fiat");
		escolha.addItem("volks");
		escolha.addItem("gm");
		escolha.addItem("ford");
		escolha.addItem("renault");
		escolha.addItem("crysler");
		this.add( escolha);

		EscutaEscolha ee = new EscutaEscolha();
		escolha.addItemListener( ee );

		// Cria uma lista
		lista = new List( 3, false);
		lista.add("preto");
		lista.add("azul");
		lista.add("vermelho");
		lista.add("amarelo");
		lista.add("verde");
		lista.add("roxo");
		this.add( lista);

		EscutaLista el = new EscutaLista();
		lista.addItemListener( el );

		// Cria uma caixa de seleção
		caixa = new Checkbox("caixa para marcar", false);
		this.add( caixa);
		
		EscutaCaixa ec = new EscutaCaixa();
		caixa.addItemListener( ec );

		// Cria uma barra de rolagem
		barra = new Scrollbar( Scrollbar.HORIZONTAL, 50, 0, 0, 100);
		this.add( barra);

		EscutaBarra eb = new EscutaBarra();
		barra.addAdjustmentListener( eb );

		// Cria uma area para desenho
		desenho = new AreaDesenho("desenho");
		desenho.setColor(Color.blue);
		this.add(desenho);
		
		desenho.setColor(Color.red);
		desenho.repaint();		


		// Para pegar o fechamento da janela
		EscutaJanela ej = new EscutaJanela();
		this.addWindowListener(ej);


		// Acabou
		System.out.println("terminou criacao dos componentes");

		// Mostra
		this.pack();
		this.show();

		}
	}


public class Exemplo15{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new JanelaPrincipal();
		System.out.println("Fim");
		}
	}       
		

// Mude o texto escrito sobre o botão 1

// Mude o comportamento de cada componente visual que gera eventos

// Mude o desenho conforme algum evento

