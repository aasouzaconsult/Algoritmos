/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/

import java.awt.*;


class JanelaPrincipal extends Frame {

	// Inicializa o frame
	public JanelaPrincipal() {

		System.out.println("inicio da janela");

		this.setTitle("Minha Primeira Janela em Java");

		System.out.println("fim da janela");

		// Mostra
		this.pack();		// "this" eh opcional
		this.show();		// "this" eh opcional

		}
	}


public class Exemplo11{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new JanelaPrincipal();
		System.out.println("Fim");
		}
	}       
		

// Crie um construtor para a classe JanelaPrincipal que define o titulo

// Tente mudar o tamanho da janela com o mouse

