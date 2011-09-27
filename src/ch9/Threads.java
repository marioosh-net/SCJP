package ch9;

/**
 * - watki startujemy **ZAWSZE** z obiektu Thread przez uzycie start(); 
 * 
 * @author marioosh
 *
 */

class MyThread extends Thread {
	public void run() {
		System.out.println("run "+Thread.currentThread().getName());
	}

	// to jest ignorowane, bo to jest przeladowanie metody run()
	public void run(String s) {
		System.out.println("String in run is " + s);
	}
}

class MyThreadByRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("run (Runnable) "+Thread.currentThread().getName());
	}

}
public class Threads {
	
	public static void main(String[] args) {
		
		/**
		 * 1 spos�b (extends Thread)
		 */
		MyThread t = new MyThread();
		t.start(); // startujemy wątek
		
		/**
		 * 2 spos�b (implements Runnable)
		 */
		MyThreadByRunnable t2 = new MyThreadByRunnable();
		new Thread(t2).start(); // startujemy wątek
		new Thread(t2).start();	// mozna wiecej watkow robiacych to samo
		new Thread(t2).start(); // ...
		
		/**
		 * można też tak, bo Thread implements Runnable
		 */
		Thread t3 = new Thread(new MyThread());
		t3.start();
		
		/**
		 * UWAGA
		 */
		t.run(); // metoda się wykona, ale nie wystartuje wątku !!!
		
		System.out.println(Thread.currentThread().getName());
	}
}

