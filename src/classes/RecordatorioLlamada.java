package classes;

import interfaces.AgendaListener;


public class RecordatorioLlamada extends Recordatorio{
	Integer numeroDeDestino = 000;

	public Integer getNumeroDeDestino() {
		return numeroDeDestino;
	}

	public void setNumeroDeDestino(Integer numeroDeDestino) {
		this.numeroDeDestino = numeroDeDestino;
	}

	@Override
	public void notificar(String mensaje, AgendaListener listener){
		listener.guardarDatos("Llamada a:" + this.numeroDeDestino.toString());
		listener.notificarPorLlamada(mensaje);
	}
	

}
