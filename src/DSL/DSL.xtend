package DSL

import classes.Agenda
import classes.Evento
import classes.Listener
import classes.Recordatorio
import classes.RecordatorioEmail
import classes.RecordatorioLlamada
import classes.RecordatorioSMS
import java.util.ArrayList

class DSL {

	def DSL() {
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
	
	
	def RecordatorioLlamada recordarPorLlamada() {
		return new RecordatorioLlamada();
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

	def setNumeroDeDestinoLlamada(Object object, int i) {
		(object as RecordatorioLlamada).setNumeroDeDestino(i)
	}

	def setSubjectYEmail(Object object, String destinatario, String subject) {
		val recordatorioEmail = (object as RecordatorioEmail)
		recordatorioEmail.setSubject(subject)
		recordatorioEmail.setEmailDestino(destinatario)
	}

	// -------------------------------------- RUN ---------------------- //
	def run() {

		val listener = listener()
		val listener2 = listener()
		val listener3 = listener()
		val agenda = crearAgenda()

		agenda -> ( ( 8 => "despertarse") >> (recordarPorLlamada() <=>
											  [it | it.setNumeroDeDestinoLlamada(123)])) 
		
		
		       -> ( ( 10 => "Ir a la facu") >> (recordarPorEmail() <=>
		       				 [it | it.setSubjectYEmail("unEmail@gmail","Ir a la facu")]))
		       
		       -> ( ( (11 => "almorzar") >>> [ Evento remindMe | remindMe.add("acuerdate tambien de tener Plata")
			                                   ]) 
			                             >> ( recordarPorSMS() <=> [it | it.setNumeroDeDestinoSMS(123)
			                             	                          ]))
		
		
		agenda.tick(7, listener2)
		listener2.getNotificaciones().forEach [each | System.out.println(each)]
	    
	    System.out.println("\n")
		
		agenda.tick(9,listener3)
        listener3.getNotificaciones().forEach [each | System.out.println(each)]
        
        System.out.println("\n")
		agenda.tick(10, listener);
		listener.getNotificaciones().forEach [ each | System.out.println(each)]
        
	}

	def static void main(String[] args) {

		new DSL().run();
	}

}
