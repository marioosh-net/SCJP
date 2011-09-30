package test1;

class A {
    public void doA() {
        B b = new B();
        b.dobB();
        System.out.print("doA");
        
        try {
        	
        } catch (RuntimeException e) {
        	
        }
    }
}

class B {
    public void dobB() {
        C c = new C();
        c.doC();
        System.out.print("doB");
    }
}

class C {
    public void doC() {
        if (true)
            throw new NullPointerException();
        System.out.print("doC");
    }
}

public class Exceptions1 {

    public static void main(String args[]) {
        try {
            A a = new A();
            a.doA();
        } catch (Exception ex) {
            System.out.print("error");
        }
    }
}
