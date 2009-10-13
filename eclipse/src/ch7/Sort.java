package ch7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Sortowanie kolekcji (i tablic)
 * 
 * ZASADA:
 * w kolekcji lub talicy musza byc obiekty, ktore sa porownywalne bezproblemowo
 * (np. w tablicy Object[] nie moga wystapic obiekty Cat i Dog jednoczesnie)
 * 
 * Comparable interface - compareTo(Object drugi)
 * Comparator interface - compare(Object a, Object b)
 */
public class Sort {
	static public void main(String[] args) {
		new Sortowanie().examples();

		new SortingArrays().examples();
	}
}

class Sortowanie {
	void examples() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Wojtek");
		al.add("Ala");
		al.add("Zenon");
		al.add("Tomek");

		System.out.println("unsorted: " + al);
		// sortowanie alfabetyczne (String jest z defaultu Comparable)
		Collections.sort(al);
		System.out.println("sorted: " + al);

		// sortowanie za pomoca interfejsu Comparable
		ArrayList<BookUnComparable> ubooks = new ArrayList<BookUnComparable>();
		//Collections.sort(ubooks); // error

		ArrayList<MyBook> books = new ArrayList<MyBook>();
		Collections.sort(books);

	}
}

/**
 * Comparable interface - compareTo() method
 * teraz klasa moze byc sortowana przez Collections.sort();
 * 
 * (implementowana w klasach takich jak String, Wrapper classes, Date, Calendar)
 */
class MyBook implements Comparable<MyBook> {
	String title;

	/*
	 * o > b => o.compareTo(b) = 1
	 * o == b => o.compareTo(b) = 0
	 * o < b => o.compareTo(b) = -1
	 */
	@Override
	public int compareTo(MyBook o) {
		// TODO Auto-generated method stub
		return title.compareTo(o.title);
	}
}

class BookUnComparable {
}

/**
 * Comparator interface - compare() method
 * 
 * (zazwyczaj implementowana w klasach third-party)
 */
class Cat implements Comparator<Cat> {
	private String name;

	@Override
	public int compare(Cat o1, Cat o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}

/**
 * sortowanie tablic
 */
class SortingArrays {
	void examples() {
		String[] tab = { "ala", "tomek", "jacek", "bolek" };

		for (String e : tab) {
			System.out.print(e + ",");
		}
		System.out.println();
		
		Arrays.sort(tab); // sortowanie
		
		for (String e : tab) {
			System.out.print(e + ",");			
		}

	}
}
