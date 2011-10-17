public class ThTh implements Runnable {
	static Integer i = new Integer(0);

	public static void main(String[] args) {
		new Thread(new ThTh()).start();
		
	}
	
	void x(){}
	
	@Override
	synchronized public void run() {

			// wait();
			notify();
			System.out.println("x");

			
			String[] x = "a:b:c::::::".split(":",10);
			System.out.println(x.length);
			for(String s: x) {
				System.out.println(s);
			}
			
			if( false ^ false) {
				System.out.println("OK");
			}

	}
	
	class I {
		Integer s = ThTh.i;
	}
	
}

abstract class R {
	abstract void s();
	
	public class X {
		
	}
	
	void t() {

	}
}