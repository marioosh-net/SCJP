package ch8;

public class MethodInnerClasses {
	final int z = 12;
	
	void test2() {
		
	}
	
	void test() {
		int x = 2;
		final int y = 2;
		
		/**
		 * jeszcze nie ma definicji klasy Inner;
		 
		new Inner(); */ // blad kompilacji: Inner cannot be resolved to a type
		
		/**
		 * z klasy wewnetrznej metody mozna sie dostac tylko do zmiennych final,
		 * podobnie jak z klasy anonimowej
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
			}
		}
		
		/**
		 * juz jeste definicja, wiec zadziala
		 */
		new Inner();		
		
	}
	
	public static void main(String[] args) {
		new MethodInnerClasses().test();
	}
}
