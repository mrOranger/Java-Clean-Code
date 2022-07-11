package gestione.biblioteca.prestito;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import gestione.biblioteca.prestito.base.OperaPrestabile;
import gestione.biblioteca.prestito.eccezioni.DataNonValidaException;
import gestione.biblioteca.prestito.eccezioni.NomeNonValidoException;
import gestione.biblioteca.prestito.eccezioni.PrestitoNonEseguibileException;

public class Studente {
	
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private static final String FORMATO = "[A-Z][a-z]+(\\s[A-Z][a-z]+)*";
	
	private Map<OperaPrestabile, Prestito> prestitiInCorso;

	
	public Studente(String nome, String cognome, LocalDate dataNascita) throws NomeNonValidoException, DataNonValidaException {
		
		this.verificaParametro(nome);
		this.verificaParametro(cognome);
		this.verificaData(dataNascita);
		
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
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
	
	public void verificaParametro(String parametro) throws NomeNonValidoException{
		if(!parametro.matches(FORMATO)) {
			throw new NomeNonValidoException("Il formato del nome non è valido!");
		}
	}
	
	public void verificaData(LocalDate nascita) throws DataNonValidaException{
		if(nascita == null || ChronoUnit.YEARS.between(nascita, LocalDate.now()) < 18) {
			throw new DataNonValidaException("Lo studente è minorenne!");
		}
	}
	
	@Override
	public String toString() {
		return "Studente: " + this.getCognome() + " " + this.getNome() + " nato il: " + DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(this.dataNascita);
	}
}
