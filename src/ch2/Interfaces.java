package ch2;

interface Device {

  public void doIt();
}

interface Device2 {

  public void doIt2();
}

public class Interfaces implements Device {

  public static void main(String args[]) {
    Test1 t = new Test1();
    Device d = new Test1();
    d.doIt();
    Device2 d2 = t;

  }

  public void doIt() {
  }
}

abstract class Phone1 extends Interfaces {
}

class Test1 implements Device, Device2 {

  public void doIt2() {
  }

  public void doIt() {
    System.out.println("ala ma kota");
  }
}

abstract class Phone2 extends Interfaces {

  public void doIt(int x) {
  }
}

class Phone3 extends Interfaces implements Device {

  public void doStuff() {
    for (int __x = 0; __x < 3; __x++);

  }
}

/**
 *
 *
 *
 * interfejs moze dziedziczyc interfejs!
 * ale nie moze implementowac zadnego kodu
 */
interface Inter3 extends Device {
  
}

interface Inter4 extends Inter3 {
}

/**
 *
 *
 *
 * i teraz ciekawostka - UWAGA!!!!!
 *
 * A class is not allowed to extend multiple classes in Java.
 * An interface, however, is free to extend multiple interfaces !
 */
interface Double extends Device, Device2 {
  // that's ok!
}

/**
 *
 *
 *
 * klasa abstrakcyjna moze dziedziczyc klase abstrakcyjna (TYLKO JEDEN),
 * interfejs moze dziedziczyc interfejs (LUB WIELE interfejsow)
 */


abstract class AbC1 {
}

abstract class AbC2 {
}

// tak nie mozna (dziedziczenie z wielu klas)
/*
abstract class AbClass extends AbC1, AbC2 {
}
*/


interface AbInter {
}

interface AbInterB {
}
// a tak mozna
interface AbInter2 extends AbInter, AbInterB {
}


// OK
abstract class Abstract1 implements Device {
}
abstract class Abstract2 implements Device {

	public void doIt() {
	}
}
// not OK
abstract class Abstract2 implements Device {
	public void doIt();
}
abstract class Abstract2 implements Device {
	abstract public void doIt();
}
                