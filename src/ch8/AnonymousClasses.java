package ch8;
/**
 * Tworzac klase anonimowa robimy tak naprawdę podklasę (extends) istniejącej klasy
 * lub implementujemy istniejący interfejs
 * 
 * identycznie jak przy klasach wewnetrznych metod, wewnatrz klasy anonimowej
 * mamy dostep tylko do zmiennych finalnych lub statycznch
 */
class Popcorn {
	public Popcorn(String x) {
	}
	public Popcorn() {
	}
	void pop() {
		System.out.println("popcorn");
	}
	void up() {
		System.out.println("up");
	}
}
interface PopcornInterface {
	void pop();
	void up();
}
public class AnonymousClasses {
	static double k;
	double double1;
	
	public static void main(String[] args) {
		new AnonymousClasses().test();
	}
	
	public void test() {
		final int x = 12;
		/**
		 * klasa anonimowa przez "extends"
		 */
		Popcorn p = new Popcorn() {	// ten nawias otwiera definicję podklasy Popcorn 
			@Override
			void pop() {
				System.out.println("anonymous popcorn " + x + ", " + double1);
			}
			
			/**
			 * mozna dodac nowe metody, ale nie wywolamy ich z zwnatrz
			 */
			void newmethod() {
				
			}
		};
		p.pop();
		// p.newmethod();	// nie zadziala, bo typ referencji nie widzi tej metody
		
		/**
		 * to samo bez override'a
		 */
		Popcorn p1 = new Popcorn("s") {};
		Popcorn p3 = new Popcorn() {};
		
		/**
		 * klasa anonimowa przez "implements"
		 */
		PopcornInterface p2 = new PopcornInterface() {
			@Override
			public void up() {
				System.out.println("anonymous popcornInterface implementation " + x + ", " + k);
			}
			@Override
			public void pop() {}
		};
		p2.up();
	}
}
