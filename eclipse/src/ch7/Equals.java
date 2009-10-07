package ch7;

/**
 * metoda equals()
 * 
 * ZASADY:
 * 1. equals() w klasie Object dziala tak samo jak == (porownuje referencje)
 * i zwraca true, jesli referencje wskazuja na to samo
 * 2. klasy otaczajace (wrappers) i klasa String przeslaniaja equals()
 * - porownuja wartosci, nie referencje
 * 
 * 3. w kodzie przeslaniajecej metody equals(), nalezy wykorzystac test: czy X
 * instanceof Y
 */
public class Equals {
	static public void main(String[] args) {
		new Equals().examples();
		new Equals().hashCodes();
	}

	void examples() {
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = o1;
		Integer I = new Integer(2);
		Long L = new Long(2);
		int i = 2;

		// porownuje "zawartosc"
		if (I.equals(i)) {
			System.out.println("Integer 2 equals int 2");
		}
		// porownanie dwoch roznych typow - zawsze zwroci false!
		if (I.equals(L)) {
			System.out.println("Integer 2 equals Long 2");
		}
		/* niekompatybilne typy
		if(I == L) { 
			System.out.println("Integer 2 equals Long 2");
		}*/
		// porownuje wartosci (unboxing I to int)
		if (i == I) {
			System.out.println("Integer 2 == int 2");
		}
		// porownuje referencje
		if (o1 == o2) {
			System.out.println("o1 == o2");
		}
		// porownuje referencje
		if (o1 == o3) {
			System.out.println("o1 == o3");
		}
	}

	void hashCodes() {
		Car o1 = new Car(1);
		Car o2 = new Car(2);
		System.out.println(o1.hashCode());
		System.out.println(o2.hashCode());
	}
}

/**
 * 
 * overriding equals(), toString(), hashCode();
 * wszystkie te motody sa public!!
 * 
 */
class Book {
	/**
	 * poprawne i niepoprawne przesloniecia metody equals()
	 */
	/* zle - nie jest public (reduced visability)  
	boolean equals(Object b) {
		return false;
	}*/
	// zle - overloading, NIE overriding
	boolean equals(Book b) {
		return false;
	}

	// dobrze
	public boolean equals(Object b) {
		return false;
	}
}

/**
 * metoda hashCode()
 * 
 * hashCode() - kartki w wiadrkach. kazda kartka ma swoje wiaderko,
 * dwie kartki moga siedziec w tym samym wiaderku. szukanie - 2 etapy:
 * szukanie wiaderka (uzycie hashCode()), szukanie w wiaderku (uzycie
 * equals())
 * 
 * 1. dobra metoda hashCode() uzywa tych samych zmiennych co metoda equals()
 * 2. efektywna metoda hashCode() "rozprowadza" rownomiernie obiekty po
 * wszystkich dostepnych "wiaderkach" (zeby w jak najwiekszej liczbie przypadkow
 * przy wyszukiwaniu nie trzeba bylo uzywac equals())
 * 
 * WARUNKI KONIECZNE na poprawnie DZIALAJACA hashCode():
 * 1. zwraca ta sama wartosc dla danego obiektu niezaleznie ile razy zostanie
 * wywolana przy jednym wywolaniu programu (wartosc zwracana niekoniecznie musi
 * byc taka sama przy drugim wykonywaniu tego programu)
 * 2. jesli dwa obiekty sa equals() to hashCode() dla tych obiektow tez musza
 * byc identyczne: (X.equals(Y) == true ===> X.hashCode() == Y.hashCode())
 * 3. jesli dwa obiekty nie sa equals() to hashCode() nie musi zwracac roznych
 * wartosci dla tych obiektow (moze zwracac to samo), gdy zwraca to lepiej dla
 * wydajnosci
 * 
 * Co moze SPIEPRZYC hashCode() i equals():
 * - uzycie zmiennej 'transient' w kodzie (po serializacji mozemy nie znalezc
 * obiektu w kolekcji wykorzystujacej hashowanie)
 */
class Car {
	int x;

	Car(int x) {
		this.x = x;
	}

	// poprawne przysloniecie metody equals()
	public boolean equals(Object o) {
		if (o instanceof Car && ((Car) o).x == this.x) {
			return true;
		} else {
			return false;
		}
	}

	// poprwana hashCode()
	public int hashCode() {
		return x * 11;
	}

	/* tez poprawna, ale STRASZNIE nieefektywna 
	public int hashCode() { 
		return 1492; 
	}
	*/
}
