import static java.lang.System.out;

import java.util.Collections;
import java.util.Vector;

import ch7.CollectionS;
/**
 * testy...
 */
public class MainTest {
	
	public static void main(String[] args) {
		new MainTest();
		String stmt = "JavaChamp is here to help you";
		for (String token : stmt.split("\\f")) {
			System.out.print(token + " ");
		}		
		
	}
	
	private static void print(Number n) {
		out.println("numb");
	}
	private static void print(Float n) {
		out.println("float");
	}

	public MainTest() {
		TestThread t = new TestThread();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		
		// normalnie w metodzie run() Threada jest uruchamiany run z Runnable,
		// ale w tym przypadku run jest overridowany w ThreadT, wiec on sie wykona
		new ThreadT(new Runnable1()).start();
	}

}

class Runnable1 implements Runnable {
	@Override
	public void run() {
		System.out.println("runnable");
	}
}

class ThreadT extends Thread {
	public ThreadT() {
		// TODO Auto-generated constructor stub
	}
	public ThreadT(Runnable1 runnable1) {
		super(runnable1);
	}
	@Override
	public void run() {
		System.out.println("ThreadT");
	}
}

class TestThread implements Runnable {
	
	@Override
	public void run() {
		System.out.println("running "+Thread.currentThread().getName());
	}
}

