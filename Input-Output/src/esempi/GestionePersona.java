package esempi;

import java.util.List;

public class GestionePersona {
	
	private static final List<String> NOMI = List.of("Mario", "Marco", "Francesca", "Maria");
	private static final List<String> COGNOMI = List.of("Rossi", "Gialli", "Neri", "Verdi");
	private static final List<String> CITTA = List.of("Milano", "Roma", "Napoli", "Brescia");
	
	public static Persona getPersona() {
		return new Persona(NOMI.get((int)(Math.random()*NOMI.size())), COGNOMI.get((int)(Math.random()*COGNOMI.size())), (int)(Math.random()*90), CITTA.get((int)(Math.random()*CITTA.size())));
	}
}
