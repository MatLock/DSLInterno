package classes;

import java.util.List;

import interfaces.AgendaListener;

public class Evento {

	int horaInicio;
	String nombre;
	List<String>mensajes;
	Recordatorio recordatorio;

	public int getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	public List<String> getMensajes() {
		return mensajes;
	}
	public void setMensajes(List<String> mensajes) {
		this.mensajes = mensajes;
	}
	public Recordatorio getRecordatorio() {
		return recordatorio;
	}
	public void setRecordatorio(Recordatorio recordatorio) {
		this.recordatorio = recordatorio;
	}
	public void notificar(AgendaListener listener){
		Recordatorio recordatorio = this.getRecordatorio();
		recordatorio.notificar("Recordatorio Del Evento: "+this.getNombre(),listener);
		for(String mensaje : mensajes ){
     		recordatorio.notificar(mensaje,listener);		
		}
	}
	
	public void add(String mensaje){
		this.getMensajes().add(mensaje);
	}
	
	
	public Evento(int horaInicio, String nombre) {
		super();
		this.horaInicio = horaInicio;
		this.nombre = nombre;
	}
	
	public Evento(int horaInicio, String nombre,List<String>mensajes) {
		super();
		this.horaInicio = horaInicio;
		this.nombre = nombre;
		this.mensajes = mensajes;
	}
	
	
	
	
	
	
}
