package classes;

import interfaces.AgendaListener;


public class RecordatorioEmail extends Recordatorio{
	
	@Override
	public void notificar(String mensaje,AgendaListener listener){
		listener.notificarPorMail(mensaje);
	}
	

}
