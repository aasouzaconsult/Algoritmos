/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/

class MinhaException extends Exception {
	
	private double dadoQualquer;

	double getDado(){
		return dadoQualquer;
		}
	
	
	MinhaException( double d){
		super("Parametro errado");
		dadoQualquer = d;
		}
	}




class ExemploExcecoes{

	int calculo(int x){
		return x / 0;
		}	
		

	double meusCalculos(double x) throws MinhaException{
		if( x < 0 )
			throw new MinhaException( x );
		else
			return x * 10;
		}	
	

	ExemploExcecoes(int b[]){
		
		int c;
		int[] a = new int[2];
		
		System.out.println("\nTesta divisao por zero em inteiros");
		try{
			c = calculo(7);
			}catch( Exception e) {
				System.out.println("Excecao: " + e.getMessage() );
				}
			

		System.out.println("\nTesta indice de array fora dos limites");
		try{
			a[4] = 11;
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
			}catch (NullPointerException e ) {
				System.out.println("NullPointerException: " + e.getMessage());
       			}    				
				

				
		System.out.println("\nTesta referencia para objeto que nao existe");
		try{
			b[4] = 11;
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
			}catch (NullPointerException e ) {
				System.out.println("NullPointerException: " + e.getMessage());
				}    				
	


		System.out.println("\nTesta passar parametro errado para funcao");
		try{
			System.out.println( meusCalculos( 15  ) );
			System.out.println( meusCalculos( -20 ) );
			}catch (MinhaException e) {
				System.out.println("Excecao: " + e.getMessage());
				System.out.println("Dados extras: " + e.getDado());
				System.out.println("Pilha de execucao >>>>>");
				e.printStackTrace();
				}

		}
	}
	

public class Exemplo17{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploExcecoes( null );
		System.out.println("Fim");
		}
	}       
		

// Divisão por zero em ponto flutuante retorna exceção ?

// O que acontece quando a exceção não é tratada ?

// Mude o uso de b[4] para usar a classe Exception apenas



