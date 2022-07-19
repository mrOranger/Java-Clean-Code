package examples.concurrency.callable_future;

public class Data {
	
	private int totale;
	private int citta;
	
	public Data() {
		this.totale = 0;
		this.citta = 0;
	}
	
	public int getTotale() {
		return totale;
	}
	
	public void setTotale(int totale) {
		this.totale = totale;
	}
	
	public int getCitta() {
		return citta;
	}
	
	public void setCitta(int citta) {
		this.citta = citta;
	}
	
	@Override
	public String toString() {
		return "Citta: " + this.citta + " - Totale: " + this.totale;
	}
}
