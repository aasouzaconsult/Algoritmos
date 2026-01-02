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

	void setPlaca( String pl, String pn){
		placa = pl + pn;
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


class ExemploSobrecarga{

	Carro c1, c2;

	ExemploSobrecarga(){
	
		c1 = new Carro();
		c2 = new Carro();
		
		c1.setPlaca("ABC1234");
		System.out.println("Placa c1: " + c1.getPlaca() );

		c2.setPlaca("XYZ", "9876");
		System.out.println("Placa c2: " + c2.getPlaca() );
		}
	}
	

public class Exemplo04{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploSobrecarga();
		System.out.println("Fim");
		}
	}       
		

// Crie um terceiro metodo setPlaca para a classe Carro

