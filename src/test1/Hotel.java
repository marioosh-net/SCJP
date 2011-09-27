package test1;

class BaseHotel {
    public int bookings;
    public void book() {
        bookings++;
    }
}

public class Hotel extends BaseHotel {
    public void book() {
        bookings--;
    }
    
    public void book(int size) {
        book();
        super.book();
        bookings += size;
    }
    
    public static void main(String args[]) {
        Hotel hotel = new Hotel();
        hotel.book(2);
        System.out.print(hotel.bookings);
    }
}