package test1;

// tak byloby ok, bo w Integer jest metoda doubleValue()
// public class TrickyNum1<X extends Integer> {

// tak tez bo w Number sa takie metody
// public class TrickyNum1<X extends Number> {

public class TrickyNum1<X extends Object> {
    
    private X x;
    
    public TrickyNum1(X x) {
        this.x = x;
    }
    
    private double getDouble() {
    	// The method doubleValue() is undefined for the type X
    	// w Object nie ma metody doubleValue();
        return x.doubleValue();
    }
    
    public static void main(String args[]) {
        TrickyNum1<Integer> a = new TrickyNum1<Integer>(new Integer(1));
        // TrickyNum1<Double> a = new TrickyNum1<Double>(new Double(1)); to tez bedzie nie tak
        System.out.print(a.getDouble());
    }
}
