package esempi;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		Impiegato imp = new Impiegato("Edoardo", "Oranger", "A1", "Sviluppatore");
		DirigenteCapo dirigente = new DirigenteCapo("Marco", "Marci", "C1", "Senior", 2300.0);
		Progetto<Impiegato> progettoSemplice = new Progetto<>();
		progettoSemplice.assegnaRisorsa(imp);
		progettoSemplice.avviaAttivita();
		ProgettoGrande<Impiegato, DirigenteCapo> progettoGrande = new ProgettoGrande<>();
		progettoGrande.assegnaRisorsa(imp);
		progettoGrande.assengaCoordinatore(dirigente);
		progettoGrande.avviaAttivita();
		
		ProgettoGrande<DirigenteCapo, DirigenteCapo> progettoGrande1 = new ProgettoGrande<>();
		progettoGrande1.assegnaRisorsa(dirigente);
		progettoGrande1.assengaCoordinatore(dirigente);
		progettoGrande1.avviaAttivita();
		
		avviaProgetto(progettoGrande);
		avviaProgetto(progettoGrande1);
		
		Impiegato[] impiegati = {
			new Impiegato("Edoardo", "Oranger", "A1", "Sviluppatore"),
			new Impiegato("Mario", "Rossi", "B1", "Progettista"),
			new Impiegato("Marcello", "Bianchi", "A2", "Designer")
		};
		
		/* Stamperanno lo stesso risultato */
		Arrays.sort(impiegati);
		for(Impiegato i : impiegati) {
			System.out.println(i);
		}
		
		Impiegato[] impiegati1 = {
				new Impiegato("Edoardo", "Oranger", "A1", "Sviluppatore"),
				new Impiegato("Mario", "Rossi", "B1", "Progettista"),
				new Impiegato("Marcello", "Bianchi", "A2", "Designer")
			};
		Arrays.sort(impiegati1, new ComparatoreImpiegati());
		
		Arrays.sort(impiegati);
		for(Impiegato i : impiegati) {
			System.out.println(i);
		}
		
	}
	
	public static void avviaProgetto(ProgettoGrande<?, ?> progetto) {
		progetto.avviaAttivita();
	}
	
}
