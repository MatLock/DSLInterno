package interfaces;

import classes.Evento;

public interface AgendaListener {
	
	
	public void sucedio(Evento evento);
	public void notificarPorMail(String mensaje);
	public void notificarPorSMS(String mensaje);
	public void notificarPorLlamada(String mensaje);

}
