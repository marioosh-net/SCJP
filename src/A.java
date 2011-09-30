/**
 * Kolejność przy tworzeniu obiektu/ładowaniu klas:
 * 
 * 1. Wll static constants, variables and blocks. (kolejność jak w kodzie)
 * 2. Wll non static constants, variables and blocks. (kolejność jak w kodzie)
 * 3. Constructor.
*/
class W {
	public W() {
	}

	public W(int i) {
		System.out.println(i);
	}
}
class Y {
	public Y() {
		System.out.println("Y");
	}
}
class X extends Y {
	{
		new W(12);
	}
	static W s1 = new W(1);
	W a = new W(2);
	
	public X() {
		System.out.println("X");
	}

	public static void main(String[] args) {
		X b = new X();
		W a = new W(3);
	}

	static W s2 = new W(4);
}