package esempi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;

public class LetturaFile {

	/* 
	 * La lettura e la scrittura da file di testo comporta l'uso degli streams,
	 * flussi di bytes che non devono essere confusi con gli Stream API.
	 * Per la lettura di file testuale useremo le classi che finiscono con Reader e Writer:
	 * FileReader e FileWriter per leggere un file testuale.
	 * Per la lettura di file di byte useremo le classi che finiscono con Stream, quindi
	 * InputStream e OutputStream.
	 */
	
	public static void main(String[] args) {
		
		String path = "." + File.separator + "src" + File.separator + "esempi" + File.separator + "persona.txt";
		
		int start = LocalTime.now().getNano();
		leggiFileBuffered(path);
		int end = LocalTime.now().getNano();
		System.out.println("Tempo impiegato: " + (end - start));
		System.out.println("");
		leggiFileBuffered2(path);
		System.out.println("");
		start = LocalTime.now().getNano();
		leggiFile(path);
		end = LocalTime.now().getNano();
		System.out.println("Tempo impiegato: " + (end - start));
		System.exit(0);
	}
	
	public static void leggiFileBuffered(String path) {
		File sorgente = new File(path);
		
		try {
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(sorgente));
			String rigaFile = null;
			while((rigaFile = bufferedReader.readLine()) != null) {
				// Leggiamo il file riga per riga finchè non si legge più nulla
				System.out.println(rigaFile);
			}
			bufferedReader.close(); // Chiusura stream!
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void leggiFileBuffered2(String path) {
		
		/*
		 * Potremmo semplificare il codice usando il try-with-resources,
		 * una variante del try catch creato per le classi che implementano l'interfaccia
		 * AutoCloseable, ossia che richiedono la chiusura del flusso di lettura.
		 */
		File sorgente = new File(path);
		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(sorgente));) {
			String rigaFile = null;
			while((rigaFile = bufferedReader.readLine()) != null) {
				// Leggiamo il file riga per riga finchè non si legge più nulla
				System.out.println(rigaFile);
			}
			// bufferedReader.close() ... La chiusura viene fatta in automatico
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
	
	public static void leggiFile(String path) {
		File sorgente = new File(path);
		
		try {
			// Leggiamo il file usando un flusso di bytes
			FileReader reader = new FileReader(sorgente);
			int charLetto = reader.read();
			while(charLetto != - 1) {
				System.out.print((char)charLetto);
				charLetto = reader.read();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
