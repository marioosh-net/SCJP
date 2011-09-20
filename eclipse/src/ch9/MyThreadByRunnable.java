package ch9;

public class MyThreadByRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Important job running in MyThreadByRunnable");
		System.out.println("NAME: "+Thread.currentThread().getName());
	}

}