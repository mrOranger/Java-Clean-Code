package examples.selezioneCandidati;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SelezioneCandidati {
	
	private byte neoAssunti;
	private byte totaleRilevazioni;
	
	public void stampaRilevazioni() {
		System.out.println("Neo-assunti: " + this.neoAssunti);
		System.out.println("Totale rilevazioni: " + this.totaleRilevazioni);
	}
	
	/*
	 * Possiamo fare uso delle interfacce funzionali, per implementare 
	 * le funzioni che la classe SelezioneCandidati può esporre. In questa maniera:
	 */
	
	public void selezionaCandidato(Candidato candidato, Predicate<Candidato> verifica) {
		/*
		 * Se il candidato ha superato la verifica, allora si considera come assunto.
		 * Da notare che non sappiamo ancora quale sarà l'esito del test,
		 * chi si occupa della verifica è un Predicate che verrà passato a run-time.
		 */
		
		if(verifica.test(candidato)) {
			this.neoAssunti++;
			System.out.println("Il candidato è stato assunto!");
		}else {
			System.out.println("Il candidato è stato respinto!");
		}
		System.out.println(candidato);
	}
	
	/*
	 * In maniera simile, non sappiamo cosa la statistica faccia effettivamente,
	 * sappiamo solamente che restituirà un valore.
	 */
	public void statisticaCandidato(Candidato candidato, Function<Candidato, Integer> funzione) {
		totaleRilevazioni += funzione.apply(candidato);
	}
	
	/*
	 * Il metodo che si occupa della simulazione dell'esame è composto dal candidato,
	 * che deve sottoporsi all'esame, del generatore dell'esame che genera un esame
	 * e del consumero che modifica l'esame svolto dal candidato.
	 */
	public void esame(Candidato candidato, Supplier<SchedaEsame> generatoreEsame, Consumer<Candidato> correttoreEsame) {
		SchedaEsame esame = generatoreEsame.get();
		System.out.println("Il candidato svolgerà \n: " + esame);
		correttoreEsame.accept(candidato);
	}
}
