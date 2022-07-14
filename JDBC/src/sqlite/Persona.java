package sqlite;

public class Persona {
	
	private String nome;
	private String cognome;
	private byte eta;
	private String citta;
	
	public Persona(String nome, String cognome, byte eta, String citta) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.citta = citta;
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

	public byte getEta() {
		return eta;
	}

	public void setEta(byte eta) {
		this.eta = eta;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	@Override
	public String toString() {
		return this.getNome() + " " + this.getCognome() + " - " + this.getEta() + " anni, vive a " + this.getCitta();
	}

}
