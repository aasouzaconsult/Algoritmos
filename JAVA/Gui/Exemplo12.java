/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/

import java.awt.*;

class JanelaPrincipal extends Frame {

	private	Label fixoTexto;	 
	private Button botao;
    private TextArea areaTexto;
    private TextField campoTexto;
    private Choice escolha;
    private List lista;
    private Checkbox caixa;
    private Scrollbar barra;


	// Inicializa o frame
	public JanelaPrincipal() {

		System.out.println("inicio da janela");

		this.setTitle("Minha Segunda Janela em Java");

		// Define o layout manager
		GridLayout gl = new GridLayout(4,2);
		this.setLayout( gl );

		//Cria os diversos elementos visuais e coloca no frame
		
		fixoTexto = new Label("texto fixo");
		this.add( fixoTexto);
		
		botao = new Button("meu botao");
		this.add( botao );
		
		areaTexto = new TextArea("area para colocar texto\nvarias linhas\n");
		areaTexto.setEditable(false);
		areaTexto.append("\nMais uma linha extra\n");
		this.add( areaTexto );
	
		campoTexto = new TextField("valor inicial");
		this.add( campoTexto );

		escolha = new Choice();
		escolha.addItem("fiat");
		escolha.addItem("volks");
		escolha.addItem("gm");
		escolha.addItem("ford");
		escolha.addItem("renault");
		escolha.addItem("crysler");
		this.add( escolha);
		
		lista = new List( 3, false);
		lista.add("preto");
		lista.add("azul");
		lista.add("vermelho");
		lista.add("amarelo");
		lista.add("verde");
		lista.add("roxo");
		this.add( lista);

		caixa = new Checkbox("caixa para marcar", false);
		this.add( caixa);
		
		barra = new Scrollbar( Scrollbar.HORIZONTAL, 50, 0, 0, 100);
		this.add( barra);

		System.out.println("terminou criacao dos componentes");

		// Mostra
		this.pack();
		this.show();

		}
	}


public class Exemplo12{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new JanelaPrincipal();
		System.out.println("Fim");
		}
	}       
		

// Mude o texto escrito sobre o botão

// Mude a ordem de colocação dos elementos visuais

// Mude o número de linhas e colunas na grade


