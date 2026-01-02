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

	public String toString(){
		return "Placa:" + placa;
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

	public String toString(){
		return super.toString() + ", Portas:" + numeroDePortas;
		}

	}



class ExemploSobreposicao{

	Veiculo v;
	Carro c;

	ExemploSobreposicao(){
	
		v = new Veiculo();
		c = new Carro();
	
		v.setPlaca("VVV1111");
		
		c.setPlaca("CCC9999");
		c.setNumeroDePortas(3);
		
		System.out.println("Veiculo v >>>" + v + "<<<" );

		System.out.println("Carro c >>>" + c  + "<<<" );

		}
	}
	

public class Exemplo07{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploSobreposicao();
		System.out.println("Fim");
		}
	}       
		

// Remova o metodo toString de Carro, o que acontece ?

