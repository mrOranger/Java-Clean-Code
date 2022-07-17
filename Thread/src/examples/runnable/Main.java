package examples.runnable;

/*
 * Il secondo modo con cui è possibile creare un Thread è tramite l'implementazione
 * dell'interfaccia Runnable. Diversamente dalla prima soluzione però, 
 * non è possibile accedere ai metodi come getName(), getId() ...
 * ed inoltre, per eseguire il Thread deve essere necessariamente inserito all'interno
 * di una classe Thread.
 */
public class Main {
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable1(1));
		Thread thread2 = new Thread(new Runnable2(2));
		
		thread1.start();
		thread2.start();
	}
	
}
