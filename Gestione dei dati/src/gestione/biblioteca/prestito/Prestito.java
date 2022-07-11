package gestione.biblioteca.prestito;

import java.time.LocalDate;
import java.time.Period;

import gestione.biblioteca.prestito.base.OperaPrestabile;

public class Prestito {
	
	private Studente studente;
	private OperaPrestabile opera;
	private LocalDate scadenza;
	
	public Prestito(Studente studente, OperaPrestabile opera) {
		this.studente = studente;
		this.opera = opera;
		this.scadenza = opera.scadenzaPrestito();
	}

	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	public OperaPrestabile getOpera() {
		return opera;
	}

	public void setOpera(OperaPrestabile opera) {
		this.opera = opera;
	}
	
	public boolean scaduto() {
		return this.scadenza.isBefore(LocalDate.now());
	}
	
	public int scadeTra() {
		return Period.between(LocalDate.now(), this.scadenza).getDays();
	}
	
	@Override
	public String toString() {
		if(this.scaduto()) {
			return "Opera : " + this.opera.getTitolo() + " - " + this.getStudente().toString() + " già scaduto!";	
		}else {
			return "Opera : " + this.opera.getTitolo() + " scade tra: " + this.scadeTra() + " - " + this.getStudente().toString();
		}
	}
}
