package test1;

public class CruiserThread {

    private int a = 0;
    
    public void foo() {
        Runnable r = new LittleCruiser();
        new Thread(r).start();
        new Thread(r).start();
    }
    
    public static void main(String arg[]) {
        CruiserThread c = new CruiserThread();
        c.foo();
    }
    
    public class LittleCruiser implements Runnable {
        public void run() {
            int current = 0;
            for (int i = 0; i < 4; i++) {
                current = a;
                System.out.print(current + ", ");
                a = current + 2;
            }
        }
    }
}