package pulapki;

public class Interfaces1 {
	
	public static void main(String[] args) {
		new Interfaces1().go();
	}
	
	void go() {
	Bar b = new Bar();
		b.doStuff(null);
	}
}

interface Foo {
	void foof();
}

class Bar {
	void doStuff(Foo f) {
		System.out.println(f);
	}
}