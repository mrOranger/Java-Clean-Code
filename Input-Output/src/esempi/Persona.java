package esempi;

import java.io.Serializable;

public class Persona implements Serializable{
	
	private String nome;
	private String cognome;
	private int eta;
	private transient String citta; //Guarantees that the object is not serialized
	
	public Persona(String nome, String cognome, int eta, String citta) {
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

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
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
		return this.nome + "-" + this.cognome + "-" + this.eta + "-" + this.citta;
	}

}
