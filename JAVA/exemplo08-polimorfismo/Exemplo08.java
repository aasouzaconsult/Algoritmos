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


class Caminhao extends Veiculo {
	private int numeroDeEixos = 2;
	
	void setNumeroDeEixos( int n){
		numeroDeEixos = n;
		}

	int getNumeroDeEixos(){
		return numeroDeEixos;
		}
	}


class Motocicleta extends Veiculo {
	private boolean temCaixa = false;
	
	void setTemCaixa( boolean t){
		temCaixa = t;
		}

	boolean getTemCaixa(){
		return temCaixa;
		}
	}


class ExemploPolimorfismo{

	Veiculo[] frota = new Veiculo[4];

	Carro c;
	Caminhao cm;
	Motocicleta m;


	void showPlaca( Veiculo v){
		System.out.println("Placa: " + v.getPlaca() );
		}

	
	ExemploPolimorfismo(){
	
		c = new Carro();
		cm = new Caminhao();
		m = new Motocicleta();
	
		frota[0] = new Veiculo();
		frota[1] = c;
		frota[2] = cm;
		frota[3] = m;
							
		for( int i=0; i<frota.length; ++i)
			frota[i].setPlaca("ABC000" + i );

		for( int i=0; i<frota.length; ++i)
			showPlaca( frota[i] );
			
		c.setNumeroDePortas(5);
		
		frota[2].setPlaca("XYZ9999");
		showPlaca( cm);
		
		m.setPlaca("MMM8888");
		showPlaca( m);
		
		}
	}
	

public class Exemplo08{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploPolimorfismo();
		System.out.println("Fim");
		}
	}       
		

// Crie CarroComReboque como uma subclasse de Carro, showPlaca aceita ?

// Use o operador "isInstanceOf" para determinar a classe de um objeto

// Faça Carro sobrepor o método setPlaca, teste a alteração
