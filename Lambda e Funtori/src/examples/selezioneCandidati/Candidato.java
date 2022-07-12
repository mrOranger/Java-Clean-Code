package examples.selezioneCandidati;

public class Candidato {

	private Valutazione votoJava;
	private Valutazione votoPhp;
	private Valutazione votoLinux;
	private Valutazione votoInglese;
	public Valutazione getVotoJava() {
		return votoJava;
	}
	public void setVotoJava(Valutazione votoJava) {
		this.votoJava = votoJava;
	}
	public Valutazione getVotoPhp() {
		return votoPhp;
	}
	public void setVotoPhp(Valutazione votoPhp) {
		this.votoPhp = votoPhp;
	}
	public Valutazione getVotoLinux() {
		return votoLinux;
	}
	public void setVotoLinux(Valutazione votoLinux) {
		this.votoLinux = votoLinux;
	}
	public Valutazione getVotoInglese() {
		return votoInglese;
	}
	public void setVotoInglese(Valutazione votoInglese) {
		this.votoInglese = votoInglese;
	}
	
	@Override
	public String toString() {
		
		/* Le stringhe in Java sono immutabili!
		 * Se usassimo la concatenzione su un'unica stringa, 
		 * avremmo uno spreco di memoria perchè genererebbe stringhe diverse.
		 * Usiamo allora lo StringBuilder. */
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Linguaggio Java: " + this.getVotoJava() + '\n');
		stringBuilder.append("Linguaggio Php: " + this.getVotoPhp() + '\n');
		stringBuilder.append("Linux: " + this.getVotoLinux() + '\n');
		stringBuilder.append("Inglese: " + this.getVotoInglese() + '\n');
		return stringBuilder.toString();
	}
}
