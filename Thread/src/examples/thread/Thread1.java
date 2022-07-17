package examples.thread;

public class Thread1 extends Thread{
	
	private int numero;
	
	public Thread1(int numero) {
		this.numero = numero;
	}
	
	@Override
	public void run() {
		System.out.println("Avviato thread " + this.getName());
		System.out.println("Con id n." + this.getId());
		System.out.println("Priorità assegnata " + this.getPriority());
		System.out.println("Numero " + this.numero);
		System.out.println("Uscita dal thread " + this.getName() + '\n');
	}
}
