/** 
	Rômulo Silva de Oliveira
	Departamento de Automação e Sistemas - UFSC
*/

package porta;

import java.util.EventObject;

public class EventoPortaAberta extends EventObject{
	private boolean estado;

	EventoPortaAberta(Object source, boolean p){
		super(source);
		estado = p;
		} 
	
	public boolean getPortaAberta(){
		return estado;
		}
	}

