package ch8;

public class InnerClasses {

	class Engine {
		// blok inicjalizacyjny
		{
			// taka konstrukcja do zapamietania "klasaZewnetrzna.this"
			InnerClasses.this.drive();
			
			// zle bo InnerClasses nie statyczna
			InnerClasses.drive();
		}
	}

	public static void main(String[] args) {
		new InnerClasses().go();
	}

	void go() {
		new Engine();
	}

	void drive() {
		System.out.println("hi");
	}
}