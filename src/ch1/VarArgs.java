package ch1;

public class VarArgs {

	public static void main(String[] args) {

		doStuff();
		doStuff(1, 2); 	// ambiguous
		doStuff(1); 	// ambiguous

	}

	// int... => ZERO lub wiecej parametrow
	static void doStuff(int... a) {
		System.out.println("1");
	}

	static void doStuff(int a, int... b) {
		System.out.println("2");
	}

}
