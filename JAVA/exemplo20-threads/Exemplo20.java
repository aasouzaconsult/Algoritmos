/**
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/



class Comando {
	private boolean parar = false;
	
	synchronized void setParar( boolean b){
		parar = b;
		if( parar == true )	notify();
		}		

	synchronized boolean getParar(){
		return parar;
		}		

	synchronized void esperaAcabar(){
		try{
			while( parar == false )	wait();
			}catch( InterruptedException e){}
		}		
	}	
	
	



class ContaTempo implements Runnable {
	
	private int tamanhoSoneca = 1000;
	private String nome = "sem nome";
	private int sonecas = 0;
	private Comando com;

	ContaTempo( String n, int x, Comando c){
		nome = n;
		tamanhoSoneca = x;
		com = c;
		}
		
	void setTamanhoSoneca( int x ){
		tamanhoSoneca = x;
		}
			
	int getTamanhoSoneca(){
		return tamanhoSoneca;
		}
		
	public void run(){
		
		long t1, t2, tx;
		
		System.out.println("Inicio da thread >>" + nome + "<<");

		Thread.currentThread().setPriority( Thread.MAX_PRIORITY);

		t1 = System.currentTimeMillis();		// inicio do periodo ideal corrente

		while( true ){
			t2 = t1 + tamanhoSoneca;			// fim do periodo ideal corrente
			tx = System.currentTimeMillis();	// agora

			if( t2 > tx )
				try{							// tem tempo para dormir
					Thread.sleep( t2 - tx );
					}catch (InterruptedException e){}
					
			++sonecas;		
			System.out.println("Thread " + nome + " acordou, vez " + sonecas);
			if( sonecas == 30 )
				com.setParar(true);
			if( com.getParar() )
				break;
				
			t1 = t2;							// novo periodo ideal corrente
			}

		}
	}





class ExemploThread{

	Comando com;

	ContaTempo ct1, ct2, ct3;
	
	Thread t1, t2, t3;


	ExemploThread(){
	
		com = new Comando();

		ct1 = new ContaTempo( "AAAAA", 1000, com);
		ct2 = new ContaTempo( "BBBBB", 2000, com);
		ct3 = new ContaTempo( "CCCCC", 3000, com);

		t1 = new Thread( ct1 );
		t1.start();
		
		t2 = new Thread( ct2 );
		t2.start();

		t3 = new Thread( ct3 );
		t3.start();

		com.esperaAcabar();
		
		System.out.println("Comando manda todos pararem");
		}
	}
	

public class Exemplo20{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploThread();
		System.out.println("Fim");
		}
	}       
		

// Aumente o numero de threads contadoras

// Faça as threads serem interrompidas tao logo parar seja decidido
 
