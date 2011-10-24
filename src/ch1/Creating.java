package ch1;

/**
 * KOLEJNOSC:
	1. Static blocks of the base class (only once, in the order they appear in the class), kolejność jak w kodzie
	2. Static blocks of the class.
	3. Non-static blocks of the base class.
	4. Constructor of the base class.
	5. Non-static blocks of the class.
	6. Constructor of the class.
 *
 */
public class Creating {
	public static void main(String[] args) {
		new N();
	}
}

class M {
	static{
		System.out.println("BASE static");		// 1
	}
	{
		System.out.println("BASE instance");	// 3
	}
	public M() {
		System.out.println("BASE constructor");	// 4
	}
}
class N extends M {
	static{
		System.out.println("SUB static");		// 2
	}
	{
		System.out.println("SUB instance");		// 5
	}
	public N() {
		System.out.println("SUB constructor");	// 6
	}
}