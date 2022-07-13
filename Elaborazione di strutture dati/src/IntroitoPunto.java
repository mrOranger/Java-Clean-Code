
public class IntroitoPunto {
	
	private String codice;
	private double importo;
	
	public IntroitoPunto(String codice, double importo) {
		this.codice = codice;
		this.importo = importo;
	}
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	
	@Override
	public String toString() {
		return new StringBuilder("Punto vendita: " + this.getCodice() + " - " + this.getImporto() + "$").toString();
	}
}
