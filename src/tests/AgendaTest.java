package tests;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import classes.Agenda;
import classes.Evento;
import classes.Listener;
import classes.RecordatorioEmail;
import classes.RecordatorioLlamada;
import classes.RecordatorioSMS;
import excepciones.NoHayEventoException;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AgendaTest {
	Agenda agenda;
	Listener listener1;
	Listener listener2;
	Listener listener3;
	RecordatorioSMS recordatorioSMS;
	RecordatorioEmail recordatorioEmail;
	RecordatorioLlamada recordatorioLlamada;
	Evento evento1; 
	Evento evento2;
	Evento evento3;

	
	@Before
	public void setUp(){
		agenda = new Agenda(new ArrayList<Evento>());
		listener1 = mock(Listener.class);
		listener2 = mock(Listener.class);
		listener3 = mock(Listener.class);
		evento1 = mock(Evento.class);
		when(evento1.getHoraInicio()).thenReturn(1);
		when(evento1.getNombre()).thenReturn("pepitos");
		when(evento1.getRecordatorio()).thenReturn(recordatorioSMS);
		evento2 = mock(Evento.class);
		when(evento2.getHoraInicio()).thenReturn(2);
		when(evento2.getNombre()).thenReturn("hola");
		evento3 = mock(Evento.class);
		when(evento3.getHoraInicio()).thenReturn(3);
		when(evento3.getNombre()).thenReturn("chau");
		agenda.agregarEvento(evento1).agregarEvento(evento2).agregarEvento(evento3);
		recordatorioSMS = mock(RecordatorioSMS.class);
		recordatorioEmail = mock(RecordatorioEmail.class);
		recordatorioLlamada = mock(RecordatorioLlamada.class);
		
	}
		
	
	@Test
	public void testTickSMS(){
		agenda.tick(0,listener1);
		assertEquals(agenda.getEventos().size(),3);
		verify(evento1).notificar(listener1);
	}
	@Test
	public void testTickLlamada(){
		agenda.tick(1,listener2);
		verify(evento2).notificar(listener2);
	}
	@Test
	public void testTickEmail(){
		agenda.tick(2,listener3);
		verify(evento3).notificar(listener3);
	}
	
	@Test(expected = NoHayEventoException.class)
	public void testTickFailed(){
		agenda.tick(3,listener3);
	}
	
	

}
