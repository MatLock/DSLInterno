package DSL

import classes.Agenda
import classes.Evento
import classes.Listener
import classes.Recordatorio
import classes.RecordatorioEmail
import classes.RecordatorioLlamada
import classes.RecordatorioSMS
import java.util.ArrayList
//import org.eclipse.xtext.xbase.lib.Functions.Function1

class DSL {
	
    def DSL(){}
	
		
	// agregar un elemento
	def Agenda operator_mappedTo(Agenda agenda,Evento e){
		agenda.agregarEvento(e);
		return agenda
	} 
	
	// crea un evento
	def Evento operator_doubleArrow(int hora, String mensaje){
		return new Evento(hora,mensaje,new ArrayList<String>());
	}
	
	// agregar un tipo de recordatorio
	def Evento operator_doubleGreaterThan(Evento evento, Recordatorio r){
		evento.setRecordatorio(r)
		return evento
	}
	
	def Agenda crearAgenda(){
		return new Agenda(new ArrayList<Evento>());
	}
	
	def Evento operator_tripleGreaterThan(Evento even, (Evento) => void f ){
		f.apply(even)
		return even
	}
	
	
	// ---------------  DEFINE LA ESTRATEGIA ------------------- //
	def RecordatorioLlamada recordarPorLlamada(){
		return new RecordatorioLlamada();
	}
	
	def RecordatorioSMS recordarPorSMS(){
		return new RecordatorioSMS();
	}
	
	def RecordatorioEmail recordarPorEmail(){
		return new RecordatorioEmail();
	}
	
	
	
	
	// ----------------  CREA UN LISTENER -------------------- //
	def Listener listener(){
		return new Listener(new ArrayList<String>());
	}
	
	// ---------------------- AGREGACION DE UN BLOQUE A UN EVENTO ----- //
	
	def run(){
		
		val listener = listener()
		val agenda = crearAgenda()
		
    	
    	agenda -> ( (8  => "despertarse") >> recordarPorSMS())
    	       -> ( 10 => "Ir a la facu")
    	       -> (  ( (11 => "almorzar") >>> [ Evento remindMe | remindMe.add("acuerdate tambien de tener Plata")])
    	           						  >> recordarPorSMS())
		
		agenda.tick(10,listener);
		System.out.println(listener.getNotificaciones().get(0))
		System.out.println(listener.getNotificaciones().get(1))
		
		
	}
    
    def static void main(String[] args) {
    	
    	new DSL().run();    	
    }
    
	
}