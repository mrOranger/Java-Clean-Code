package javafx.esercizio_reparti;

public class Impiegato extends Persona implements Comparable<Impiegato>{
	
	private String matricola;
	private Dirigente responsabile;

	public Impiegato(String nome, String cognome, String matricola, Dirigente responsabile) {
		super(nome, cognome);
		this.matricola = matricola;
		this.responsabile = responsabile;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public Dirigente getResponsabile() {
		return responsabile;
	}

	public void setResponsabile(Dirigente responsabile) {
		this.responsabile = responsabile;
	}

	@Override
	public int compareTo(Impiegato o) {
		return o.getMatricola().compareTo(this.getMatricola());
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Impiegato: " + super.toString() + " mat." + this.getMatricola());
		stringBuilder.append("Resonsabile: " + this.getResponsabile().getMatricola());
		return stringBuilder.toString();
	}
}
