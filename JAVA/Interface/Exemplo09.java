/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/

interface TransporteDeCarga{
	void carrega(double p);
	void descarrega();
	double getPeso();
	}


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


class Caminhao extends Veiculo implements TransporteDeCarga {
	private int numeroDeEixos = 2;
	private double peso = 0.0;        

	void setNumeroDeEixos( int n){
		numeroDeEixos = n;
		}

	int getNumeroDeEixos(){
		return numeroDeEixos;
		}
	
	public void carrega(double p){
		peso = p;
		}
	
	public void descarrega(){
		peso = 0.0;
		}

	public double getPeso(){
		return peso;
		}       
	}


class ExemploInterface{

	private Veiculo v;
	private Carro c;
	private Caminhao cm;
 
	void showPeso( TransporteDeCarga tc){
		System.out.println("Peso: " + tc.getPeso() );
		}

	ExemploInterface(){
		c = new Carro();
		cm = new Caminhao();
		v = cm;
		
		cm.carrega(123.4);
		showPeso( cm );
		}
	}        
	

public class Exemplo09{
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploInterface();
		System.out.println("Fim");
		}
	}
       
		
// Altere Carro para também suportar a interface TransporteDeCarga

// Crie uma subclasse de Caminhão, use como argumento para showPeso

// Crie uma nova interface, fala Caminhão implementar ela também 

