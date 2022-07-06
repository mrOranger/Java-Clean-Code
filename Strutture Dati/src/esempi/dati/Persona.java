package esempi.dati;

public class Persona implements Comparable<Persona>{
	
	private String nome;
	private String cognome;
	
	public Persona(String nome, String cognome) {
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
	
	@Override
	public String toString() {
		return this.cognome + " " + this.nome;
	}

	@Override
	public int compareTo(Persona o) {
		return this.getCognome().compareTo(o.getCognome());
	}

}
