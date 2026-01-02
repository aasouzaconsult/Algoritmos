/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/

class Carro {

	private static int proximoNumero = 1000;
	
	private String placa = "";
	private int numeroDePortas = 2;
	private int numeroDeSerie;


	Carro(){
		numeroDeSerie = proximoNumero++;
		}

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

	int getNumeroDeSerie(){
		return numeroDeSerie;
		}

	static int getTamanhoPlaca(){
		return 7;
		}

	static int getProximoSerie(){
		return proximoNumero;
		}

	}


class ExemploStatic{

	Carro c1, c2, c3;

	ExemploStatic(){
	
		System.out.println("\nTamanho da placa: " + Carro.getTamanhoPlaca() );
		
		c1 = new Carro();
		c2 = new Carro();
		c3 = new Carro();
			
		System.out.println("Numero de serie c1: " + c1.getNumeroDeSerie() );
		System.out.println("Numero de serie c2: " + c2.getNumeroDeSerie() );
		System.out.println("Numero de serie c3: " + c3.getNumeroDeSerie() );

		System.out.println("\nProximo da serie: " + Carro.getProximoSerie() );
		}
	}
	

public class Exemplo18{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploStatic();
		System.out.println("Fim");
		}
	}       
		

// Tente fazer proximoNumero nao ser static

// Teste fazer getTamanhoPlaca ser um metodo normal


