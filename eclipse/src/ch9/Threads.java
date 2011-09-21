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
		 * 1 sposób (extends Thread)
		 */
		MyThread t = new MyThread();
		t.start(); // startujemy w¹tek
		
		/**
		 * 2 sposób (implements Runnable)
		 */
		MyThreadByRunnable t2 = new MyThreadByRunnable();
		new Thread(t2).start(); // startujemy w¹tek
		
		/**
		 * mo¿na te¿ tak, bo Thread implements Runnable
		 */
		Thread t3 = new Thread(new MyThread());
		t3.start();
		
		/**
		 * UWAGA
		 */
		t.run(); // metoda siê wykona, ale nie wystartuje w¹tku !!!
	}
}
