package ch9;

class TestThread {
	public static void main(String[] args) {
		printAll(args);
	}

	public static void printAll(String[] lines) {
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
			
			// Unhandled exception type InterruptedException
			Thread.currentThread().sleep(1000);
		}
	}
}