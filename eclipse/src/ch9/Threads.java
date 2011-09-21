package ch9;

/**
 * - watki startujemy **ZAWSZE** z obiektu Thread przez uzycie start(); 
 * 
 * @author marioosh
 *
 */
public class Threads {
	
	public static void main(String[] args) {
		
		/**
		 * 1 spos�b (extends Thread)
		 */
		MyThread t = new MyThread();
		t.start(); // startujemy w�tek
		
		/**
		 * 2 spos�b (implements Runnable)
		 */
		MyThreadByRunnable t2 = new MyThreadByRunnable();
		new Thread(t2).start(); // startujemy w�tek
		
		/**
		 * mo�na te� tak, bo Thread implements Runnable
		 */
		Thread t3 = new Thread(new MyThread());
		t3.start();
		
		/**
		 * UWAGA
		 */
		t.run(); // metoda si� wykona, ale nie wystartuje w�tku !!!
	}
}
