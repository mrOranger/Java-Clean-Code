package examples.concurrency.callable_future;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.Callable;

public class LeggiFile implements Callable<Data>{
	
	private Data data;
	
	public LeggiFile() {
		this.data = new Data();
	}

	@Override
	public Data call() throws Exception {
		BufferedReader input = new BufferedReader(new FileReader(new File("data.dat")));
		String line;
		while((line = input.readLine()) != null) {
			this.data.setCitta(data.getCitta() + 1);
			int totale = Integer.parseInt(line.split(":")[1]);
			this.data.setTotale(data.getTotale() + totale);
		}
		input.close();
		return data;
	}

}
