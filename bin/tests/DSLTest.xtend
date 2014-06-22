package tests

import org.junit.Test
import extensionMethod.ExtensionMethod
import classes.Agenda
import classes.Listener
import org.junit.Before
import static org.junit.Assert.*

class DSLTest {
	
		extension ExtensionMethod = new ExtensionMethod()
		Agenda agenda;
		Listener listener1
		Listener listener2
		Listener listener3
	
	@Before
	def void setUp(){
	 	
		listener1 = listener
		listener2 = listener
		listener3 = listener
		agenda = crearAgenda

		agenda -> ( 8   => "despertarse" >> recordarPorLlamada [ numeroDeDestino = 123])
		                                      
		       -> ( 10  => "Ir a la facu" >> (recordarPorEmail <=>
		       				 [setSubjectYEmail("unEmail@gmail","Ir a la facu")]))
		                                 //BLOQUE REMAINDER//
		       -> (( 11 => "almorzar" >>> [ add("acuerdate tambien de tener Plata") ]) 
			                          >> ( recordarPorSMS <=> [ setNumeroDeDestinoSMS(123)]))
			                                                  // BLOQUE REMAINDER CONFIGURABLE //
    }
	
	
	@Test
	def testNotificacionesPorLlamada(){
		agenda.tick(7,listener1)
		assertEquals(listener1.getNotificaciones.size,2)
		assertEquals(listener1.getNotificaciones.get(0),"Llamada a:123")
		assertEquals(listener1.getNotificaciones.get(0),"mensaje: Recordatorio Del Evento: despertarse 'Recordado Por Llamada Telefonica'")
	}
	
	@Test
	def testNotificacionesPorSMS(){
	    agenda.tick(9,listener2)
	    assertEquals(listener2.getNotificaciones.size,3)
	    assertEquals(listener2.getNotificaciones.get(0),"subject: Ir a la facu")
	    assertEquals(listener2.getNotificaciones.get(1),"emailDestino: unEmail@gmail")
		assertEquals(listener2.getNotificaciones.get(2),"mensaje: Recordatorio Del Evento: Ir a la facu 'Enviado por EMAIL'")
	}
	
	@Test
	def testNotificacionesPorEMAIL(){
		agenda.tick(10,listener3)
		assertEquals(listener3.getNotificaciones.size,4)
		assertEquals(listener3.getNotificaciones.get(0),"Mensaje a Numero: 123")
		assertEquals(listener3.getNotificaciones.get(1),"mensaje: Recordatorio Del Evento: almorzar 'Enviado por SMS'")
		assertEquals(listener3.getNotificaciones.get(2),"Mensaje a Numero: 123")
		assertEquals(listener3.getNotificaciones.get(2),"mensaje: acuerdate tambien de tener Plata 'Enviado por SMS'")
	}
}