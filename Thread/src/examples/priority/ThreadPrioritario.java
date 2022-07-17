package examples.priority;

public class ThreadPrioritario extends Thread{
	
	private int priorità;
	private String nome;
	
	public ThreadPrioritario(int priorità, String nome) {
		this.priorità = priorità;
		this.nome = nome;
		this.setPriority(this.priorità);
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 5; i++)
			System.out.println("Esecuzione thread " + this.nome);
	}
}
