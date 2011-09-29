package ch8;

import java.io.Serializable;

import ch2.Interfaces;

public class MethodInnerClasses {
	final int z = 12;
	int local;
	
	void test() {
		int x = 2;
		final int y = 2;
		
		/**
		 * jeszcze nie ma definicji klasy Inner;
		 
		new Inner(); */ // blad kompilacji: Inner cannot be resolved to a type
		
		/**
		 * z klasy wewnetrznej metody mozna sie dostac 
		 * do zmiennych lokalnych ale tylko final
		 * 
		 * do zmiennych instancyjnych klasy zewnetrznej bez problemu, nawet prywatnych
		 * 
		 * nie ma mozliwosci dostac sie do takiej klasy z zewnatrz metody
		 * 
		 */
		class Inner {
			public Inner() {
				System.out.println("klasa wewnatrz metody");
				/**
				 * Cannot refer to a non-final variable x inside 
				 * an inner class defined in a different method
				 
				System.out.println(x); */
				
				System.out.println(y);
				System.out.println(z);
				System.out.println(local);
			}
		}
		
		/**
		 * juz jeste definicja, wiec zadziala
		 */
		new Inner();		

		
		/**
		 * mozna normalnie robic dziedziczenie etc
		 */
		class SubInner extends Inner implements Serializable {}		
		/**
		 * interfejsu nie mozna
		interface I{} */ 
	}

	/**
	 * jedyne mozliwe modyfikatory w klasie wewnatrz metody:
	 * 		final lub abstract
	 */
	void test2() {
		abstract class Inner2 {}
		final class Inner3 {}
	}
	
	public static void main(String[] args) {
		new MethodInnerClasses().test();
	}
}
