package ch9;

public class ThreadLoop extends Thread {
	public void run() {
		for (;;);
	}

	public static void main(String args[]) {
		System.out.println("Starting Main");
		new ThreadLoop().start();
		System.out.println("Main returns");
	}
}