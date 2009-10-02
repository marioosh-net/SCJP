package package1;

import java.io.Serializable;

// public - klasa dostepna poza pakietem
public class Public {

  EA f;
  String str;
  int test;
  int[] scores;
  final int i = 1;

  public static void main(String[] args) {
    new C();
    new Test6();
  }

  // w obrebie pakietu
  void func(int test, final int finalna) {

    // lokalne zmienne moge miec tylko final !!!!
    // private int local;    // error
    // protected int local2; // error
    final int local3; // ok

    str = new String();

    //test = test; // wrong!!!, no error
    // finalna = 20; // nie moze byc zmieniony bo jest final!!


    this.scores[0] = 1;

  }

// w dziedziczacyhc (nawet poza pakietem) i w obrebie pakietu, czyli
// jak default + w dziedziczacych (nawet poza pakietem)
  protected void func2() {
    int i;
  }

  private void privFunc() {
    
  }
}

// default - klasa dostepna wewatrz pakietu
class notPublic {

  notPublic() {
    Public p = new Public();
    p.func(1, 20);
  }
}

/**
 *
 *
 *
 *
 *
 *
 *
 * Access Modifiers
 * public, private, protected, default
 */
class F {

  int x;
  protected int y;

  F() {
  }

  // DOSTEPNOSC do membrow:

  // tylko wewnatrz klasy (lokalnie)
  private void privMeth() {
  }

  // wszedzie, publiczna (poza pakietem tez)
  public void pubMeth() {
  }

  // w obrebie pakietu + w dziedziczacych podklasach (nawet poza pakietem)
  protected void protMeth() {
    System.out.println("protMeth 1");
  }

  // w obrebie pakietu
  // default (think: package-level) access
  void Meth() {
  }
}

class EA extends F {

  EA() {
    this.y = 2;
    pubMeth();
  //privMeth(); //error
  }

  // overriding (przesloniecie)
  protected void protMeth() {
    System.out.println("protMeth 2");

  }

  // overloading (przeciazeni)
  protected void protMeth(int test) {

  }
}

/**
 *
 *
 *
 *
 *
 *
 * Abstract Classes
 */
// remember that if even a single method is abstract, the whole class must be declared abstract
abstract class B {

  B() {
    System.out.println("make B");

    F f = new F();
    f.y = 2;
    f.protMeth();

    this.testB();
  }

  final void cantChangeIt() {
  }
  

  void testB() {
    System.out.println("testB");
  }

  // abstract method cannot have a body
  // abstract void ab() {};
  abstract void ab();
}

class C extends B {

  String test;

  void testB() {
    System.out.println("testB_override");
    this.cantChangeIt();
  }

  void ab() {
  }
}

abstract class Abstract1 {

  abstract void abstractF1();

  abstract void abstractF2();
}

// tu nie musi byc implementacji metod bo klasa jest abstact
abstract class Abstract2 extends Abstract1 {

  abstract void abstractF3();
}

// tu juz musi byc implementacja metod bo klasa NIE jest abstact
class NotAbstract1 extends Abstract2 {

  void abstractF1() {
    int i = 1;
  }

  void abstractF2() {
  }

  void abstractF3() {
  }

  // overloading (przeciazenie)
  void abstractF3(int i) {
  }

  void doStuff(int... x) {
    System.out.println(x[0]);
  }
}

abstract class T {

  protected abstract void do1();

}

class TT extends T {
  // za slaby atrybut dostepu w stosunku do dziedziczonej kl. abstrakcyjnej
  /*
  void do1() {}
  private void do1() {}
   */
  

  // te definicje sa ok
  public void do1() {
  } /*
  protected void do1() {}*/

}

/** 
 * 
 * 
 * 
 * 
 * 
 * 
 * Interfaces  */
// Think of an interface as a 100-percent abstract class
interface I {

  // only constants!!! (domyslnie: public, static and final)
  String b = "";
  int a = 1;

  /*
  int b; //error, nie zainicjowane*/

  // metody w interfejsie domyslnie sa publiczne !!!!
  // implementujac w klasch tez musza byc publiczne!!!!
  void i1();

  int i2();
}

interface I2 extends I {
}

class D1 implements I {

  // definicja nie jest publiczna tak jak w interfejsie wiec ZLE!
  //void i1() {}
  public void i1() {
  } // tak juz OK

  public int i2() {
    return 1;
  }
}

class D extends B implements I {

  void ab() {
    // cannot assign value to final variable a
    // a = 2;
  }

  public int i2() {
    return 0;
  }

  public void i1() {
  }
}

/**
 *
 *
 *
 *
 *
 * Static Class - tylko jako klasa wewnetrzna (nested)
 */
class Outside {

  static class Nested {
  }
}

/**
 *
 *
 *
 *
 * Final Class */
// klasa final nie moze byc zmieniana i dziedziczona
final class FinalClass {

  void testA() {
    System.out.println("testA");
  }
}

// blad - nie mozna dziedziczyc z klasy final
/*
class F2 extends FinalClass {

}*/
/**
 *
 *
 *
 * Final method */
class Test2 {

  final void cantChangeIt() {
  }
}

class Test3 extends Test2 {
  // blad - metoda finalna nie moze byc zmieniana
  /*
  void cantChangeIt() {
  }*/

  // ok - przeciazenie (overload)
  void cantChangeIt(int i) {
  }
}

/**
 *
 *
 *
 *
 *
 * Final variables */
class Test1 {

  final int i = 1;
  final String str = new String();

  public void func() {
    // nie mozna zmienic referencji finalnego obiektu,
    // musi wskazywac zawsze na to samo
    // str = new String(); // error

    // final - nie mozna zmienic wartosci
    // i = 2;
  }
}

/**
 *
 *
 *
 * transient instant variables */
class Test4 implements Serializable {

  // transient - ta zmienna nie bedzie serializowana
  transient int i;

  void func() {
    // error: transient - tylko odnosnie zmiennych instancyjnych, nie lokalnych
    // transient int j;
  }
}

/**
 *
 *
 *
 * Static Variables and Methods
 */
class Test5 {

  private int j;
  static String str;

  static void func() {

    // error: non-static variable j cannot be referenced from a static context
    // System.out.println(j);

    // ok 
    System.out.println(str);
  }
}

class Test6 {

  Test6() {
    Test5 t1 = new Test5();
    Test5 t2 = new Test5();
    t1.str = "ala ma kota";
    System.out.println("t2.str = " + t2.str);
  }
}

/**
 *
 *
 *
 *
 * enums - cos jak klasa */

// outside class
enum CoffeeSize1 {

  BIG, HUGE, OVERWHELMING
};

class Test7 {
  // inside class 

  enum CoffeeSize {

    BIG, HUGE, OVERWHELMING
  } //; opcjonalnie

  void f() {
    CoffeeSize i = CoffeeSize.BIG;
  }

  void f2() {
    // error - nie moze byc lokalnie
    // enum CoffeeSize  {BIG, HUGE, OVERWHELMING  }
  }
}

enum CoffeeSize {

  BIG(8), HUGE(10), OVERWHELMING(16);
  // the arguments after the enum value are "passed"
  // as values to the constructor

  CoffeeSize(int ounces) {

    this.ounces = ounces; // assign the value to
  // an instance variable
  }
  private int ounces;      // an instance variable each enum
  // value has

  public int getOunces() {
    return ounces;
  }
}

class J {

  J() {
  }
}

/**
 *
 * finalna nie moze by dziedziczona
 */
final class X {
  int x = 1;
  {System.out.println("test");}
}
class Y extends X {
 
}

