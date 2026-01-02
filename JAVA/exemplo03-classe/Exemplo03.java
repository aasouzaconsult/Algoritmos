/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/

class Carro {

	private String placa = "";
	private int numeroDePortas = 2;

	void setPlaca( String p){
		placa = p;
		}

	String getPlaca(){
		return placa;
		}

	void setNumeroDePortas( int n){
		numeroDePortas = n;
		}

	int getNumeroDePortas(){
		return numeroDePortas;
		}
	}


class ExemploClasse{

	Carro c1, c2, c3, cx;

	ExemploClasse(){
	
		c1 = new Carro();
		c2 = new Carro();
		c3 = new Carro();
		cx = c3;
	
		c1.setNumeroDePortas(1);
		c2.setNumeroDePortas(2);
		c3.setNumeroDePortas(3);
		
		System.out.println("Numero de portas c1:" + c1.getNumeroDePortas() );
		System.out.println("Numero de portas c2:" + c2.getNumeroDePortas() );
		System.out.println("Numero de portas c3:" + c3.getNumeroDePortas() );
		System.out.println("Numero de portas cx:" + cx.getNumeroDePortas() );

		System.out.println("Placa c1: " + c1.getPlaca() );
		System.out.println("Placa c2: " + c2.getPlaca() );
		System.out.println("Placa c3: " + c3.getPlaca() );
		}
	}
	

public class Exemplo03{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploClasse();
		System.out.println("Fim");
		}
	}       
		

// Mude as placas de todos os carros

// Crie um construtor para a classe Carro que define a placa

// Tente acessar o atributo placa diretamente



