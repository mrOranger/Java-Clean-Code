package esempi.dati;

import java.util.Comparator;

public class ComparatorPersona implements Comparator<Persona>{

	/* Implementiamo l'ordinamento per lunghezza */
	@Override
	public int compare(Persona o1, Persona o2) {
		return o1.getCognome().length() - o2.getCognome().length();
	}

}
