package tests;

import classes.Agenda;
import classes.Evento;
import classes.Listener;
import classes.Recordatorio;
import classes.RecordatorioEmail;
import classes.RecordatorioLlamada;
import classes.RecordatorioSMS;
import extensionMethod.ExtensionMethod;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class DSLTest {
  @Extension
  private ExtensionMethod _extensionMethod = new ExtensionMethod();
  
  private Agenda agenda;
  
  private Listener listener1;
  
  private Listener listener2;
  
  private Listener listener3;
  
  @Before
  public void setUp() {
    Listener _listener = this._extensionMethod.listener();
    this.listener1 = _listener;
    Listener _listener_1 = this._extensionMethod.listener();
    this.listener2 = _listener_1;
    Listener _listener_2 = this._extensionMethod.listener();
    this.listener3 = _listener_2;
    Agenda _crearAgenda = this._extensionMethod.crearAgenda();
    this.agenda = _crearAgenda;
    Evento _doubleArrow = this._extensionMethod.operator_doubleArrow(8, "despertarse");
    final Procedure1<RecordatorioLlamada> _function = new Procedure1<RecordatorioLlamada>() {
      public void apply(final RecordatorioLlamada it) {
        it.setNumeroDeDestino(Integer.valueOf(123));
      }
    };
    RecordatorioLlamada _recordarPorLlamada = this._extensionMethod.recordarPorLlamada(_function);
    Evento _doubleGreaterThan = this._extensionMethod.operator_doubleGreaterThan(_doubleArrow, _recordarPorLlamada);
    Agenda _mappedTo = this._extensionMethod.operator_mappedTo(
      this.agenda, _doubleGreaterThan);
    Evento _doubleArrow_1 = this._extensionMethod.operator_doubleArrow(10, "Ir a la facu");
    RecordatorioEmail _recordarPorEmail = this._extensionMethod.recordarPorEmail();
    final Procedure1<Object> _function_1 = new Procedure1<Object>() {
      public void apply(final Object it) {
        DSLTest.this._extensionMethod.setSubjectYEmail(it, "unEmail@gmail", "Ir a la facu");
      }
    };
    Recordatorio _spaceship = this._extensionMethod.operator_spaceship(_recordarPorEmail, _function_1);
    Evento _doubleGreaterThan_1 = this._extensionMethod.operator_doubleGreaterThan(_doubleArrow_1, _spaceship);
    Agenda _mappedTo_1 = this._extensionMethod.operator_mappedTo(_mappedTo, _doubleGreaterThan_1);
    Evento _doubleArrow_2 = this._extensionMethod.operator_doubleArrow(11, "almorzar");
    final Procedure1<Evento> _function_2 = new Procedure1<Evento>() {
      public void apply(final Evento it) {
        it.add("acuerdate tambien de tener Plata");
      }
    };
    Evento _tripleGreaterThan = this._extensionMethod.operator_tripleGreaterThan(_doubleArrow_2, _function_2);
    RecordatorioSMS _recordarPorSMS = this._extensionMethod.recordarPorSMS();
    final Procedure1<Object> _function_3 = new Procedure1<Object>() {
      public void apply(final Object it) {
        DSLTest.this._extensionMethod.setNumeroDeDestinoSMS(it, 123);
      }
    };
    Recordatorio _spaceship_1 = this._extensionMethod.operator_spaceship(_recordarPorSMS, _function_3);
    Evento _doubleGreaterThan_2 = this._extensionMethod.operator_doubleGreaterThan(_tripleGreaterThan, _spaceship_1);
    this._extensionMethod.operator_mappedTo(_mappedTo_1, _doubleGreaterThan_2);
  }
  
  @Test
  public void testNotificacionesPorLlamada() {
    this.agenda.tick(7, this.listener1);
    List<String> _notificaciones = this.listener1.getNotificaciones();
    int _size = _notificaciones.size();
    Assert.assertEquals(_size, 2);
  }
  
  @Test
  public void testNotificacionesPorSMS() {
    this.agenda.tick(10, this.listener3);
    List<String> _notificaciones = this.listener3.getNotificaciones();
    int _size = _notificaciones.size();
    Assert.assertEquals(_size, 4);
  }
  
  @Test
  public void testNotificacionesPorEMAIL() {
    this.agenda.tick(9, this.listener2);
    List<String> _notificaciones = this.listener2.getNotificaciones();
    int _size = _notificaciones.size();
    Assert.assertEquals(_size, 3);
  }
}
