package javafx.esercizio_reparti;

import java.util.ArrayList;
import java.util.Collection;

public class Dirigente extends Persona implements Comparable<Dirigente>{
	
	private Collection<Impiegato> responsabilità;
	private String matricola;
	
	public Dirigente(String nome, String cognome, String matricola) {
		super(nome, cognome);
		this.matricola = matricola;
		this.responsabilità = new ArrayList<Impiegato>();
	}
	
	public Dirigente(String nome, String cognome, String matricola, Collection<Impiegato> responsabilità) {
		super(nome, cognome);
		this.matricola = matricola;
		this.responsabilità = responsabilità;
	}

	public Collection<Impiegato> getResponsabilità() {
		return responsabilità;
	}

	public void setResponsabilità(Collection<Impiegato> responsabilità) {
		this.responsabilità = responsabilità;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Dirigente: " + super.toString() + " mat." + this.getMatricola());
		for(Impiegato impiegato : this.getResponsabilità()) {
			stringBuilder.append(impiegato);
		}
		return stringBuilder.toString();
	}

	@Override
	public int compareTo(Dirigente o) {
		return this.matricola.compareTo(o.getMatricola());
	}
}
