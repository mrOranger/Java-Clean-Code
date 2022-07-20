package examples.concurrency.order_manager;

public class Ordine {
	
	private String id;
	private double prezzo;
	
	public Ordine(String id, double prezzo) {
		this.id = id;
		this.prezzo = prezzo;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "ID: " + this.getId() + " - Prezzo: " + this.getPrezzo();
	}
}
