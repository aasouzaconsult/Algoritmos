/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/


import java.awt.*;
import java.awt.event.*;


/** Classe que apresenta texto na tela */

class MeuLabel extends Label {
	Dimension minSize;

	public MeuLabel( String text, int alignment, int w, int h) {
		super( text, alignment);
		minSize = new Dimension( w, h);
		}

	public Dimension getMinimumSize() {
		return minSize;
		}

	public Dimension getPreferredSize() {
		return minSize;
		}
	}



/** Classe com uma área para desenho */

class BlankArea extends Canvas {
	Dimension minSize = new Dimension( 50, 50);
	String texto;
	Color cor = Color.black;

	public BlankArea( String x) {
		super();
		texto = x;
		}

	public void setColor( Color c) {
		cor = c;
		}

	public Dimension getMinimumSize() {
		return minSize;
		}

	public Dimension getPreferredSize() {
        	return minSize;
		}

	public void paint( Graphics g) {
		Dimension size = this.getSize();
		g.setColor( cor);
		g.drawRect( 0, 0, size.width-1, size.height-1);
		g.drawString( texto, 20, 20);
		}
	}





/** Classe que ilustra o uso de eventos na GUI */

class ExemploEventosAWT extends Frame 
			implements ActionListener {

	//Atributos de Eventos
	TextField campoTexto;
	TextArea areaTexto;
	TextArea areaSaida;
	Button botao1, botao2;
	Checkbox cb1, cb2;
	CheckboxGroup cbg;
	BlankArea vazio;
	Label mensagem;
	Choice escolha;
	List lista;
	Scrollbar barra;

	// Classe interna para receber eventos associados com a janela
	class JanelaListener extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.out.println("janela foi fechada");
			System.exit(0);            
			}    	
		}


	//Classe interna para lidar com mudanca de estado em item
	class MeuItemListener implements ItemListener {

		public void itemStateChanged( ItemEvent e) {
			String x;
			Object ob = e.getItemSelectable();

			if( ob == cb1 )
				x = " e=CB1 ";
			else if( ob == cb2 )
				x = " e=CB2 ";
			else
				x = " e=??? ";

			if( cbg.getSelectedCheckbox() == cb1 )
				x += "- CB1 ligado\n";
			else
				x += "- CB2 ligado\n";

			areaSaida.append("ITEM " + x);
			}
		}


	//Classe interna para lidar com mudanca de estado em menu
	class AtendeEscolha implements ItemListener {

		public void itemStateChanged( ItemEvent e) {
			String item;
			int index;
			Object ob = e.getItemSelectable();

			if( ob instanceof Choice /*escolha*/ )
			 {	item = ((Choice)ob).getSelectedItem();
				index = ((Choice)ob).getSelectedIndex();
				}
			else
			 {	item = ((List)ob).getSelectedItem();
				index = ((List)ob).getSelectedIndex();
				}

			switch( index )
			 {
			case 0: vazio.setColor( Color.black );
					break;
			case 1: vazio.setColor( Color.blue );
					break;
			case 2: vazio.setColor( Color.red );
					break;
			default:vazio.setColor( Color.yellow );
					break;
	                }

			areaSaida.append("ESCOLHA/LISTA " + item + "\n" );

			vazio.repaint();
			}
		}


	//Classe interna para lidar com return do campo texto
	class MeuTextActionListener implements ActionListener {
		public void actionPerformed( ActionEvent e) {
			int inicio = areaTexto.getSelectionStart();
			int fim    = areaTexto.getSelectionEnd();

			areaTexto.replaceRange( campoTexto.getText(), inicio, fim);
			campoTexto.selectAll();
			}
		}


	//Classe interna para lidar com barra de rolagem
	class MeuAdjustmentListener implements AdjustmentListener {
		public void adjustmentValueChanged( AdjustmentEvent e) {
			int x = e.getValue();

			switch( e.getAdjustmentType() )
			  {	case AdjustmentEvent.UNIT_INCREMENT:
					areaSaida.append(x + "BARRA +1\n" );
					break;
				case AdjustmentEvent.UNIT_DECREMENT:
			        areaSaida.append(x + "BARRA -1\n" );
					break;
				case AdjustmentEvent.BLOCK_INCREMENT:
					areaSaida.append(x + "BARRA +bloco\n" );
					break;
				case AdjustmentEvent.BLOCK_DECREMENT:
					areaSaida.append(x + "BARRA -bloco\n" );
					break;
				case AdjustmentEvent.TRACK:
        			areaSaida.append(x + "BARRA track\n" );
					break;
				}
			}
		}


	//Classe interna para lidar com mudanca no texto em campo ou area
	class MeuTextListener implements TextListener {

		String prefacio;

		public MeuTextListener( String fonte) {
			prefacio = fonte + " foi alterada.\n";
			}

		public void textValueChanged( TextEvent e) {
			TextComponent tc = (TextComponent) e.getSource();
			String s = tc.getText();
			s = s.substring( 0, s.length()>=10?10:s.length());
			areaSaida.append( prefacio + s + "\n");

			//Scroll down, testa antes se jah existe o cara
			if( areaSaida.isValid() )
				areaSaida.setCaretPosition(java.lang.Integer.MAX_VALUE);
			}
		}

    
	//Classe interna para lidar com teclas acionadas
	class MeuKeyListener implements KeyListener {

		public void keyTyped( KeyEvent e) {
			displayInfo( "TYPED ", e);
			}

		public void keyPressed( KeyEvent e) {
			displayInfo( "PRESSED ", e);
			}

		public void keyReleased( KeyEvent e) {
			displayInfo( "RELEASED ", e);
			}

		public void displayInfo( String s, KeyEvent e) {
			char c = e.getKeyChar();
			if( Character.isISOControl(c) )
				areaSaida.append(s + " ? Code ");
			else areaSaida.append(s + " " + c + " code ");
			
			areaSaida.append( e.getKeyCode() + "\n");
			}            
		}


	//Classe interna para lidar com o acionamento do mouse
	class MeuMouseListener implements MouseListener {

		public void mousePressed( MouseEvent e) {
			areaSaida.append( "mouse PRESS\n");
			}

		public void mouseReleased( MouseEvent e) {
			areaSaida.append( "mouse RELEASE\n");
			}

		public void mouseEntered( MouseEvent e) {
			areaSaida.append( "mouse ENTER\n");
			}

		public void mouseExited( MouseEvent e) {
			areaSaida.append( "mouse EXIT\n");
			}

		public void mouseClicked( MouseEvent e) {
			areaSaida.append( "mouse CLICK\n");
			}
		}




	// Inicializa o frame
	public ExemploEventosAWT() {

		System.out.println("inicio do construtor");

		//Define o font a ser usado
		this.setFont( new Font("TimesRoman", Font.PLAIN, 12) );

		// Define o layout manager
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout( gridBag);
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets( 2, 2, 2, 2);
		c.weightx = 1;
		c.weighty = 1;
		c.gridheight = 1;
		c.gridwidth = 1;

		//Cria um campo label
		mensagem = new MeuLabel("Cheio de Eventos", Label.CENTER, 100, 50);
		mensagem.setFont( new Font("TimesRoman", Font.BOLD, 14) );
		c.insets = new Insets( 0, 0, 0, 0);
		gridBag.setConstraints( mensagem, c);
		this.add( mensagem);
		c.insets = new Insets( 2, 2, 2, 2);

		//Cria um campo tipo escolha
		escolha = new Choice();
		escolha.addItem("Preto");
		escolha.addItem("azul");
		escolha.addItem("vermelho");
		AtendeEscolha esc = new AtendeEscolha();
		escolha.addItemListener( esc );
		c.gridwidth = 1;
		gridBag.setConstraints( escolha, c);
		this.add( escolha);
		c.gridwidth = 1;

		//Cria um campo tipo lista
		lista = new List( 3, false);
		lista.add("Preto");
		lista.add("azul");
		lista.add("vermelho");
		lista.add("amarelo");
		lista.add("amarelo");
		lista.add("amarelo");
		lista.addItemListener( esc );
		c.gridwidth = GridBagConstraints.REMAINDER;
		gridBag.setConstraints( lista, c);
		this.add( lista);
		c.gridwidth = 1;

		//Cria um campo texto
		campoTexto = new TextField(20);
		campoTexto.addActionListener( new MeuTextActionListener());
		campoTexto.addTextListener( new MeuTextListener("Campo de Texto") );
		campoTexto.addKeyListener( new MeuKeyListener());
		gridBag.setConstraints( campoTexto, c);
		this.add( campoTexto);

		//Cria uma area de texto
		areaTexto = new TextArea( 3, 20);
		areaTexto.addTextListener( new MeuTextListener("Area de texto") );
		c.gridwidth = GridBagConstraints.REMAINDER;
		gridBag.setConstraints( areaTexto, c);
		this.add( areaTexto);
		c.gridwidth = 1;

		// Cria um botao
		botao1 = new Button("Limpa");
		botao1.addActionListener( this);

		// Cria outro botao
		botao2 = new Button("Limpa tambem");
		botao2.addActionListener( this);

		// Cria as duas checkbox e o grupo
		cbg = new CheckboxGroup();
		MeuItemListener cbl = new MeuItemListener();
		cb1 = new Checkbox("Checkbox 1", cbg, false);
		cb2 = new Checkbox("Checkbox 2", cbg, true);
		cb1.addItemListener( cbl );
		cb2.addItemListener( cbl );

		// Coloca os dois botoes em um panel
		Panel botoes = new Panel();
		botoes.setLayout( new GridLayout(0,1,0,10) );
		botoes.add( botao1);
		botoes.add( botao2);

		// Coloca os checkbox no panel tambem
		botoes.add( cb1);
		botoes.add( cb2);
 
 		// Coloca o panel no gridbag
		gridBag.setConstraints( botoes, c);
		this.add( botoes);

		//Cria a area vazia
		vazio = new BlankArea( "Area Vazia");
		vazio.addMouseListener( new MeuMouseListener() );
		c.gridwidth = GridBagConstraints.REMAINDER;
		gridBag.setConstraints( vazio, c);
		c.gridwidth = 1;
		this.add( vazio);

		//Cria a area de saida
		areaSaida = new TextArea( 6, 40);
		areaSaida.setEditable( false);
		c.weightx = 2.0;
		c.weighty = 2.0;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		gridBag.setConstraints( areaSaida, c);
		this.add( areaSaida);
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 1;
		c.gridheight = 1;

		//Cria uma barra de rolagem
		barra = new Scrollbar( Scrollbar.HORIZONTAL, 50, 0, 0, 100);
		c.gridwidth = GridBagConstraints.REMAINDER;
		gridBag.setConstraints( barra, c);
		MeuAdjustmentListener adl = new MeuAdjustmentListener();
		barra.addAdjustmentListener( adl );
		this.add( barra);
		c.gridwidth = 1;

		// Para pegar o fechamento da janela
		JanelaListener jl = new JanelaListener();
		this.addWindowListener(jl);

		System.out.println("terminou criacao dos componentes");


		// Foco inicial e tamanho
		pack();
		show();

		System.out.println("mostrou janela");

		campoTexto.requestFocus(); 
		}


	//Lida com o click do botao
	public void actionPerformed( ActionEvent e) {
		areaSaida.setText("---");
		campoTexto.requestFocus();
		}

	}






public class Exemplo16{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploEventosAWT();
		System.out.println("Fim");
		}
	}       
		

// Altere o tratamento de algum evento

// Insira um novo elemento visual na tela


