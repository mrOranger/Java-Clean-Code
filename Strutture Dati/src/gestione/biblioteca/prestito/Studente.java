package gestione.biblioteca.prestito;

import java.util.HashMap;
import java.util.Map;

import gestione.biblioteca.prestito.base.OperaPrestabile;
import gestione.biblioteca.prestito.eccezioni.PrestitoNonEseguibileException;

public class Studente {
	
	private String nome;
	private String cognome;
	
	private Map<OperaPrestabile, Prestito> prestitiInCorso;

	
	public Studente(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		this.prestitiInCorso = new HashMap<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	private int numeroPrestiti() {
		return this.prestitiInCorso.size();
	}
	
	public boolean prestitiDisponibili() {
		return this.numeroPrestiti() < Biblioteca.MAX_PRESTITI;
	}
	
	public void registraPrestito(OperaPrestabile daRegistrare) throws PrestitoNonEseguibileException{
		if(!this.prestitiDisponibili()) {
			throw new PrestitoNonEseguibileException(daRegistrare);
		}else {
			/* L'utente ha la possibilità di eseguire un prestito */
			Prestito nuovoPrestito = new Prestito(this, daRegistrare);
			prestitiInCorso.put(daRegistrare, nuovoPrestito);
		}
	}
	
	public Prestito restituisciPrestito(OperaPrestabile daRestituire) {
		return this.prestitiInCorso.remove(daRestituire);
	}
	
	public String situazionePrestiti() {
		String str = "Studente: " + this.getCognome() + " " + this.getNome() + '\n';
		for(OperaPrestabile opera : this.prestitiInCorso.keySet()) {
			str += opera.toString() + '\n';
		}
		return str;
	}
	
	@Override
	public String toString() {
		return "Studente: " + this.getCognome() + " " + this.getNome();
	}
}
