/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/


class ExemploFluxo{

	int fatorial(int x){
		int fat = 1;
		
		for( int i=2; i <= x; ++i)
			fat = fat * i;
		return fat;
		}	
		

	ExemploFluxo(){
	
		String msg = "fim !!!";
		double d;
		int i;
		char c;
		boolean b;
		
		for(int j=0; j<5; ++j){
			d = 123.0 * j;
			System.out.println("usando " + j + " deu " + d + "\n");
			}
			
		i = 1;
		while( i <= 5 ){
			d = i * i;
			if( d > 10 )
				System.out.println("Passou de 10\n");
			else
				System.out.println("Ainda não passou\n");
			++i;
			}
			
		System.out.println("Fatorial de 5 eh " + fatorial(5) );
		System.out.println( msg );
		
		}
	}
	

public class Exemplo01{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploFluxo();
		System.out.println("Fim");
		}
	}       
		

// Experimente o comando switch

// Faça operações com números reais

// Use expressões booleanas com and, or, not




