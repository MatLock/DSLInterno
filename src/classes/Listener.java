package classes;

import java.util.List;

import interfaces.AgendaListener;

public class Listener implements AgendaListener {
	
	List<String>notificaciones;

	public Listener(List<String> notificaciones) {
		super();
		this.notificaciones = notificaciones;
	}
	
	
	

	public List<String> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(List<String> notificaciones) {
		this.notificaciones = notificaciones;
	}




	@Override
	public void sucedio(Evento evento) {
		for(String n : notificaciones ){
			if (n.endsWith(evento.getNombre())){
				notificaciones.remove(n);
			}
		}
	}

	@Override
	public void notificarPorMail(String mensaje) {
		notificaciones.add("Recordatorio del Evento por EMAIL " + mensaje);
	}

	@Override
	public void notificarPorSMS(String mensaje) {
		notificaciones.add("Recordatorio del Evento por SMS: " +"' "+ mensaje +" '");	
	}

	@Override
	public void notificarPorLlamada(String mensaje) {
		notificaciones.add("Recordatorio del Evento por Llamada " + mensaje);
	}

}
