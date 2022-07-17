package examples.concurrency.executorService;

public class ThreadEseguibile implements Runnable{
	
	private String nome;
	
	public ThreadEseguibile(String nome) {
		this.nome = nome;
	}

	@Override
	public void run() {
		for(int i = 0; i < 5; i++)
			System.out.println("Eseguo thread " + this.nome);
	}

}
