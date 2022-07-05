package esempi;

public class Progetto<T extends Dipendente> {
	
	private T risorsa;
	
	public void assegnaRisorsa(T risorsa) {
		this.risorsa = risorsa;
	}
	
	public void avviaAttivita() {
		System.out.println("Attività avviata con la risorsa " + this.risorsa.getClass().getName());
	}

}
