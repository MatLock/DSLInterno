package classes;

import interfaces.AgendaListener;

import java.util.ArrayList;
import java.util.List;

import excepciones.NoHayEventoException;

public class Agenda {
		
		List<Evento> eventos;
		
		
	public List<Evento> getEventos(){
		return eventos;
	}
	
	public void setEventos(List<Evento>eventos){
		this.eventos = eventos;
	}
		
		
	public Agenda() {
			super();
			this.eventos = new ArrayList<Evento>();
		}
	
	
	
	
	public Agenda agregarEvento(Evento evento){
		eventos.add(evento);
		return this;
	}
	
	public void tick(int hora, AgendaListener listener){
		
		Evento evento = this.buscarEvento(hora);
		evento.notificar(listener);
	}
	
	
	
	private Evento buscarEvento(int hora) {
		for (Evento e : this.getEventos()){
			if (e.getHoraInicio()== hora + 1){
				Evento evento;
				evento = e;
				return evento;
			}
		}throw new NoHayEventoException("no hay ningun evento para esta hora: '" +hora+"'");
		
	}
	
}
