/**
 * Tworzac klase anonimowa robimy tak naprawd� podklas� (extends)
 * 
 * @author marioosh
 *
 */
class Popcorn {
	void pop() {
		System.out.println("popcorn");
	}
}
public class AnonymousClasses {
	public static void main(String[] args) {
		new AnonymousClasses();
	}
	
	public AnonymousClasses() {
		Popcorn p = new Popcorn() {	// ten nawias otwiera definicj� podklasy Popcorn 
			@Override
			void pop() {
				System.out.println("anonymous popcorn");
			}
		};
	}
}
