package classes;

import interfaces.AgendaListener;




public class RecordatorioSMS extends Recordatorio {
	Integer numeroDeDestino = 000;
	
	
	

	public Integer getNumeroDeDestino() {
		return numeroDeDestino;
	}



	public void setNumeroDeDestino(Integer numeroDeDestino) {
		this.numeroDeDestino = numeroDeDestino;
	}




@Override
 public void notificar(String mensaje, AgendaListener listener){
     listener.guardarDatos("Mensaje a Numero: " + this.getNumeroDeDestino().toString());
	 listener.notificarPorSMS(mensaje);
 }

}