package examples.concurrency.data_structures;

import java.util.List;

public class Thread1 implements Runnable{
	
	private List<Integer> lista;
	
	public Thread1(List<Integer> lista) {
		this.lista = lista;
	}

	@Override
	public void run() {
		this.lista.forEach((i) ->{
			System.out.println("Thread #." + Thread.currentThread().getId() + " stampa " + i++);
		});
	}
}
