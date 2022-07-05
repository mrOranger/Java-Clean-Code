package esempi;


public class Impiegato extends Dipendente implements Comparable<Impiegato>{
	
	private String ruolo;
	
	public Impiegato(String nome, String cognome, String livello, String ruolo) {
		super(nome, cognome, livello);
		this.ruolo = ruolo;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	@Override
	public String toString() {
		return "Impiegato: " + super.toString() + " ruolo: " + this.getRuolo();
	}

	@Override
	public int compareTo(Impiegato o) {
		return o.getNome().compareTo(this.getNome());
	}

}
