package com.edo.oop;

/**
 * Immaginiamo una classe Utente per un gestionale di sistemi informatici.
 * - Ogni utente possiede un username ed una password
 * - Ad ogni utente deve essere attribuito il livello a scelta di 
 *   "amministratore" e "standard".
 * - Lo username sarà costituito da un prefisso che indica il livello,
 *   ed un identificativo univoco "admin_0", "user_1".
 * - Un utente può essere temporaneamente sospeso.
 * - Deve essere resa disponibile una stampa aggiornata di tutti gli aspetti
 *   dell'oggetto.
 */

public class Utente {
	
	/*
	 * Definiamo le caratteristiche dell'utente come VARIABILI DI ISTANZA,
	 * che saranno mutevoli per ogni istanza dell'utente che andremo a creare.
	 */
	private String username;
	private String password;
	private boolean sospeso;
	private LivelloUtente livelloUtente;
	
	/*
	 * Le informazioni condivise tra gli utenti, sono dichiarate invece come
	 * VARIABILI DI CLASSE, per permettere una migliore ottimizzazione della 
	 * memoria. 
	 */
	private static final String PREFISSO_UTENTE = "user_";
	private static final String PREFISSO_AMMINISTRTORE = "admin_";

	private static byte NUMERO_UTENTE = 1;
	
	public Utente(LivelloUtente livelloUtente) {
		this.livelloUtente = livelloUtente;
		
		if(livelloUtente == LivelloUtente.AMMINISTRATORE) {
			this.generaAmministratore();
		}else {
			this.generaUtente();
		}
	}
	
	private void generaAmministratore() {
		this.username = Utente.PREFISSO_AMMINISTRTORE + (Utente.NUMERO_UTENTE++);
	}
	
	private void generaUtente() {
		this.username = Utente.PREFISSO_UTENTE + (Utente.NUMERO_UTENTE++);
	}
	
	public void setPassword(String password) {
		if(password.length() < 10) {
			System.out.println("La password non può contenere meno di 10 caratteri!");
		}
		this.password = password;
	}
	
	public void sospendiUtente() {
		this.sospeso = true;
	}
	
	public void riattivaUtente() {
		this.sospeso = false;
	}
	
	public void stampaDescrizioneUtente() {
		System.out.println("\nUtente: " + this.username);
		String livello = switch(livelloUtente) {
			case AMMINISTRATORE -> { 
				yield "Livello: amministratore";
			}
			case STANDARD -> { 
				yield "Livello: utente"; 
			}
		};
		System.out.println(livello);
		if(password == null) {
			System.out.println("Password: undefined");
		}else {
			System.out.println("Password: OK");
		}
		System.out.println("Sospeso: " + ((this.sospeso) ? "Si" : "No"));
	}
}
