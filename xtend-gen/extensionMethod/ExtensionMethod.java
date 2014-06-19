package extensionMethod;

import classes.Agenda;
import classes.Evento;
import classes.Listener;
import classes.Recordatorio;
import classes.RecordatorioEmail;
import classes.RecordatorioLlamada;
import classes.RecordatorioSMS;
import java.util.ArrayList;
import java.util.Arrays;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ExtensionMethod {
  public Object ExtensionMethod() {
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
  
  public RecordatorioLlamada recordarPorLlamada(final Procedure1<? super RecordatorioLlamada> f) {
    RecordatorioLlamada _recordatorioLlamada = new RecordatorioLlamada();
    return ObjectExtensions.<RecordatorioLlamada>operator_doubleArrow(_recordatorioLlamada, f);
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
  
  public void setSubjectYEmail(final Object object, final String destinatario, final String subject) {
    final RecordatorioEmail recordatorioEmail = ((RecordatorioEmail) object);
    recordatorioEmail.setSubject(subject);
    recordatorioEmail.setEmailDestino(destinatario);
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
