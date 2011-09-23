package test1;

public class Cruiser implements Runnable {
    
    public void run() {
        System.out.print("go");
    }
    
    public static void main(String arg[]) {
        Thread t = new Thread(new Cruiser());
        t.run();
        t.run();
        t.start();
    }
}