/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/

class Veiculo {

	private String placa;
	
	Veiculo( String p){
			placa = p;
		}
		
	Veiculo(){
		placa = "default";
		}		

	void setPlaca( String p){
		placa = p;
		}

	String getPlaca(){
		return placa;
		}
	}


class Carro extends Veiculo {
	private int numeroDePortas = 0;
	
	Carro( int n, String p){
		super(p);
		numeroDePortas = n;
		}

	Carro( int n){
		super();
		numeroDePortas = n;
		}
	
	Carro( String p){
		super(p);
		}
		
	Carro(){
		super();
		}
	
	void setNumeroDePortas( int n){
		numeroDePortas = n;
		}

	int getNumeroDePortas(){
		return numeroDePortas;
		}
	}


class ExemploConstrutor{

	Carro c1, c2, c3, c4;

	ExemploConstrutor(){
	
		c1 = new Carro();
		System.out.println("Carro 1 com " + c1.getNumeroDePortas() +
							" portas e placa: " + c1.getPlaca() );

		c2 = new Carro(5);
		System.out.println("Carro 2 com " + c2.getNumeroDePortas() +
							" portas e placa: " + c2.getPlaca() );

		c3 = new Carro("ABC1234");
		System.out.println("Carro 3 com " + c3.getNumeroDePortas() +
							" portas e placa: " + c3.getPlaca() );

		c4 = new Carro( 4, "ABC1234");
		System.out.println("Carro 4 com " + c4.getNumeroDePortas() +
							" portas e placa: " + c4.getPlaca() );
		}
	}
	

public class Exemplo06{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploConstrutor();
		System.out.println("Fim");
		}
	}       
		

// Crie um novo atributo e dois novos construtores para Carro

// Tente usar o construtor default quando ele não está definido
