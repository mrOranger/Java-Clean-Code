package esempi;

import java.util.Comparator;

public class ComparatoreImpiegati implements Comparator<Impiegato>{

	@Override
	public int compare(Impiegato o1, Impiegato o2) {
		return o1.compareTo(o2);
	}

}
