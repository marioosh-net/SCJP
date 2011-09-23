package test1;

public class SomeClass {
    private int value = 1;
    
    public void printVal(int value) {
        System.out.print(value);
    }

    public static void main(String args[]) {
        int a = 2;
        SomeClass c = new SomeClass();
        c.printVal(a);
    }
}
