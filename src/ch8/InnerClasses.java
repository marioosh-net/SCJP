package ch8;

import XBB;

/**
 * WAZNE:
 * 		klasa wewnetrzna ma dostep do wszystkich membrow (nawet private)
 * 		klasy zewnetrznej,
 * 		oczywiscie klasa wew. static ma dostep tylko do zmiennych statycznych
 * 		klasy zewnetrznej 
 * 
 * klasa wewnetrzna moze miec modyfikatory takie jak membry:
 * 		final 
 *  	abstract
 *  	public
 *  	private
 *  	protected
 *  	static—but static turns it into a static nested class not an inner class
 *  	strictfp
 *  
 *  
 * @author marioosh
 *
 */
public class InnerClasses {
	static int Static;
	
	// klasa moze byc statyczna tak jak member
	static class Air {
		public Air() {
			System.out.println(Static);	// ok, bo statyczna
		}
	}
	class Engine {
		// blok inicjalizacyjny
		{
			// taka konstrukcja do zapamietania "klasaZewnetrzna.this"
			InnerClasses.this.drive();
			
			// zle bo InnerClasses nie statyczna
			/*
			InnerClasses.drive();
			*/
			
			inner();
		}
	}

	public static void main(String[] args) {
		new InnerClasses().go();
		
		new TestOuter().t();
		
		/*
		 *  tworzenie klasy wewnetrznej non-static
		 */
		new Outer().new Inner();
		
		/*
		 * tworzenie static inner class Air
		 */
		new InnerClasses.Air();
		
		// not visible
		/*
		new Outer().new InnerPrivate();
		*/
	}
	
	/**
	 * klasa wewnetrzna wewnatrz metody
	 */
	void inner() {
		class Inner2 {
			public Inner2() {
				System.out.println("klasa wewnatrz metody");
			}
		}
		new Inner2();
	}

	void go() {
		new Engine();
	}

	void drive() {
		System.out.println("hi");
	}
}

class Outer {
	int x;
	class Inner {
		int getX () {
			return x;
		}
	}
	private class InnerPrivate {
		int getX () {
			return x;
		}
	}
	/**
	 * modyfikatory klas
	 * @author marioosh
	 */
	protected class I1 {
	}
	abstract protected class I2 {
	}
	final public class I3 {
	}
}

class TestOuter {
	static public void t2() {
		// this jest zwiazane z obiektem klasy, a w static nie ma potrzeby zeby obiekt istinal
		/*
		System.out.println(TestOuter.this);
		*/
	}
	public void t() {
		System.out.println(TestOuter.this);
		TestOuter.this.t2();		
	}
}

/**
 * klasa wewnetrzna moze dziedziczyc z klasy zewnetrznej !!
 */
class XBB {
	public XBB() {
		System.out.println("XBB");
	}
	class B extends XBB {
		public B() {
			System.out.println("B");
		}
	}
}
