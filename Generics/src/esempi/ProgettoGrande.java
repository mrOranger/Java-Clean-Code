package esempi;

public class ProgettoGrande<T extends Dipendente, K extends Dirigente> {
	
	private T risorsa;
	private K coordinatore;
	
	public void assegnaRisorsa(T risorsa) {
		this.risorsa = risorsa;
	}
	
	public void assengaCoordinatore(K coordinatore) {
		this.coordinatore = coordinatore;
	}
	
	public void avviaAttivita() {
		System.out.println("Attività avviata con la risorsa: " + this.risorsa.getClass().getName() +
				" ed il coordinatore: " + this.coordinatore.getClass().getName());
	}
}
