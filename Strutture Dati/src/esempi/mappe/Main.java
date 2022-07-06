package esempi.mappe;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import esempi.dati.Studente;

public class Main {
	
	/**
	 * Fino a questo momento abbiamo visto le strutture dati ereditate da Collection.
	 * Tuttavia, queste strutture dati sono composte brutalmente da una lista di valori,
	 * ordati secondo un criterio e su cui è possibile eseguire una serie di operazioni standard. 
	 * Le Map invece sono strutture dati costituite da un insieme di coppie (Chiave, Valore).
	 * Dall'interfaccia Map abbiamo le seguenti implementazioni:
	 * - HashMap implementa il classico tipo di mappa.
	 * - LinkedHashMap è un'estensione di HashMap in cui tiene conto dell'ordine di inserimento.
	 * - SortedMap è l'interfaccia che definisce una mappa con ordinamento sulle chiavi, da cui 
	 *   nasce TreeMap.
	 */
	public static void main(String[] args) {
		
		Map<String, Studente> hashMap = new HashMap<>();
		Map<String, Studente> linkedHashMap = new LinkedHashMap<>();
		
		popolaMappa(hashMap);
		popolaMappa(linkedHashMap);
		
		/**
		 * HashMap non restituisce i valori nello stesso ordine di inserimento,
		 * in quanto usa un meccanismo interno per l'immagazzinamento diverso.
		 */
		stampaMappa(hashMap);
		stampaMappa(linkedHashMap);
		
		SortedMap<String, Studente> sortedMap = new TreeMap<>();
		popolaMappa(sortedMap);
		stampaMappa(sortedMap);
		
	}
	
	/**
	 * La stampa della mappa avviene necessariamente estraendo l'insieme delle coppie
	 * (Chiave, Valore), definite nella classe con l'oggetto Entry<Chiave, Valore>.
	 */
	public static void stampaMappa(Map<?, ?> map) {
		System.out.println("Stampa di : " + map.getClass().getName());
		for(Entry<?, ?> coppia : map.entrySet()) {
			System.out.println(coppia);
		}
	}
	
	public static void popolaMappa(Map<String, Studente> map) {
		map.put("AB12", new Studente("Mario", "Rossi", "AB12"));
		map.put("AC12", new Studente("Andrea", "Verdi", "AC12"));
		map.put("AD12", new Studente("Francesco", "Gialli", "AD12"));
	}

}
