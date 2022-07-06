package esempi.dati;

public class Studente extends Persona{
	
	private String matricola;
	
	public Studente(String nome, String cognome, String matricola) {
		super(nome, cognome);
		this.matricola = matricola;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	@Override
	public int compareTo(Persona p) {
		Studente stud = (Studente)p;
		return this.getMatricola().compareTo(stud.getMatricola());
	}
	
	@Override
	public String toString() {
		return "Studente: " + super.toString() + " mat. " + this.getMatricola();
	}

}
