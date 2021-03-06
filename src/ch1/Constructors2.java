package ch1;


public class Constructors2 {
  public static void main(String[] a) {
    new X();
  }
  Constructors2() {
    System.out.println("A");
  }
}

class X extends Constructors2 {
  X() {
    this(1); // wywolanie przeciazonego konstruktora, super() nie jest wolane w tym momencie!!
              // ale bedzie wolane w przeciazonym konstruktorze niejawnie
    System.out.println("B");
  }
  X(int i) {
    System.out.println("C");
  }

  // bledne proby wywolania konstruktorow w metodzie!!
  public void test() {
    this(); // moze byc tylko w konstruktorze (jako 1-sze wyrazenie), nie w metodzie
  }

  public void test2() {
    super(); // moze byc tylko w konstruktorze (jako 1-sze wyrazenie), nie w metodzie
  }
}

/**
 *
 *
 * kazda klasa, nawet abstrakcyjna ma przynajmniej jeden konstruktor
 */
abstract class IhaveContructor {
  IhaveContructor() {
    // it's ok
    this(1);
    System.out.println("1 [constructor]");
  }
  
  IhaveContructor(int i) {
    // it's ok
    System.out.println("2 [constructor]");
  }
}

class New extends IhaveContructor {
  New() {
    System.out.println("New [constructor]");
  }
}

// interfejsy nie maja konstruktorow!!!
interface IhaveNoContructor {
  IhaveNoContructor IhaveNoContructor();
  //IhaveNoContructor(); // error
}


/**
 *
 *
 *
 * pulapka
 * przyklad rekursywnego (blednego) wywolania konstruktora
 */
class A {
   A() {
     this("foo");
   }
   A(String s) {
      this();
   }
}