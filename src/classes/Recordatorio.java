package classes;

import interfaces.AgendaListener;

public abstract class Recordatorio {

	
	public abstract void notificar(String mensaje, AgendaListener listener);
}
