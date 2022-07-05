package esempi;

public class DirigenteCapo extends Dirigente{
	
	private double stipendio;
	
	public DirigenteCapo(String nome, String cognome, String livello, String grado, double stipendio) {
		super(nome, cognome, livello, grado);
		this.stipendio = stipendio;
	}

	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
	
	@Override
	public String toString() {
		return "Dirigente capo: " + super.toString() + " stipendio: " + this.getStipendio();
	}

}
