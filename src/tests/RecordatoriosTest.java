package tests;



import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import classes.Listener;
import classes.RecordatorioEmail;
import classes.RecordatorioLlamada;
import classes.RecordatorioSMS;

public class RecordatoriosTest {
	
	RecordatorioEmail recordatorioEmail;
	RecordatorioLlamada recordatorioLlamada;
	RecordatorioSMS recordatorioSMS;
	Listener listener;
	
	@Before
	public void setUp(){
		listener = mock(Listener.class);
		recordatorioEmail = new RecordatorioEmail();
		recordatorioLlamada = new RecordatorioLlamada();
		recordatorioSMS = new RecordatorioSMS();
	}

	@Test
	public void testNotificarPorEmail() {
		recordatorioEmail.notificar("hola", listener);
		verify(listener).notificarPorMail("hola");
	}
	
	@Test
	public void testNotificarPorSMS(){
		recordatorioSMS.notificar("hola",listener);
		verify(listener).notificarPorSMS("hola");
	}
	
	@Test
	public void testNotificarPorLlamada(){
		recordatorioLlamada.notificar("hola", listener);
		verify(listener).notificarPorLlamada("hola");
	}
}
