package gestione.biblioteca.prestito;

import gestione.biblioteca.prestito.base.Opera;

public class Studente {
	
	private String nome;
	private String cognome;
	
	private Opera opera1;
	private Opera opera2;
	
	private static final byte MAX_PRESTITI = 2;
	
	public Studente(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
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
	
	private byte numeroPrestiti() {
		byte prestiti = 0;
		if(this.opera1 != null) {
			prestiti++;
		}else if(this.opera2 != null) {
			prestiti++;
		}
		return prestiti;
	}
	
	public boolean prestitiDisponibili() {
		return this.numeroPrestiti() < MAX_PRESTITI;
	}
	
	public boolean registraPrestito(Opera daRegistrare) {
		if(!this.prestitiDisponibili()) {
			return false;
		}
		if(this.opera1 == null) {
			this.opera1 = daRegistrare;
		} else if (this.opera2 == null) {
			this.opera2 = daRegistrare;
		} else {
			return false;
		}
		return true;
	}
	
	public boolean restituisciPrestito(Opera daRestituire) {
		if(this.opera1 == daRestituire) {
			this.opera1 = null;
		} else if (this.opera2 == daRestituire) {
			this.opera2 = null;
		} else {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		switch(this.numeroPrestiti()) {
			case 0: 
				return this.getNome() + " non ha libri in prestito.";
			case 1:
				return this.getNome() + "  ha un libro in prestito.";
				
			default: 
				return this.getNome() + " ha due libri in prestito.";
		}
	}
}
