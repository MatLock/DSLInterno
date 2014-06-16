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
		notificaciones.add("mensaje: "+mensaje+" 'Enviado por EMAIL'");
	}

	@Override
	public void notificarPorSMS(String mensaje) {
		notificaciones.add("mensaje: "+mensaje+" 'Enviado por SMS'");	
	}

	@Override
	public void notificarPorLlamada(String mensaje) {
		notificaciones.add("mensaje: "+mensaje+" 'Recordado Por Llamada Telefonica'");
	}




	@Override
	public void guardarDatos(String string) {
		notificaciones.add(string);
		
	}

}
