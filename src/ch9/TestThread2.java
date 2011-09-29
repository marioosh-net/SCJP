package ch9;

class TestThread2 extends Thread {
	private int i;
	static String s = new String("hi");

	TestThread2(String s) {
		super(s);
	}

	public String getObj() {
		return s;
	}

	public void run() {
		try {
			synchronized (this.getObj()) {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) {
		TestThread2 t1 = new TestThread2("A");
		TestThread2 t2 = new TestThread2("B");
		t1.start();
		t2.start();
	}
}