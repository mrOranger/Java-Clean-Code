package examples.runnable;

public class Runnable2 implements Runnable{
	
	private int numero;
	
	public Runnable2(int numero) {
		this.numero = numero;
	}

	@Override
	public void run() {
		System.out.println("Avviato thread Runnable2");
		System.out.println("Numero " + this.numero);
		System.out.println("Uscita dal thread \n");
	}
}
