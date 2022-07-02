package com.edo.variables;

public class Main {
	
	/**
	 * Java contiene al suo interno 8 tipi di dati primitivi, 
	 * categorizzati in:
	 * - Numerici: 6.
	 * - Caratteri: 1.
	 * - Valori Booleani: 1.
	 */
	
	public static void main(String[] args) {
		numeriInteri();
		numeriConVirgola();
		System.exit(-1);
	}
	
	public static void numeriInteri() {
		/**
		 * A loro volta, i tipi primitivi numerici si dividono in:
		 * - 4 tipi interi.
		 * - 2 tipi con virgola mobile.
		 */
		
		// Tipi primitivi interi
		byte interoByte = 0; // 1 byte -> 8 bit
		short interoShort = 100; // 2 byte -> 16 bit
		int interoInt = 1000000; // 4 byte -> 32 bit
		long interoLong = 1000000000; // 8 byte -> 64 bit
		
		/**
		 * !Best practice!
		 * Spesso si tende a dichiarare una variabile intero sempre come int,
		 * è meglio decidere a propri quanto spazio è necessario per quella variabile,
		 * e quindi scegliere il tipo di dato più adatto.
		 */
		
		System.out.println("Un byte va da -128 a 127");
		System.out.println("Un short va da -32,768 a 32,767");
		System.out.println("Un int va da -2,147,483,648 a 2,147,483,647");
		System.out.println("Un long va da -2e63 a 2e63 - 1 ");
	}
	
	public static void numeriConVirgola() {
		/**
		 * I numeri in virgola mobile si divono in:
		 * - float: standard IEEE 754 con singola precisione 4 byte -> 32 bit.
		 * - double: standard IEEE 754 con doppia precisione 8 byte -> 64 bit.
		 */
		
		float virgolaFloat = 10;
		double virgolaDouble = 20;
		
		/**
		 * Spesso assegnamo a delle variabili dei numeri che non vanno bene, 
		 * ad esempio:
		 */
		
		byte eta1 = 16;
		byte eta2 = 15;
		float media = (eta1 + eta2)/2;
		
		System.out.println("La media di 16 e 15 è " + media); // 15!
		
		/**
		 * In questo caso la stampa è errata, e l'errore è dovuto al fatto che
		 * stiamo assegnando ad una variabile float in tipo int!
		 * Questo accade perchè la divisione tra i due numeri è fatta con un 
		 * tipo int. Per fare in modo che invece sia trattata come un float, 
		 * è necessario introdurre il litteral f, che indica al compilatore
		 * che il numero in questione è un float.
		 */
		
		float nuovaMedia = (eta1 + eta2)/2f;
		
		System.out.println("La corretta media di 16 e 15 è " + nuovaMedia); // 15.5!
	}
}
