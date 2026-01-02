/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/

package porta;

public class Porta{
	
	private PortaListener interessado = null;

	public boolean addPortaListener(PortaListener pl) {
		if( interessado == null ){
			interessado = pl;
			return true;
			}
		else
			return false;
		}

	public void removePortaListener(PortaListener pl) {
		if( interessado == pl )
			interessado = null;
		}

	public void geraEventoPorta(EventoPortaAberta e) {
		if (interessado != null)
			interessado.portaAlterou( e );
		}        
       
	public void abrePorta(){
		System.out.println("metodo abrePorta da Porta");
		EventoPortaAberta ep = new EventoPortaAberta( this, true);
		geraEventoPorta( ep );
		}
	
	public void fechaPorta(){
		System.out.println("metodo fechaPorta da Porta");
		EventoPortaAberta ep = new EventoPortaAberta( this, false);
		geraEventoPorta( ep );
		}
	}
	
	
