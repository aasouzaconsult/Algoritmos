/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/

import java.util.EventObject;


class EventoPortaAberta extends EventObject{
	private boolean estado;

	EventoPortaAberta(Object source, boolean p){
		super(source);
		estado = p;
		} 
	
	boolean getPortaAberta(){
		return estado;
		}
	}

	

interface PortaListener{
	void portaAlterou(EventoPortaAberta e);
	}
	 	


class Porta{
	
	private PortaListener interessado = null;

	boolean addPortaListener(PortaListener pl) {
		if( interessado == null ){
			interessado = pl;
			return true;
			}
		else
			return false;
		}

	void removePortaListener(PortaListener pl) {
		if( interessado == pl )
			interessado = null;
		}

	void geraEventoPorta(EventoPortaAberta e) {
		if (interessado != null)
			interessado.portaAlterou( e );
		}        
       
	void abrePorta(){
		System.out.println("metodo abrePorta da Porta");
		EventoPortaAberta ep = new EventoPortaAberta( this, true);
		geraEventoPorta( ep );
		}
	
	void fechaPorta(){
		System.out.println("metodo fechaPorta da Porta");
		EventoPortaAberta ep = new EventoPortaAberta( this, false);
		geraEventoPorta( ep );
		}
	}
	
	

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
		


class ExemploEventos{
	
	Porta p1, p2;
	Alarme al;
		
	ExemploEventos(){
	
		p1 = new Porta();
		p2 = new Porta();
		
		al = new Alarme( p1, p2);
		
		p1.abrePorta();
		p2.fechaPorta();
		}
	}			
		
	


public class Exemplo13{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploEventos();
		System.out.println("Fim");
		}
	}       
		

// Mude a classe porta para poder existirem vários interessados
 
// Crie uma classe Luzes que também está interessada em eventos da porta

// Teste a inclusão e remoção de vários PortaListeners


