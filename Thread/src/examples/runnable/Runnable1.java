package examples.runnable;

public class Runnable1 implements Runnable{
	
	private int numero;
	
	public Runnable1(int numero) {
		this.numero = numero;
	}

	@Override
	public void run() {
		System.out.println("Avviato thread Runnable1");
		System.out.println("Numero " + this.numero);
		System.out.println("Uscita dal thread \n");
	}
}
