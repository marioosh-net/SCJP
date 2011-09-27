package ch7;

import java.util.HashSet;

public class HashMapTest {

	public static void main(String[] args) {
		
        HashSet<Object> hs = new HashSet<Object>();
        String s1 = new String("1");	// dwa rozne obiekty
        String s2 = new String("1");	//
        hs.add("2");	// dwa takie same, wiec tylko jeden zostanie doany
        hs.add("2");	//
        hs.add(s1);
        hs.add(s2);
        System.out.println(new String("1").hashCode());
        System.out.println(new String("1").hashCode());
        
        for(Object s: hs) {
        	System.out.println(s);
        }
		
	}
}

class String1 {
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		} else {
			return super.equals(obj);
		}
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}