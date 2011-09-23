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

public class VehicleTest {
    public static void main(String[] args) {
        Vehicle v = new Car();
        Car c = (Car) v;
        
        v.printSound();
        c.printSound();
    }   
}