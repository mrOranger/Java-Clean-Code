package esempi;

public class Cliente extends Persona{
	
	private String ragioneSociale;
	
	public Cliente(String nome, String cognome, String ragioneSociale) {
		super(nome, cognome);
		this.ragioneSociale = ragioneSociale;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	
	@Override
	public String toString() {
		return "Cliente: " + super.toString() + " ragione sociale: " + this.getRagioneSociale();
	}

}
