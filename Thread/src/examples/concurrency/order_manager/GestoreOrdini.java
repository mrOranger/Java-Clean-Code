package examples.concurrency.order_manager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class GestoreOrdini {
	
	private ConcurrentHashMap<String, List<Ordine>> mappaOrdini;
	private LongAdder numeroOrdini;
	
	public GestoreOrdini() {
		this.mappaOrdini = new ConcurrentHashMap<>();
		this.numeroOrdini = new LongAdder();
	}
	
	public void aggiungiOrdine(Ordine nuovoOrdine) {
		/* 
		 * Distinguiamo tra ordine già presente nella mappa
		 * ed un ordine nuovo da aggiungere.
		 */
		if(!this.mappaOrdini.contains(nuovoOrdine.getId())) {
			List<Ordine> nuoviOrdini = new ArrayList<>();
			nuoviOrdini.add(nuovoOrdine);
			this.mappaOrdini.put(nuovoOrdine.getId(), nuoviOrdini);
		} else {
			this.mappaOrdini.get(nuovoOrdine.getId()).add(nuovoOrdine);
		}
	}
	
	public void stampaOrdini() {
		this.mappaOrdini.entrySet().stream().forEach(e -> {
			System.out.println("Venditore: " + e.getKey());
			e.getValue().forEach(System.out::println);
			System.out.println();
		});
	}
	
	public void incrementaOrdine() {
		this.numeroOrdini.increment();
	}
	
	public long ordiniElaborati() {
		return this.numeroOrdini.longValue();
	}

}
