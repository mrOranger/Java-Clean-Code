package examples.selezioneCandidati;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * Create le classi ed i relativi metodi tutto il resto viene implementato nel main,
 * infatti, abbiamo definito la logica ma non abbiamo ancora visto effettivamente cosa faccia.
 */

public class Main {
	
	public static void main(String[] args) {
		SelezioneCandidati selezione = new SelezioneCandidati();
		
		Candidato mario = new Candidato();
		Candidato marco = new Candidato();
		
		/*
		 * Definiamo adesso due schede di esame, una omogenea ed uno per un programmatore
		 */
		
		Supplier<SchedaEsame> esameOmogeneo = () -> {
			SchedaEsame esame = new SchedaEsame();
			esame.setQuizInglese((byte)4);
			esame.setQuizJava((byte)4);
			esame.setQuizLinux((byte)4);
			esame.setQuizPhp((byte)4);
			return esame;
		};
		
		Supplier<SchedaEsame> esameProgrammatore = () -> {
			SchedaEsame esame = new SchedaEsame();
			esame.setQuizInglese((byte)2);
			esame.setQuizJava((byte)6);
			esame.setQuizLinux((byte)2);
			esame.setQuizPhp((byte)6);
			return esame;
		};
		
		Consumer<Candidato> correttoreEsame = (candidato) -> {
			int numeroValutazioni = Valutazione.values().length;
			
			Valutazione java = Valutazione.values()[(int)(Math.random()*numeroValutazioni)];
			Valutazione php = Valutazione.values()[(int)(Math.random()*numeroValutazioni)];
			Valutazione inglese = Valutazione.values()[(int)(Math.random()*numeroValutazioni)];
			Valutazione linux = Valutazione.values()[(int)(Math.random()*numeroValutazioni)];
			
			candidato.setVotoInglese(inglese);
			candidato.setVotoJava(java);
			candidato.setVotoLinux(linux);
			candidato.setVotoPhp(php);
		};
		
		Predicate<Candidato> assunzioneProgrammatore = (candidato) -> {
			return (candidato.getVotoJava() == Valutazione.IDONEO) || 
					(candidato.getVotoPhp() == Valutazione.IDONEO);
		};
		
		Predicate<Candidato> assunzioneSistemista = (candidato) -> {
			return (candidato.getVotoLinux() == Valutazione.IDONEO);
		};
		
		Function<Candidato, Integer> funzioneStatistica = (candidato) -> {
			if(candidato.getVotoJava() == Valutazione.IDONEO || candidato.getVotoPhp() == Valutazione.IDONEO || candidato.getVotoLinux() == Valutazione.IDONEO) {
				return 1;
			}
			return 0;
		};
		
		selezione.esame(marco, esameOmogeneo, correttoreEsame);
		selezione.esame(mario, esameProgrammatore, correttoreEsame);
		
		selezione.selezionaCandidato(marco, assunzioneProgrammatore);
		selezione.selezionaCandidato(marco, assunzioneSistemista);
		selezione.selezionaCandidato(mario, assunzioneSistemista);
		selezione.selezionaCandidato(mario, assunzioneProgrammatore);
		
		selezione.statisticaCandidato(marco, funzioneStatistica);
		selezione.statisticaCandidato(mario, funzioneStatistica);
		selezione.stampaRilevazioni();
	}

}
