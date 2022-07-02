package com.edo.oop;

public class Main {
	public static void main(String[] args) {
		Utente amministratore = new Utente(LivelloUtente.AMMINISTRATORE);
		Utente utente = new Utente(LivelloUtente.STANDARD);
		
		amministratore.setPassword("ABCD1234512");
		
		utente.sospendiUtente();
		amministratore.riattivaUtente();
		
		amministratore.stampaDescrizioneUtente();
		utente.stampaDescrizioneUtente();
	}
}
