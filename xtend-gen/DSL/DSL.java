package DSL;

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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DSL {
  @Extension
  private ExtensionMethod _extensionMethod = new ExtensionMethod();
  
  public static void main(final String[] args) {
    DSL _dSL = new DSL();
    _dSL.run();
  }
  
  public void run() {
    final Listener listener1 = this._extensionMethod.listener();
    final Listener listener2 = this._extensionMethod.listener();
    final Listener listener3 = this._extensionMethod.listener();
    final Agenda agenda = this._extensionMethod.crearAgenda();
    Evento _doubleArrow = this._extensionMethod.operator_doubleArrow(8, "despertarse");
    final Procedure1<RecordatorioLlamada> _function = new Procedure1<RecordatorioLlamada>() {
      public void apply(final RecordatorioLlamada it) {
        it.setNumeroDeDestino(Integer.valueOf(123));
      }
    };
    RecordatorioLlamada _recordarPorLlamada = this._extensionMethod.recordarPorLlamada(_function);
    Evento _doubleGreaterThan = this._extensionMethod.operator_doubleGreaterThan(_doubleArrow, _recordarPorLlamada);
    Agenda _mappedTo = this._extensionMethod.operator_mappedTo(agenda, _doubleGreaterThan);
    Evento _doubleArrow_1 = this._extensionMethod.operator_doubleArrow(10, "Ir a la facu");
    RecordatorioEmail _recordarPorEmail = this._extensionMethod.recordarPorEmail();
    final Procedure1<Object> _function_1 = new Procedure1<Object>() {
      public void apply(final Object it) {
        DSL.this._extensionMethod.setSubjectYEmail(it, "unEmail@gmail", "Ir a la facu");
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
        DSL.this._extensionMethod.setNumeroDeDestinoSMS(it, 123);
      }
    };
    Recordatorio _spaceship_1 = this._extensionMethod.operator_spaceship(_recordarPorSMS, _function_3);
    Evento _doubleGreaterThan_2 = this._extensionMethod.operator_doubleGreaterThan(_tripleGreaterThan, _spaceship_1);
    this._extensionMethod.operator_mappedTo(_mappedTo_1, _doubleGreaterThan_2);
    agenda.tick(7, listener1);
    List<String> _notificaciones = listener1.getNotificaciones();
    final Procedure1<String> _function_4 = new Procedure1<String>() {
      public void apply(final String each) {
        System.out.println(each);
      }
    };
    IterableExtensions.<String>forEach(_notificaciones, _function_4);
    System.out.println("\n");
    agenda.tick(9, listener2);
    List<String> _notificaciones_1 = listener2.getNotificaciones();
    final Procedure1<String> _function_5 = new Procedure1<String>() {
      public void apply(final String each) {
        System.out.println(each);
      }
    };
    IterableExtensions.<String>forEach(_notificaciones_1, _function_5);
    System.out.println("\n");
    agenda.tick(10, listener3);
    List<String> _notificaciones_2 = listener3.getNotificaciones();
    final Procedure1<String> _function_6 = new Procedure1<String>() {
      public void apply(final String each) {
        System.out.println(each);
      }
    };
    IterableExtensions.<String>forEach(_notificaciones_2, _function_6);
  }
}
