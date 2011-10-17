package ch7;

import java.io.IOException;
import java.util.*;

/**
 * Set / subSet
 * jesli cos uda sie dodac do subSet'a to dodane jest rowniez do seta
 * w odwrotna strone to nie dziala, chyba ze dodawany element miesci sie w zakresie subseta
 * 
 * @author marioosh
 *
 */
public class TreeSet_ {

    public static void main(String[] args) {

        TreeSet<Integer> s = new TreeSet<Integer>();
        TreeSet<Integer> subs = new TreeSet<Integer>();

        for(int i = 324; i<=328; i++)
        {
            s.add(i);
        }
        subs = (TreeSet) s.subSet(326, true, 328, true );
        
        /**
         * java.lang.IllegalArgumentException: key out of range
         */
        subs.add(329);
        
        
        System.out.println(s+" "+subs);
        
    }

}
