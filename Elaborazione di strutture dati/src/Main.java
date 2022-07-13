/*
 * Vogliamo simulare una specie di sistema commerciale, caratterizzato da una serie di punti vendita
 * che comunicano con un sistema centralizzato gli introiti. In particolare vogliamo le seguenti statistiche:
 * - Calcolare il totale complessivo.
 * - Calcolare l'importo medio.
 * - Stampa dei tre introiti più alti in ordine decrescente.
 * - Stampare tutti gli introiti che superno la media in ordine decrescente.
 */

public class Main {
	
	public static void main(String[] args) {
		GestioneIntroiti gestione = new GestioneIntroiti();
		System.out.println("Importo medio: " + gestione.getImportoMedio());
		System.out.println("Importo totale: " + gestione.getTotale());
		gestione.stampaIntroitiAlti();
		System.out.println("");
		gestione.stampaSuperamentoMedia();
	}

}
