/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/

class ExemploArray{

	double[] ex1;
	
	double[] ex2 = new double[10];
	
	double[][] ex3;	
	
	double somatorio(double x[]){
		double soma = 0.0;
		
		for( int i=0; i < x.length; ++i)
			soma += x[i];
			
		return soma;
		}	
		


	ExemploArray(){
			
		// ex1
	
		ex1 = new double[5];
		
		for( int i=0; i<5; ++i)
			ex1[i] = 100.0;
			
		System.out.println("ex1 tem tamanho " + ex1.length + " e soma " + somatorio(ex1) );
	
		// ex2
		
		for( int i=0; i<ex2.length; ++i)
			ex2[i] = i * 10.0;
			
		System.out.println("ex2 tem tamanho " + ex2.length + " e soma " + somatorio(ex2) );
	
		// ex3 (matrix)
	
		ex3 = new double[3][];
		
		for( int i=0; i<ex3.length; ++i){
			ex3[i] = new double[10];
			for( int j=0; j<ex3[i].length; ++j)
				ex3[i][j] = j + 100.0 * i;
			}

		for( int i=0; i<ex3.length; ++i)
			System.out.println("ex3[ " + i + " ] tem tamanho " +
				ex3[i].length + " e soma " + somatorio(ex3[i]) );
		}
	}
		
	

public class Exemplo02{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploArray();
		System.out.println("Fim");
		}
	}       
		

// Crie um metodo para fazer o somatorio da matriz inteira

// Eh possivel criar ex3 com linhas de tamanho variado ?


