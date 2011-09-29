package ch9;

/**
 * yield() 
 * 		Causes the currently executing thread object to temporarily pause 
 * 		and allow other threads to execute.
 * 
 * sleep() 
 * 		podobny do wait(), ale nie zwalnia blokady
 *  
 *
 * join()
 * 		watek na ktorym jest wykonywana metoda (A) blokuje biezacy watek (B)
 * 		az do momentu jak (A) skonczy swoje dzialanie
 * 
 * 		innymi slowy: a.join(); -> bezacy watek czeka az a zakonczy dzialanie (die)
 * 		// Join me (the current thread) to the end of a
 * 
 * join(ms)
 * 		czekaj ale maksymalnie ms milisekund
 *
 * wait()
 * 		blokuje watek, przechodzi do stanu "not runnable"
 *		jednocześnie otwiera rygiel umożliwiając innym wątkom dostęp do obiektu
 *		ZWRACA LOCK (zwraca klucz do snychronizowanego obiektu) - inne watki maja dostep
 * 
 * notify()
 * 		sygnalizuje oczekujace watki, ale nie oddaje locka dopoki nie zakonczy bloku synchronizowanego
 * 
 * notifyAll()		
 * 		jak notif() ale daje sygnal wszystkim oczekujacym watkom  
 * 
 *	SYNCHRONIZACJA WATKOW:
 *	- synchronized moze byc uzyte dla metody lub bloku
 *	- w przypadku bloku trzeba podac na czym (zazwyczaj obiekt, np. this) ma byc synchronizacja
 *
 *	Uzycie notify(); jesli nie posiadamy locka lub poza blokiem synchronized // => java.lang.IllegalMonitorStateException
 *		
 */
public class SynchronizedThreads {
	public static void main(String[] args) throws InterruptedException {
		// new SynchronizedThreads().test();
		new SynchronizedThreads().synchro();
	}
	
	void test() throws InterruptedException {
		Thread.yield();
		// Thread.sleep(1000);
		// Thread.currentThread().join();	// program sie nigdy nie skonczy
		
		A runnable = new A(new Store());
		
		Thread a = new Thread(runnable);
		a.start();
		/**
		 * blokuje aktualny watek (czyli main) az do momentu jak watek a skonczy swoje dzialanie
		 */
		a.join();		
		
		Thread b = new Thread(runnable);
		b.start();
		b.join();	
		
		try {
			
		} finally {
			
		}

		System.out.println("test");
	}
	
	void synchro() {
		A runnable = new A(new Store());
		new Thread(runnable).start();
		new Thread(runnable).start();
		new Thread(runnable).start();
	}
}

class A implements Runnable {
	private Store store;
	
	
	public A(Store store) {
		this.store = store; 
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		store.s();
		// System.out.println(getClass().getName() + ", "+store.count);
	}

}

class Store {
	int count;
	static int staticCount;

	/**
	 * synchronized method
	 * tylko jeden watek moze wykonywac ta metode w danej chwili (w obrebie tego samego obiektu)
	 */
	synchronized void s() {
		System.out.println("s(), "+ ++count + ", " + Thread.currentThread().getName());
		notify();
	}
	
	/**
	 * synchronized block
	 * trzeba podac na czym ma byc ta synchronizacja (w tym przypadku na obiekcie = this)
	 * ta metoda jest rownoznaczna z s()
	 */
	void s2() {
		synchronized (this) {
			System.out.println("s(), "+ ++count + ", " +Thread.currentThread().getName());
		}
	}
	
	/**
	 * TYPOWO
	 * watek cos robi zabierajac locka, a jak skonczy to daje znac innym oczekujacym watkom
	 */
	synchronized void s3() {
		// do some hard work
		
		// sygnaluzuje innym watkom ze zwolni niebawem lock z this
		notify(); notifyAll();
		this.notify();
	}
	
	/**
	 * synchronizacja metody statycznej
	 */
	synchronized static void a3() {
		System.out.println("s(), "+ ++staticCount + Thread.currentThread().getName());
	}
	static void a() {
		synchronized (Store.class) {
			System.out.println("s(), "+ ++staticCount + Thread.currentThread().getName());
		}
	}
	
}