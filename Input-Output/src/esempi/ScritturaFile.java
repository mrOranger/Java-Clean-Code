package esempi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Scriviamo un programma che salvi all'interno di un file di testo 100 persone,
 * rappresentate dalla classe Persona.
 * Implementiamo i due metodi per il salvataggio, rispettivamente facenti uso di
 * BufferedWriter e FileWriter. 
 */
public class ScritturaFile {
	
	public static void main(String[] args) {
		scriviFile("prova.txt");
		scriviFileBuffered("prova-buffered.txt");
	}
	
	
	public static void scriviFile(String path) {
		try (FileWriter fileWriter = new FileWriter(path)){
			for(int i = 0; i < 100; i++) {
				fileWriter.write(GestionePersona.getPersona().toString());
				fileWriter.write('\n'); //Write a new line
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void scriviFileBuffered(String path) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
			for(int i = 0; i < 100; i++) {
				bufferedWriter.write(GestionePersona.getPersona().toString());
				bufferedWriter.newLine(); // Stampa una nuova linea
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
