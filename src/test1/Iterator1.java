package test1;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Iterator1 {
    public static void main(String args[]) {
        List list = new LinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        
        Collections.reverse(list);
        Iterator iter = list.iterator();
        
        // Iterator nie jest tablica ani kolekcja
        for (Object o : iter) {
            System.out.print(o + " ");
        }
        
        System.gc();
        Runtime.gc();
        System.freeMemory();
        Runtime.getRuntime().freeMemory();	// Returns the amount of free memory in the Java Virtual Machine
        Runtime.getRuntime().gc();
    }
}