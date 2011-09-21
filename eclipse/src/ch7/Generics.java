package ch7;

import java.util.ArrayList;
import java.util.List;

public class Generics {
	public static void main(String[] args) {
		new Generics();
	}
	
	public Generics() {
		
		// poprawne deklaracje
		/**
		 * lista obiektów, które rozszerzaj¹ Animal (np. Cat)
		 */
		List<? extends Animal> list; 
		/**
		 * lista obiektow ktore "superuj¹" HomeAnimal, czyli Animal w tym przypadku
		 */
		List<? super HomeAnimal> list2; 
		
		// poprawne definicje
		List<String> myList = new ArrayList<String>();
		List<Object> l1 = new ArrayList<Object>();
		List<Object> l3 = new ArrayList();
		List<?> l4 = new ArrayList<String>();
		
		// niepoprawne
		List<Object> l2 = new ArrayList<String>();	// musza sie zgadzac podane typy!
		List<?> l5 = new ArrayList<?>();			// nie mo¿na u¿ywaæ wildcard'ów (?) przy kontruktorze
	}
	
	/**
	 * typy generyczne zwracane przez metody
	 * <T> - definicja nowego typu generyznego, ktory wykorzystywaqny jest w argumentach
	 */
	public <T> String lista(List<T> list) {
		List<?> l5 = new ArrayList<T>();	// tak mo¿na, mo¿na u¿yæ typu generycznego
		return null;
	}
	
}

class Animal {
}
class HomeAnimal extends Animal {
}
class Cat extends Animal {
}

/**
 * metody z parametrami generycznymi
 */
class C {
}
class A extends C {
	private int i;
}
class B extends A {
}
class ListAUtils {
	
	boolean check(List<? extends A> list) {
		return false;
	}
	
	public void test() {
		List<A> l = new ArrayList<A>();
		List<B> l2 = new ArrayList<B>();
		List<C> l3 = new ArrayList<C>();
		check(l);	// ok, bo A "IS-A" A
		check(l2);	// ok, bo B "IS-A" A
		check(l3);	// nie dziala bo C NIE "IS-A" A
	}
}