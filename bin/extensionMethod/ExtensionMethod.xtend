package extensionMethod

import classes.Agenda
import classes.Evento
import classes.Recordatorio
import java.util.ArrayList
import classes.RecordatorioLlamada
import classes.RecordatorioSMS
import classes.RecordatorioEmail
import classes.Listener

class ExtensionMethod {
	
	def ExtensionMethod(){
		
	}
	
	// agregar un elemento
	def Agenda operator_mappedTo(Agenda agenda, Evento e) {
		agenda.agregarEvento(e);
		return agenda
	}

	// crea un evento
	def Evento operator_doubleArrow(int hora, String mensaje) {
		return new Evento(hora, mensaje, new ArrayList<String>());
	}

	// agregar un tipo de recordatorio
	def Evento operator_doubleGreaterThan(Evento evento, Recordatorio r) {
		evento.setRecordatorio(r)
		return evento
	}

	def Agenda crearAgenda() {
		return new Agenda(new ArrayList<Evento>());
	}
// ---------------  DEFINE LA ESTRATEGIA ------------------- //
	
	
	def RecordatorioLlamada recordarPorLlamada((RecordatorioLlamada) => void f) {
		new RecordatorioLlamada => f
	}

	def RecordatorioSMS recordarPorSMS() {
		return new RecordatorioSMS();
	}

	def RecordatorioEmail recordarPorEmail() {
		return new RecordatorioEmail();
	}

	// ----------------  CREA UN LISTENER -------------------- //
	
	def Listener listener() {
		return new Listener(new ArrayList<String>());
	}

	
	
	// ---------------------- AGREGA UN BLOQUE A UN EVENTO ----- //
	
	def Evento operator_tripleGreaterThan(Evento even, (Evento) => void f) {
		f.apply(even)
		return even
	}

	
	// ---------------------------- REMINDERS CONFIGURABLES --------- //
	
	def dispatch RecordatorioEmail operator_spaceship(RecordatorioEmail r, (RecordatorioEmail) => void f) {
		f.apply(r)
		return r
	}

	def dispatch RecordatorioLlamada operator_spaceship(RecordatorioLlamada r, (RecordatorioLlamada) => void f) {
		f.apply(r)
		return r
	}

	def dispatch RecordatorioSMS operator_spaceship(RecordatorioSMS r, (RecordatorioSMS) => void f) {
		f.apply(r)
		return r
	}

	/**
	// preguntar como hacer infijo este metodo //
		def  void aDestino(RecordatorioSMS r, (RecordatorioSMS) => void f ){
			f.apply(r)
	  	 }
	* 	para hacer esto "x aDestino([it | System.out.println(it)])"
	* 
	*/
	// -----------------------------  ATROCIDADES VARIAS!! ----------------------//
	def setNumeroDeDestinoSMS(Object object, int i) {
		(object as RecordatorioSMS).setNumeroDeDestino(i)
	}

	def setSubjectYEmail(Object object, String destinatario, String subject) {
		val recordatorioEmail = (object as RecordatorioEmail)
		recordatorioEmail.setSubject(subject)
		recordatorioEmail.setEmailDestino(destinatario)
	}	
}