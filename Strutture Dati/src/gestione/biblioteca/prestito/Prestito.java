package gestione.biblioteca.prestito;

import gestione.biblioteca.prestito.base.OperaPrestabile;

public class Prestito {
	
	private Studente studente;
	private OperaPrestabile opera;
	
	public Prestito(Studente studente, OperaPrestabile opera) {
		this.studente = studente;
		this.opera = opera;
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
	
	@Override
	public String toString() {
		return "Opera : " + this.opera.getTitolo() + " - " + this.getStudente().toString();
	}

}
