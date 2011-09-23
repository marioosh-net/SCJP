package test1;

class Vehicle {
    public void printSound() {
        System.out.print("vehicle");
    }
}

class Car extends Vehicle {
    public void printSound() {
        System.out.print("car");
    }
}

class Bike extends Vehicle {
    public void printSound() {
        System.out.print("bike");
    }
}

public class Casting {
    public static void main(String[] args) {
        Vehicle v = new Car();
        Bike b = (Bike) v;	// java.lang.ClassCastException: Car cannot be cast to Bike
        
        v.printSound();
        b.printSound();
    }   
}