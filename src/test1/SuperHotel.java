package test1;

class Hotel {
    public int bookings;
    public void book() {
        bookings++;
    }
}

public class SuperHotel extends Hotel {
    public void book() {
        bookings--;
    }
    
    public void book(int size) {
        book();
        super.book();
        bookings += size;
    }
    
    public static void main(String args[]) {
        Hotel hotel = new SuperHotel();
        
        // typ referencji wskazuje ktora metoda sie wykona,
        // ale obiekt na ktory referencja wskazuje, na ktorym obiekcie sie ta metoda wykona
        // w tej sutuacji kompilator nie widzi ze Hotel nie ma metody book(int)
        hotel.book(2);
        System.out.print(hotel.bookings);
    }
}