package ch7;

import java.util.*;

/**
 * http://java.sun.com/j2se/1.4.2/docs/guide/collections/index.html
 * 
 * [] java.util.Collections - klasa z szeregiem metod statycznych do uzycia z
 * kolekcjami
 * [] java.util.Collection - interfejs z metodami add, remove,...
 * 
 * interfejsy do opanowania:
 * - TAK dzidzicza z Collection: Set, List, Queue
 * - NIE -------------------||-: Map
 * 
 * Autoboxing:
 * od Javy 5 mozna dodawac do kolekcji typy primitywne (col.add(23);)
 * 
 */
public class CollectionS {
	static public void main(String[] args) {
		new CollectionS().examples();
	}

	void examples() {
		new Lists();
		new Sets();
		new Maps();
		new Queues();

		new ArrayLists().using();
	}
}

/**
 * 
 * interfejs List
 * 
 * INDEKS
 * tutaj wazny jest indeks, nowe elementy dodawane sa na koniec listy, albo do
 * okreslonego indeksu
 * 
 * - ArrayList - lista indeksowana
 * - Vector - taki sam jak ArrayList (ale thread safe - synchronized)
 * - LinkedList - jak ArrayList, ale dodatkowo elementy sa polaczone jeden z
 * drugim, ArrayList jest szybsza jesli chodzi o iteracje, ale ta jest szybsza
 * przy dodawaniu, usuwaniu elementow, dobra do kolejek
 * 
 * 
 */
class Lists {
	int index;

	Lists() {

		/**
		 * ArrayList
		 */
		ArrayList<Object> al = new ArrayList<Object>();
		al.add(index, new Object());
		al.add(new Object());
		al.remove(index);
		Object o = new Object();
		al.add(o); // ten sam element moze byc kilka razy w liscie
		al.add(o);
		System.out.println("size: " + al.size()); // -> size: 3

		al.remove(o);

		/**
		 * Vector
		 */
		Vector<Object> v = new Vector<Object>();
		v.add(index, new Object());

		/**
		 * LinkedList
		 */
		LinkedList<Object> ll = new LinkedList<Object>();
		ll.add(new Object());
		ll.getFirst(); // specjalne dla LinkedList
		ll.getLast(); // 
		// od javy 5, implementuje metody kolejki (java.util.Queue) 
		ll.peek(); // getuje ale nie usuwa pierwszy element z gory
		ll.poll(); // getuje i usuwa pierwszy z gory
		ll.offer(new Object()); // dodaje na koniec kolejki
	}
}

/**
 * 
 * interfejs Set
 * 
 * NAJWAZNIEJSZE - nie pozwala na duplikaty! (doesn't allow duplicates), uzywa
 * hashCode() swoich elementow (lepsza metoda => szybsze operacje)
 * 
 * HashSet - unsorted, unordered (iteracja nieprzwidywalna!)
 * LinkedHashSet - odered version of HashSet (mozna spokojnie robic iteracje)
 * TreeSet - sorted! (Red-Black tree structure)
 * 
 */
class Sets {
	Object o = new Object();

	Sets() {
		/**
		 * HashSet
		 */
		HashSet<Object> hs = new HashSet<Object>();
		hs.add(o);
		// dodanie ponowny raz tego samego elementu nie zwieksza 
		// rozmiaru seta, czyli jak widac HashSet nie pozwala na duplikaty
		hs.add(o);
		hs.add(o);
		System.out.println("size: " + hs.size()); // -> size: 1
		hs.remove(o);

		/**
		 * LinkedHashSet
		 */
		LinkedHashSet<Object> lhs = new LinkedHashSet<Object>();

		/**
		 * TreeSet
		 */
		TreeSet<Elem> ts = new TreeSet<Elem>();
		ts.add(new Elem());
	}
}

/**
 * 
 * interfejs Map
 * 
 * NAJWAZNIEJSZE:
 * mapuje klucz na wartosc (klucz i wartosc sa obiektami)
 * 
 * HashMap - unsorted, unordered
 * Hashtable - stary (thread safe (synchronized) HashMap)
 * LinkedHashMap - unsorted, ordered (szybsze iteracje, wolniejsze dodawanie
 * usuwanie)
 * TreeMap - jest posortowany wg kluczy (np. jak klucz jest String, to moze byc
 * alfabetycznie)
 * 
 */
class Maps {

	Maps() {
		/**
		 * HashMap
		 */
		// key,value
		HashMap<Elem, Object> hm = new HashMap<Elem, Object>();
		hm.put(new Elem(), new Object()); // put (nie add!!!)
		Elem key = new Elem();
		hm.remove(key); // pobierz wartosc dla klucza i USUN
		hm.get(key); // pobierz wartosc dla klucza

		/**
		 * Hashtable
		 */
		Hashtable<Object, Object> ht = new Hashtable<Object, Object>();

		/**
		 * LinkedHashMap
		 */
		LinkedHashMap<Object, Object> lhm = new LinkedHashMap();

	}
}

/**
 * 
 * interfejs Queue
 * 
 * FIFO queue
 * 
 */
class Queues {
	Queues() {
		PriorityQueue pq = new PriorityQueue();
		pq.add(new Object());
		pq.remove();// rzuca wyjatek jak kolejka jest pusta;	
		pq.poll(); // = remove(), ale nie rzuca wyjatku	
	}
}

class Elem {

}

/**
 * Examples
 */
class ArrayLists {
	void using() {
		/**
		 * ArrayList zamiast tablicy:
		 * - rosnie dynamicznie! (nie trzeba podawac rozmiary jak w tablicach)
		 */
		ArrayList al = new ArrayList();
		al.add(new String("ala"));
		al.add("ala");
		System.out.println(al.size());
		System.out.println(al.contains("ala")); // czy zawiera ?

		/**
		 * Autoboxing
		 */
		List myInts = new ArrayList(); // przed Java 5
		myInts.add(new Integer(42)); // had to wrap an int

		// autoboxing!!!!
		myInts.add(42); // od Javy5: autoboxing handles it!
	}
}



