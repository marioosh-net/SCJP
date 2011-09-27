package ch1;

public class Constructors4 {
	public static void main(String[] args) {
		new I();
	}
}

class K {
	public K() {
		System.out.println("member K");
	}
}

class I {
	K i = new K();

	I() {
		System.out.println("konstruktor I");
	}
}