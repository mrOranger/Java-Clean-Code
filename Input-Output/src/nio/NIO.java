package nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class NIO {

	/*
	 * Il package nio fornisce una serie di metodi che facilitano la manipolazione dei
	 * files rispetto alla precedente versione di io.
	 * Una notevole novità è introdotta dalle classi Path e Files.
	 */
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Insersci cosa scrivere : ");
		String daScrivere = scanner.nextLine();
		
		try {
			NIO.scrivi(daScrivere, "prova-nio.dat");
			String letto = NIO.leggi("prova-nio.dat");
			System.out.println("Letto: " + letto);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
	}
	
	/*
	 * La classe Files contiene anche un metodo factory
	 * che restituisce un BufferedReader o un BufferedWriter,
	 * evitando tutta la dichiarazione dell'oggetto.
	 */
	
	public static String leggi(String nomeFile) throws IOException {
		BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(nomeFile));
		String letto = bufferedReader.readLine();
		bufferedReader.close();
		return letto;
	}
	
	public static void scrivi(String daScrivere, String nomeFile) throws IOException {
		BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(nomeFile));
		bufferedWriter.write(daScrivere);
		bufferedWriter.close();
	}
	
}
