package DSL;

import classes.Agenda;
import classes.Evento;
import classes.Listener;
import classes.Recordatorio;
import classes.RecordatorioEmail;
import classes.RecordatorioLlamada;
import classes.RecordatorioSMS;
import java.util.ArrayList;
import java.util.List;
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
  
  public Evento operator_tripleGreaterThan(final Evento even, final Procedure1<? super Evento> f) {
    f.apply(even);
    return even;
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
  
  public void run() {
    final Listener listener = this.listener();
    final Agenda agenda = this.crearAgenda();
    Evento _doubleArrow = this.operator_doubleArrow(8, "despertarse");
    RecordatorioSMS _recordarPorSMS = this.recordarPorSMS();
    Evento _doubleGreaterThan = this.operator_doubleGreaterThan(_doubleArrow, _recordarPorSMS);
    Agenda _mappedTo = this.operator_mappedTo(agenda, _doubleGreaterThan);
    Evento _doubleArrow_1 = this.operator_doubleArrow(10, "Ir a la facu");
    Agenda _mappedTo_1 = this.operator_mappedTo(_mappedTo, _doubleArrow_1);
    Evento _doubleArrow_2 = this.operator_doubleArrow(11, "almorzar");
    final Procedure1<Evento> _function = new Procedure1<Evento>() {
      public void apply(final Evento remindMe) {
        remindMe.add("acuerdate tambien de tener Plata");
      }
    };
    Evento _tripleGreaterThan = this.operator_tripleGreaterThan(_doubleArrow_2, _function);
    RecordatorioSMS _recordarPorSMS_1 = this.recordarPorSMS();
    Evento _doubleGreaterThan_1 = this.operator_doubleGreaterThan(_tripleGreaterThan, _recordarPorSMS_1);
    this.operator_mappedTo(_mappedTo_1, _doubleGreaterThan_1);
    agenda.tick(10, listener);
    List<String> _notificaciones = listener.getNotificaciones();
    String _get = _notificaciones.get(0);
    System.out.println(_get);
    List<String> _notificaciones_1 = listener.getNotificaciones();
    String _get_1 = _notificaciones_1.get(1);
    System.out.println(_get_1);
  }
  
  public static void main(final String[] args) {
    DSL _dSL = new DSL();
    _dSL.run();
  }
}
