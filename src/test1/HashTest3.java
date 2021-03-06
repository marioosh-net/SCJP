package test1;

import java.util.HashSet;

public class HashTest3 {
    
    private String str;
    
    public HashTest3(String str) {
        this.str = str;
    }
        
    @Override
    public int hashCode() {             
        return this.str.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.str.equals(obj);	// dla obiektow HashTest3 bedzie w pewnym momencie 
        								// porownanie "1" z "test1.HashTest3@31" (obj.toString())
        								// lub "test1.HashTest3@31" z "test1.HashTest3@32"
    }
    
    public static void main(String args[]) {
        HashTest3 h1 = new HashTest3("1");
        HashTest3 h2 = new HashTest3("1");
        String s1 = new String("2");
        String s2 = new String("2");
        
        HashSet<Object> hs = new HashSet<Object>();
        hs.add(h1);
        hs.add(h2);
        hs.add(s1);
        hs.add(s2);
        
        System.out.print(hs);
    }
}