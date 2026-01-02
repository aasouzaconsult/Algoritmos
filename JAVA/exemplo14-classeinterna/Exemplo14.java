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
	 	


class PortaAdapter implements PortaListener{

	public void portaAlterou(EventoPortaAberta e){
		}		
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
	
	

class Alarme{
	Porta portaDireita, portaEsquerda;
	
	class EscutaPorta extends PortaAdapter{
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

	Alarme(Porta e, Porta d){
		EscutaPorta ep = new EscutaPorta();
		
		portaEsquerda = e;
		portaDireita = d;
		portaEsquerda.addPortaListener( ep );
		portaDireita.addPortaListener( ep );
		System.out.println("Objeto Alarme criado\n");
		}
		
		
	}		
		


class ExemploClasseInterna{
	
	Porta p1, p2;
	Alarme al;
		
	ExemploClasseInterna(){
	
		p1 = new Porta();
		p2 = new Porta();
		
		al = new Alarme( p1, p2);
		
		p1.abrePorta();
		p2.fechaPorta();
		}
	}			
		
	


public class Exemplo14{                
	public static void main( String args[] ){
		System.out.println("Inicio");           
		new ExemploClasseInterna();
		System.out.println("Fim");
		}
	}       
		

// Amplie a interface PortaListener para que outros métodos sejam necessários

// Altere a classe PortaAdapter para refletir estas mudanças

// É necessário alterar Alarme em função dessa mudança ?

