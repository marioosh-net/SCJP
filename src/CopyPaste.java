import java.io.Console;

public class CopyPaste {
	public static void main(String[] args) {
		B.main(args);
	}
}
class A {
	A() {
		print();
	}

	void print() {
		System.out.println("A");
	}
}

class B extends A {
	int i = Math.round(3.5f);

	public B() {
		super();
	}

	public static void main(String[] args) {
		A a = new B();
		a.print();
	}

	void print() {
		System.out.println(i);
	}
}

