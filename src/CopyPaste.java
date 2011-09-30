import java.util.*;

class Book {
	private String title, isbn;

	public boolean equals(Object o) {
		return (o instanceof Book && ((Book) o).isbn.equals(this.isbn));
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	// ... setters and getters for title and isbn
}

class BookStore {
	Map<Book, Integer> map = new HashMap<Book, Integer>();

	int getNumberOfCopies(Book b) {
		return map.get(b);
	}

	public void addBook(Book b, int numberofcopies) {
		map.put(b, numberofcopies);
	}
	// ... other useful methods.
}

public class CopyPaste {
	static BookStore bs = new BookStore();

	public static void main(String[] args) {
		Book b = new Book();
		b.setIsbn("111");
		bs.addBook(b, 10);
		System.out.println(bs.getNumberOfCopies(b));

		b = new Book();
		b.setIsbn("111");
		System.out.println(bs.getNumberOfCopies(b));
		
		System.out.println("a"+'b'+63);
		System.out.println("a"+63);
		System.out.println('b'+new Integer(63));
		String s1 = 'b'+63+"a";
		// String s2 = 63 + new Integer(10);

	}
}

class CopyPaste2 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		int[] b = { 2, 3, 1, 0 };
		System.out.println(a[(a = b)[3]]);

		String[] sA = { "aaa" };
		String[] sB = { new String("aaa") };

		int i = 0;
		char ch = 'a';
		short s;
		i = (int) ch;

		char c = 320;
	}
}

class A {
	public A() {
	}

	public A(int i) {
		System.out.println(i);
	}
}

class B {
	static A s1 = new A(1);
	A a = new A(2);

	public static void main(String[] args) {
		B b = new B();
		A a = new A(3);
	}

	static A s2 = new A(4);
}
