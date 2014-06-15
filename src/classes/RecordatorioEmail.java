package classes;

import interfaces.AgendaListener;


public class RecordatorioEmail extends Recordatorio{
	
	String subject;
	String emailDestino;
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmailDestino() {
		return emailDestino;
	}

	public void setEmailDestino(String emailDestino) {
		this.emailDestino = emailDestino;
	}

	@Override
	public void notificar(String mensaje,AgendaListener listener){
		listener.guardarDatos("subject: "+ this.getSubject());
		listener.guardarDatos("emailDestino: "+ this.getEmailDestino());
		listener.notificarPorMail(mensaje);
	}
	

}
