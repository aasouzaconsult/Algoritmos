/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/

abstract class Veiculo {

	private String placa = "";

	void setPlaca( String p){
		placa = p;
		}

	String getPlaca(){
		return placa;
		}

	abstract double getValorPedagio();

	}
	

class Carro extends Veiculo {
	private int numeroDePortas = 2;
	
	void setNumeroDePortas( int n){
		numeroDePortas = n;
		}

	int getNumeroDePortas(){
		return numeroDePortas;
		}
	
	double getValorPedagio(){
		return 1.0;
		}
	}


class Caminhao extends Veiculo {
	private int numeroDeEixos = 2;
	
	void setNumeroDeEixos( int n){
		numeroDeEixos = n;
		}

	int getNumeroDeEixos(){
		return numeroDeEixos;
		}
	
	double getValorPedagio(){
		return 5.0 * numeroDeEixos;
		}
	}


class ExemploAbstract{

	Carro c;
	Caminhao cm;
	

	void showPedagio( Veiculo v){
		System.out.println("Placa: " + v.getPlaca() + 
				" custa " + v.getValorPedagio() );
		}

	ExemploAbstract(){
	
		c = new Carro();
		c.setPlaca("CAR1111");

		cm = new Caminhao();
		cm.setPlaca("CAM9999");
	
		showPedagio(c);
		showPedagio(cm);
		}
	}        
		
public class Exemplo10{
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploAbstract();
		System.out.println("Fim");
		}
	}       
		
// Crie uma subclasse de Ve¡culo que também é abstrata

// Tente instanciar uma classe abstrata

