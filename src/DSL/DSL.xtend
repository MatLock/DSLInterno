package DSL

import extensionMethod.ExtensionMethod

class DSL {
	
	extension ExtensionMethod = new ExtensionMethod

	def static void main(String[] args) {

		new DSL().run();
	}
	// -------------------------------------- RUN ---------------------- //
	def run() {

		val listener1 = listener
		val listener2 = listener
		val listener3 = listener
		val agenda = crearAgenda

		agenda -> ( 8   => "despertarse" >> recordarPorLlamada [ numeroDeDestino = 123])
		
		       -> ( 10  => "Ir a la facu" >> (recordarPorEmail <=>
		       				 [setSubjectYEmail("unEmail@gmail","Ir a la facu")]))
		       
		       -> (( 11 => "almorzar" >>> [ add("acuerdate tambien de tener Plata") ]) 
			                          >> ( recordarPorSMS <=> [ setNumeroDeDestinoSMS(123)]))
		
		
		
		agenda.tick(7, listener1)
		listener1.getNotificaciones().forEach [each | System.out.println(each)]
	    
	    System.out.println("\n")
		
		agenda.tick(9,listener2)
        listener2.getNotificaciones().forEach [each | System.out.println(each)]
        
        System.out.println("\n")
		agenda.tick(10, listener3);
		listener3.getNotificaciones().forEach [ each | System.out.println(each)]
        
	}


}
