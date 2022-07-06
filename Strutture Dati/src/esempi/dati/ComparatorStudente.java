package esempi.dati;

import java.util.Comparator;

public class ComparatorStudente implements Comparator<Studente>{

	@Override
	public int compare(Studente o1, Studente o2) {
		return o1.getMatricola().length() - o2.getMatricola().length();
	}

}
