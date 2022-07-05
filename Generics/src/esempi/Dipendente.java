package esempi;

public abstract class Dipendente extends Persona{
	
	protected String livello;
	
	public Dipendente(String nome, String cognome, String livello) {
		super(nome, cognome);
		this.livello = livello;
	}

	public String getLivello() {
		return livello;
	}

	public void setLivello(String livello) {
		this.livello = livello;
	}
	
	@Override
	public String toString() {
		return super.toString() + " livello: " + this.getLivello();
	}

}
