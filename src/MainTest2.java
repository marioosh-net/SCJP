import static java.lang.System.out;

import java.util.Arrays;
import java.util.Collections;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.Vector;

import ch7.CollectionS;


public class MainTest2 {
	public static void main(String[] args) {

		int x = 1;
		System.out.println(x++ + x++);	// 3
		
		Integer i1 = 128;
		Integer i2 = 128;
		System.out.println(i1 != i2);	// true
		
		Integer j1 = 5;
		Integer j2 = 5;
		System.out.println(j1 != j2);	// false
		
		
		int d = 2225;
		Integer d1 = 2225;
		System.out.println(d == d1);	// true (unboxing)
		
		StringBuffer b = new StringBuffer("dsds");
		StringBuffer b1 = null;
		b.append(b1);
		b.insert(0, "222");
		
		Integer[] a = new Integer[]{1,3,4,334};
		out.println("MAX: "+Collections.max ( Arrays.asList(a)));
		
		Vector<Double> v1 = new Vector<Double>();
		Vector<Integer> v2 = new Vector<Integer>();
		out.print(v1.getClass() == v2.getClass());	// true
		out.print(v1.equals(v2));					// true
		
		Gen<Integer> g = new Gen<Integer>(18);
		
		NavigableSet<String> n = new TreeSet<String>();
		
	}
}

class Gen<T> {
	T obj;
	T get() {
		return obj;
	}

	public Gen(T o) {
		obj = o;
	}
}
