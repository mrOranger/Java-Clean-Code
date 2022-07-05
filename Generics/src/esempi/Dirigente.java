package esempi;

public class Dirigente extends Dipendente{
	
	protected String grado;
	
	public Dirigente(String nome, String cognome, String livello, String grado) {
		super(nome, cognome, livello);
		this.grado = grado;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}
	
	@Override
	public String toString() {
		return "Dirigente: " + super.toString() + " grado: " + this.getGrado();
	}

}
