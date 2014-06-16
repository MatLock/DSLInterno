package DSL;

import classes.Agenda;
import classes.Evento;
import classes.Listener;
import classes.Recordatorio;
import classes.RecordatorioEmail;
import classes.RecordatorioLlamada;
import classes.RecordatorioSMS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DSL {
  public Object DSL() {
    return null;
  }
  
  public Agenda operator_mappedTo(final Agenda agenda, final Evento e) {
    agenda.agregarEvento(e);
    return agenda;
  }
  
  public Evento operator_doubleArrow(final int hora, final String mensaje) {
    ArrayList<String> _arrayList = new ArrayList<String>();
    return new Evento(hora, mensaje, _arrayList);
  }
  
  public Evento operator_doubleGreaterThan(final Evento evento, final Recordatorio r) {
    evento.setRecordatorio(r);
    return evento;
  }
  
  public Agenda crearAgenda() {
    ArrayList<Evento> _arrayList = new ArrayList<Evento>();
    return new Agenda(_arrayList);
  }
  
  public RecordatorioLlamada recordarPorLlamada() {
    return new RecordatorioLlamada();
  }
  
  public RecordatorioSMS recordarPorSMS() {
    return new RecordatorioSMS();
  }
  
  public RecordatorioEmail recordarPorEmail() {
    return new RecordatorioEmail();
  }
  
  public Listener listener() {
    ArrayList<String> _arrayList = new ArrayList<String>();
    return new Listener(_arrayList);
  }
  
  public Evento operator_tripleGreaterThan(final Evento even, final Procedure1<? super Evento> f) {
    f.apply(even);
    return even;
  }
  
  protected RecordatorioEmail _operator_spaceship(final RecordatorioEmail r, final Procedure1<? super RecordatorioEmail> f) {
    f.apply(r);
    return r;
  }
  
  protected RecordatorioLlamada _operator_spaceship(final RecordatorioLlamada r, final Procedure1<? super RecordatorioLlamada> f) {
    f.apply(r);
    return r;
  }
  
  protected RecordatorioSMS _operator_spaceship(final RecordatorioSMS r, final Procedure1<? super RecordatorioSMS> f) {
    f.apply(r);
    return r;
  }
  
  /**
   * // preguntar como hacer infijo este metodo //
   * def  void aDestino(RecordatorioSMS r, (RecordatorioSMS) => void f ){
   * f.apply(r)
   * }
   * 	para hacer esto "x aDestino([it | System.out.println(it)])"
   */
  public void setNumeroDeDestinoSMS(final Object object, final int i) {
    ((RecordatorioSMS) object).setNumeroDeDestino(Integer.valueOf(i));
  }
  
  public void setNumeroDeDestinoLlamada(final Object object, final int i) {
    ((RecordatorioLlamada) object).setNumeroDeDestino(Integer.valueOf(i));
  }
  
  public void setSubjectYEmail(final Object object, final String destinatario, final String subject) {
    final RecordatorioEmail recordatorioEmail = ((RecordatorioEmail) object);
    recordatorioEmail.setSubject(subject);
    recordatorioEmail.setEmailDestino(destinatario);
  }
  
  public void run() {
    final Listener listener = this.listener();
    final Listener listener2 = this.listener();
    final Listener listener3 = this.listener();
    final Agenda agenda = this.crearAgenda();
    Evento _doubleArrow = this.operator_doubleArrow(8, "despertarse");
    RecordatorioLlamada _recordarPorLlamada = this.recordarPorLlamada();
    final Procedure1<Object> _function = new Procedure1<Object>() {
      public void apply(final Object it) {
        DSL.this.setNumeroDeDestinoLlamada(it, 123);
      }
    };
    Recordatorio _spaceship = this.operator_spaceship(_recordarPorLlamada, _function);
    Evento _doubleGreaterThan = this.operator_doubleGreaterThan(_doubleArrow, _spaceship);
    Agenda _mappedTo = this.operator_mappedTo(agenda, _doubleGreaterThan);
    Evento _doubleArrow_1 = this.operator_doubleArrow(10, "Ir a la facu");
    RecordatorioEmail _recordarPorEmail = this.recordarPorEmail();
    final Procedure1<Object> _function_1 = new Procedure1<Object>() {
      public void apply(final Object it) {
        DSL.this.setSubjectYEmail(it, "unEmail@gmail", "Ir a la facu");
      }
    };
    Recordatorio _spaceship_1 = this.operator_spaceship(_recordarPorEmail, _function_1);
    Evento _doubleGreaterThan_1 = this.operator_doubleGreaterThan(_doubleArrow_1, _spaceship_1);
    Agenda _mappedTo_1 = this.operator_mappedTo(_mappedTo, _doubleGreaterThan_1);
    Evento _doubleArrow_2 = this.operator_doubleArrow(11, "almorzar");
    final Procedure1<Evento> _function_2 = new Procedure1<Evento>() {
      public void apply(final Evento remindMe) {
        remindMe.add("acuerdate tambien de tener Plata");
      }
    };
    Evento _tripleGreaterThan = this.operator_tripleGreaterThan(_doubleArrow_2, _function_2);
    RecordatorioSMS _recordarPorSMS = this.recordarPorSMS();
    final Procedure1<Object> _function_3 = new Procedure1<Object>() {
      public void apply(final Object it) {
        DSL.this.setNumeroDeDestinoSMS(it, 123);
      }
    };
    Recordatorio _spaceship_2 = this.operator_spaceship(_recordarPorSMS, _function_3);
    Evento _doubleGreaterThan_2 = this.operator_doubleGreaterThan(_tripleGreaterThan, _spaceship_2);
    this.operator_mappedTo(_mappedTo_1, _doubleGreaterThan_2);
    agenda.tick(7, listener2);
    List<String> _notificaciones = listener2.getNotificaciones();
    final Procedure1<String> _function_4 = new Procedure1<String>() {
      public void apply(final String each) {
        System.out.println(each);
      }
    };
    IterableExtensions.<String>forEach(_notificaciones, _function_4);
    System.out.println("\n");
    agenda.tick(9, listener3);
    List<String> _notificaciones_1 = listener3.getNotificaciones();
    final Procedure1<String> _function_5 = new Procedure1<String>() {
      public void apply(final String each) {
        System.out.println(each);
      }
    };
    IterableExtensions.<String>forEach(_notificaciones_1, _function_5);
    System.out.println("\n");
    agenda.tick(10, listener);
    List<String> _notificaciones_2 = listener.getNotificaciones();
    final Procedure1<String> _function_6 = new Procedure1<String>() {
      public void apply(final String each) {
        System.out.println(each);
      }
    };
    IterableExtensions.<String>forEach(_notificaciones_2, _function_6);
  }
  
  public static void main(final String[] args) {
    DSL _dSL = new DSL();
    _dSL.run();
  }
  
  public Recordatorio operator_spaceship(final Recordatorio r, final Procedure1<Object> f) {
    if (r instanceof RecordatorioEmail
         && f != null) {
      return _operator_spaceship((RecordatorioEmail)r, f);
    } else if (r instanceof RecordatorioLlamada
         && f != null) {
      return _operator_spaceship((RecordatorioLlamada)r, f);
    } else if (r instanceof RecordatorioSMS
         && f != null) {
      return _operator_spaceship((RecordatorioSMS)r, f);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(r, f).toString());
    }
  }
}
