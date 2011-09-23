package ch9;

public class MyThread extends Thread {
	public void run() {
		System.out.println("Important job running in MyThread");
		System.out.println("NAME: "+getName());
	}

	// to jest ignorowane, bo to jest przeladowanie metody run()
	public void run(String s) {
		System.out.println("String in run is " + s);
	}
}