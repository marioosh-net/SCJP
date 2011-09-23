package test1;

import java.util.HashSet;


public class HashTest2 {
    
    private String str;
    
    public HashTest2(String str) {
        this.str = str;
    }
    
    @Override
    public String toString() {      
        return str;
    }
    
    @Override
    public int hashCode() {             
        return this.str.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) { 
        if (obj instanceof HashTest2) {
            HashTest2 ht = (HashTest2) obj;
            return this.str.equals(ht.str);
        }
        return false;
    }
    
    public static void main(String args[]) {
    	
    	// tutaj porownywane beda stringi z hash. jesli sa te same tzn ze obiekty tez sa te same
    	// wiec tez wejdzie tylko jeden do HashSet'a
        HashTest2 h1 = new HashTest2("1");
        HashTest2 h2 = new HashTest2("1");
        
        // te sa rowne  i dodany zostanie tylko jeden
        String s1 = new String("2");
        String s2 = new String("2");
        
        HashSet<Object> hs = new HashSet<Object>();
        hs.add(h1);
        hs.add(h2);
        hs.add(s1);
        hs.add(s2);
        
        System.out.print(hs.size());
    }
}