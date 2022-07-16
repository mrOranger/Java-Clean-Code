package backup;

import java.util.List;

public class PersonGenerator {
	
	private static final List<String> NOMI = List.of("Mario", "Maria", "Francesco", "Giuseppina");
	private static final List<String> COGNOMI = List.of("Rossi", "Verdi", "Neri", "Bianchi");
	private static final List<String> CITTA = List.of("Bari", "Milano", "Roma", "Napoli");
	
	public static Persona creaPersona() {
		return new Persona(getRandomString(NOMI), getRandomString(COGNOMI), getRandomAge(), getRandomString(CITTA));
	}
	
	public static String getRandomString(List<String> field) {
		return field.get((int)(Math.random()*field.size()));
	}
	
	public static int getRandomAge() {
		return (int)(Math.random()*100);
	}
}
