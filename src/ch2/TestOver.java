package ch2;

class SuperBase {
	void print(SuperBase a) {
		System.out.println("Super");
	}
}
class Base extends SuperBase {
	void print(Base b) {
		System.out.println("Base");
	}
}
class Derived extends Base {
	void print(Derived d) {
		System.out.println("Derived");
	}
}

/**
 * nie ma tutaj overridingu, bo roznia sie typy
 * wiec odpalane sa metody wg referencji 
 */
public class TestOver {
	public static void main(String[] args) {
		SuperBase a1 = new SuperBase();
		SuperBase b1 = new Base();
		Base c1 = new Derived();
		
		a1.print(new Base());
		b1.print(new Derived());
		c1.print(new Derived());
	}
}
