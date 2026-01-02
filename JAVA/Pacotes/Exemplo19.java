/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/

import porta.*;


class Alarme implements PortaListener{
	Porta portaDireita, portaEsquerda;
	
	Alarme(Porta e, Porta d){
		portaEsquerda = e;
		portaDireita = d;
		portaEsquerda.addPortaListener( this );
		portaDireita.addPortaListener( this );
		System.out.println("Objeto Alarme criado\n");
		}
		
	public void portaAlterou(EventoPortaAberta e){
		if( e.getSource() == portaDireita )
			System.out.println("Alarme recebeu evento de portaDireita\n");
		else if( e.getSource() == portaEsquerda )
			System.out.println("Alarme recebeu evento de portaEsquerda\n");
		else
			System.out.println("Evento de quem ?????????\n");
						
		if( e.getPortaAberta() )
			System.out.println("Evento diz que porta foi aberta\n");
		else
			System.out.println("Evento diz que porta foi fechada\n");
		}								
		
	}		
		


class ExemploPacotes{
	
	Porta p1, p2;
	Alarme al;
		
	ExemploPacotes(){
	
		p1 = new Porta();
		p2 = new Porta();
		
		al = new Alarme( p1, p2);
		
		p1.abrePorta();
		p2.fechaPorta();
		}
	}			
		
	


public class Exemplo19{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploPacotes();
		System.out.println("Fim");
		}
	}       
		

// Crie uma nova classe no pacote porta e referencie aqui

// O que acontece se a nova classe for "package"


