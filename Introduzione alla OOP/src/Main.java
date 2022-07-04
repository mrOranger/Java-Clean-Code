
/**
 * Vogliamo creare un gestionale che permetta di gestire gli impegati e gli amministratori di 
 * un'impresa.
 * - Ogni utente possiede un username ed una password, la seconda deve essere necessariamente
 *   di almeno 10 caratteri.
 * - Ad ogni utente viene attribuito un livello a scelta tra "amministratore" e "standard".
 * - Lo username sarà composto da un prefisso che varierà in base alla tipologia
 *   dell'utente "user_" per gli utenti e "admin_" per gli amministratori e
 *   da un numero progressivo che parte da 0.
 * - Un utente può temporaneamente essere sospeso.
 * - Sarà disponibile anche il metodo per la stampa aggiornata di tutti gli aspetti dell'oggetto.
 * @author Edoardo
 *
 */
public class Main {
	
	public static void main(String[] args) {
		Utente pippo = new Utente(Livello.UTENTE);
		pippo.setPassword("abcd123456");
		pippo.reintegraUtente();
		pippo.stampaDescrizione();
		
		Utente pluto = new Utente(Livello.AMMINISTRATORE);
		pluto.setPassword("asads");
		pluto.sospendiUtente();
		pluto.stampaDescrizione();
	}

}
