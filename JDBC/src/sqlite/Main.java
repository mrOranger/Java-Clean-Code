package sqlite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Collection<Persona> persone = new ArrayList<>(List.of(
				new Persona("Mario", "Rossi", (byte)45, "Milano"),
				new Persona("Michele", "Bianchi", (byte)23, "Roma"),
				new Persona("Anna", "Verdi", (byte)91, "Brescia"),
				new Persona("Francesca", "Neri", (byte)19, "Catanzaro")
		));
		
		DatabaseConnection dbConnection = new DatabaseConnection();
		dbConnection.inserisciPersone(persone);
		Collection<?> personeDb = dbConnection.getPersone();
		personeDb.stream().forEach(System.out::println);
		dbConnection.chiudiConnessione();
	}

}
