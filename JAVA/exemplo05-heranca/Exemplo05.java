/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/

class Veiculo {

	private String placa = "";

	void setPlaca( String p){
		placa = p;
		}

	String getPlaca(){
		return placa;
		}
	}
	

class Carro extends Veiculo {
	private int numeroDePortas = 2;
	
	void setNumeroDePortas( int n){
		numeroDePortas = n;
		}

	int getNumeroDePortas(){
		return numeroDePortas;
		}
	}


class ExemploHeranca{

	Carro c;

	ExemploHeranca(){
	
		c = new Carro();
	
		c.setNumeroDePortas(3);
		
		System.out.println("Numero de portas:" + c.getNumeroDePortas() );

		System.out.println("Placa antes>> " + c.getPlaca() );

		c.setPlaca("ABC1234");

		System.out.println("Placa depois>> " + c.getPlaca() );

		}
	}
	

public class Exemplo05{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploHeranca();
		System.out.println("Fim");
		}
	}       
		

// Crie CarroComReboque como uma subclasse de Carro e chame todos os métodos

// Tente acessar os atributos diretamente de fora da classe onde são private

// Crie um método setPlaca com dois parâmetros para CarroComReboque

