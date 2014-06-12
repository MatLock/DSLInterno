package classes;

import interfaces.AgendaListener;


public class RecordatorioLlamada extends Recordatorio{

	@Override
	public void notificar(String mensaje, AgendaListener listener){
		listener.notificarPorLlamada(mensaje);
	}
	

}
