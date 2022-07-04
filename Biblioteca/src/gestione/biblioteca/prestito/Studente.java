package gestione.biblioteca.prestito;

import gestione.biblioteca.prestito.base.Opera;
import gestione.biblioteca.prestito.base.Persona;

public class Studente extends Persona {
	
	private String matricola;
	
	/* Usiamo l'uppercasting visto che un'opera può essere un CD o un Libro */
	private Opera prestito1;
	private Opera prestito2;
	
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
	
	private byte numeroPrestiti() {
		byte prestiti = 0; // Rispariamo informazioni in memoria
		if(this.prestito1 != null) {
			prestiti++;
		}
		if(this.prestito2 != null) {
			prestiti++;
		}
		return prestiti;
	}
	
	public boolean prestitiDisponibili() {
		return this.numeroPrestiti() < 2;
	}
	
	public boolean creaPrestito(Opera daPrendere) {
		if(this.prestitiDisponibili()) {
			if(prestito1 == null) {
				this.prestito1 = daPrendere;
			}else {
				this.prestito2 = daPrendere;
			}
			return true;
		}
		return false;
	}
	
	public boolean restituzionePrestito(Opera daRestituire) {
		if(this.prestito1 == daRestituire) {
			this.prestito1 = null;
		}else if(this.prestito2 == daRestituire) {
			this.prestito2 = null;
		}else {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		String prestiti = switch(this.numeroPrestiti()) {
		case 0 -> {
				yield " non ha libro in prestito";
			}
		case 1 -> {
				yield " ha un libro in prestito";
			}
		default -> {
				yield " ha due libri in prestito";
			}
		};
		return super.toString() + " " + prestiti;
	}
	
}
