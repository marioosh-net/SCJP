package test1;

public class HotelThread {

    private static void book() {
        System.out.print("book");
    }
    
    public static void main(String[] args) {
        Thread.sleep(1);	// Unhandled exception type InterruptedException
        book();
    }
}