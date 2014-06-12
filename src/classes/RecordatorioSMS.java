package classes;

import interfaces.AgendaListener;




public class RecordatorioSMS extends Recordatorio {
	

@Override
 public void notificar(String mensaje, AgendaListener listener){
	 listener.notificarPorSMS(mensaje);
 }

}