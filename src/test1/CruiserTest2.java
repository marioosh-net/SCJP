package test1;

public class CruiserTest2 implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new CruiserTest2());
        a.start();
        
        // Thread.sleep(1000);
        System.out.print("Begin");
        a.join();
        System.out.print("End");
    }
    
    public void run() {
        System.out.print("Run");
    }
}