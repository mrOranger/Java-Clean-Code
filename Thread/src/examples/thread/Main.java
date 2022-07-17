package examples.thread;

public class Main {
	
	/*
	 * Il modo principale in Java per definire un Thread è tramite
	 * l'estensine della classe Thread, e l'implementazione del metodo astratto
	 * run(). 
	 */
	public static void main(String[] args) {
		new Thread1(1).start();
		new Thread2(2).start();
	}

}
