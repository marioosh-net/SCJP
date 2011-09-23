package test1;

public class TrickyNum<X extends Object> {
    
    private X x;
    
    public TrickyNum(X x) {
        this.x = x;
    }
    
    private double getDouble() {
    	// java.lang.Integer cannot be cast to java.lang.Double
        return ((Double) x).doubleValue();
    }
    
    public static void main(String args[]) {
        TrickyNum<Integer> a = new TrickyNum<Integer>(new Integer(1));
        System.out.print(a.getDouble());
    }
}